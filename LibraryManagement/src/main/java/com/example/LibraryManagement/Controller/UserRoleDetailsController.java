package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Repository.UserRoleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userDetailsController")
public class UserRoleDetailsController {

    @Autowired
    private UserRoleDetailsRepository userRoleDetailsRepository;
}
