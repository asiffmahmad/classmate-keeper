package com.alick.classmatekeeper.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.alick.classmatekeeper.model.StudentDetails;
import com.alick.classmatekeeper.repo.StudentDetailsRepository;
import com.alick.classmatekeeper.validation.DateUtils;

import jakarta.transaction.Transactional;

@Service
public class StudentDetailService {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;

	public ResponseEntity<String> addStudentDetails(Map<String, Object> studentData) {
		StudentDetails studentDetails = null;

		try {
			studentDetails = new StudentDetails();
			studentDetails.setFirstName((String) studentData.get("firstName"));
			studentDetails.setLastName((String) studentData.get("lastName"));
			Date date = DateUtils.parseDate((String) studentData.get("dateOfBirth"), "yyyy-MM-dd");
			studentDetails.setDateOfBirth(date);
			studentDetails.setAddress1((String) studentData.get("address1"));
			studentDetails.setAddress2((String) studentData.get("address1"));
			studentDetails.setPhoneNumber1((String) studentData.get("address1"));
			studentDetails.setPhoneNumber2((String) studentData.get("address2"));
			studentDetails.setEmail((String) studentData.get("email"));
			studentDetailsRepository.save(studentDetails);

			return new ResponseEntity<>("Student with ID added successfully", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@Transactional
	public ResponseEntity<String> deleteStudentDetails(Map<String, Object> map) {
		StudentDetails studentDetails = null;
		try {
			studentDetails = new StudentDetails();

			String emial = (String) map.get("email");

			System.out.println(emial);

			studentDetailsRepository.deleteByemail(emial);
			return new ResponseEntity<>("Student details deleted successfully", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<StudentDetails> viewAllDetails() {

		try {
			return studentDetailsRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public StudentDetails viewDetailsBymail(String mail) {
		try {
			return studentDetailsRepository.findByEmail(mail);

		} catch (Exception e) {
			return null;
		}
	}

	public ResponseEntity<String> updateSudentDetais(Map<String, Object> studentData) {
		StudentDetails studentDetails = null;
		try {

			String email = (String) studentData.get("email");

			// Retrieve the existing student details from the database using email
			 studentDetails = studentDetailsRepository.findByEmail(email);

			if (studentDetails != null) {
				String address1 = (String) studentData.get("address1");
				String address2 = (String) studentData.get("address2");
				String phoneNumber1 = (String) studentData.get("phoneNumber1");
				String phoneNumber2 = (String) studentData.get("phoneNumber2");

				if (address1 != null) {
					studentDetails.setAddress1(address1);
				}

				if (address2 != null) {
					studentDetails.setAddress2(address2);
				}

				if (phoneNumber1 != null) {
					studentDetails.setPhoneNumber1(phoneNumber1);
				}

				if (phoneNumber2 != null) {
					studentDetails.setPhoneNumber2(phoneNumber2);
				}
				StudentDetails updatedStudent = studentDetailsRepository.save(studentDetails);
				
			}
			return new ResponseEntity<>("Sucess", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
