package com.example.LibraryManagement.SecurityConfiguration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.SignatureSpi;
import java.util.Date;

@Component
public class JwtTokenProvider {

    public String secret = "Felix@1076";

    public long expiration = 86400000;

    public String tokenPrefix ="Bearer";

    private final UserDetailsService userDetailsService;

    public JwtTokenProvider( UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String generateToken(String username){

        Date date = new Date();

        Date expiryDate = new Date(date.getTime() + expiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(date)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();

    }

    public String getUserNameFromToken(String token){

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){

        try {

            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token ){
        String username = getUserNameFromToken(token);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return  new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest httpServletRequest){

       String bearerToken = httpServletRequest.getHeader("Authorization");

       if(bearerToken != null && bearerToken.startsWith(tokenPrefix)){
          return bearerToken.substring(tokenPrefix.length());
       }

       return  null;

    }
}
