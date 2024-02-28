package com.example.LibraryManagement.Repository;

import com.example.LibraryManagement.Entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails,Integer> {
}
