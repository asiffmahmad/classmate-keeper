package com.alick.classmatekeeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alick.classmatekeeper.model.StudentDetails;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {
    
    // Custom method to find a student by their email
    StudentDetails findByEmail(String email);

    // Custom method to find students by their first name
    List<StudentDetails> findByFirstName(String firstName);

    // Custom method to find students by their last name
    List<StudentDetails> findByLastName(String lastName);

    // Custom method to find students by a part of their address
    List<StudentDetails> findByAddress1Containing(String addressPart);

	void deleteByemail(String string);
}

