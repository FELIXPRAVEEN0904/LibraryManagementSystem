package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Entity.StudentDetails;
import com.example.LibraryManagement.Repository.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("student_details")
public class StudentDetailsController {

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    @PostMapping ("/add")
    public ResponseEntity<Object> add(@RequestBody StudentDetails studentDetails){
        StudentDetails save = studentDetailsRepository.save(studentDetails);
        return ResponseEntity.ok(save);

    }

    @PostMapping("/addAll")
    public ResponseEntity<Object> addAll(@RequestBody List<StudentDetails> studentDetails){
        List<StudentDetails> save = studentDetailsRepository.saveAll(studentDetails);
        return ResponseEntity.ok(save);

    }

    @GetMapping ("/findById")
    public ResponseEntity<Object> findById(@RequestParam("id") Integer id){
        Optional<StudentDetails> save = studentDetailsRepository.findById(id);
        return ResponseEntity.ok(save);

    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody StudentDetails studentDetails){
        StudentDetails save = studentDetailsRepository.save(studentDetails);
        return ResponseEntity.ok(save);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteById(@RequestParam("id") Integer id){
        studentDetailsRepository.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully id :"+id);

    }
}