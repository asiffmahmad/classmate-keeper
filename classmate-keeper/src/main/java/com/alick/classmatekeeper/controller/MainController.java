package com.alick.classmatekeeper.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alick.classmatekeeper.model.StudentDetails;
import com.alick.classmatekeeper.service.StudentDetailService;

@RestController
@RequestMapping("/MainMenu")
public class MainController {

	@Autowired
	StudentDetailService StudentDetailService;
	
	

	@PostMapping("/")
	public String test() {

		return "controller is up";

	}

	@PostMapping("/addStudent")
	public ResponseEntity<String> addSudentDetais(@RequestBody Map<String, Object> studentData) {

		return StudentDetailService.addStudentDetails(studentData);

	}

	@PostMapping("/updateStudent")
	public ResponseEntity<String> updateSudentDetais(@RequestBody Map<String, Object> map) {
		return StudentDetailService.updateSudentDetais(map);
		

	}

	@PostMapping("/deleteStudent")
	public ResponseEntity<String> deleteudentDetais(@RequestBody Map<String, Object> map) {
		return StudentDetailService.deleteStudentDetails(map);

	}

	@GetMapping("/viewStudentdetails")
	public List<StudentDetails> viewSudentDetais() {

		return StudentDetailService.viewAllDetails();

	}

	@GetMapping("/viewStudentdetailsByMail/{mail}")
	public StudentDetails viewSudentDetaisByMail(@PathVariable String mail) {
	    return StudentDetailService.viewDetailsBymail(mail);
	}


}
