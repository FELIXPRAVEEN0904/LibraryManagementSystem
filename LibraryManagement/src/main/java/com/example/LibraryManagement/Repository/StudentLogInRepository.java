package com.example.LibraryManagement.Repository;

import com.example.LibraryManagement.Entity.StudentDetails;
import com.example.LibraryManagement.Entity.StudentLogIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface StudentLogInRepository extends JpaRepository<StudentLogIn,Integer> {

    @Query(value ="select msd.name,msd.mobile_number,msd.email from m_student_Details msd left join m_student_log_in msli on msd.id=msli.id\n" +
                  "where msli.username=:username and msli.password =:password",nativeQuery = true)
    public Map<String,Object> studentDetails(@Param("username") String username, @Param("password") String password);


    StudentLogIn findByUsername(String username);
}
