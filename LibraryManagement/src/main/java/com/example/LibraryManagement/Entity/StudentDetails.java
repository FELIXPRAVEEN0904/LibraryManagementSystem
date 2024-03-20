package com.example.LibraryManagement.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table (name = "m_student_details")
public class StudentDetails {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "email")
    private String email;


    @OneToOne
    @JoinColumn(name="student_log_in_id")
    private StudentLogIn studentLogIn;
}
