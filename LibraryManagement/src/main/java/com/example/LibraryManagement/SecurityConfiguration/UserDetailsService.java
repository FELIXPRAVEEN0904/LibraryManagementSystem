package com.example.LibraryManagement.SecurityConfiguration;

import com.example.LibraryManagement.Entity.StudentLogIn;
import com.example.LibraryManagement.Exception.CustomException.NotFoundException;
import com.example.LibraryManagement.Repository.StudentLogInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private StudentLogInRepository studentLogInRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       StudentLogIn logInDetails = studentLogInRepository.findByUsername(username);
       if (logInDetails == null){
           try {
               throw new NotFoundException("User Not Found",HttpStatus.FORBIDDEN);
           } catch (NotFoundException e) {
               throw new RuntimeException(e);
           }
       }
        return new User(logInDetails.getUsername(),logInDetails.getPassword(), Collections.EMPTY_LIST);
    }
}
