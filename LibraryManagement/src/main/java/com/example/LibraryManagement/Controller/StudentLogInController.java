package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Entity.StudentDetails;
import com.example.LibraryManagement.Repository.StudentDetailsRepository;
import com.example.LibraryManagement.Repository.StudentLogInRepository;
import com.example.LibraryManagement.SecurityConfiguration.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("studentLogIn")
public class StudentLogInController {

    @Autowired
    private StudentLogInRepository studentLogInRepo;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/logIn")
    public ResponseEntity<Object> logIn(@RequestParam("userName") String userName ,@RequestParam("password") String password){

        Map<String,Object> studentList = new LinkedHashMap<>();

        Map<String, Object> map = studentLogInRepo.studentDetails(userName, password);

        String token = jwtTokenProvider.generateToken(userName);

        studentList.put("studentDetails",map);

        studentList.put("jwtToken",token);

        return ResponseEntity.ok(studentList);

    }
}
