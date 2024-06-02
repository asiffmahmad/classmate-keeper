package com.alick.classmatekeeper.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MainMenu")
public class MainController {
	
	
	
	@PostMapping("/")
	public String test() {
		
		return "controller is up";
		
	}
	
	@PostMapping("/addStudent")
	public String addSudentDetais() {
		
		return "working";
		
	}
	
	
	
	@PostMapping("/updateStudent")
	public String updateSudentDetais() {
		
		return "working";
		
	}
	
	
	@PostMapping("/deleteStudent")
	public String deleteudentDetais() {
		
		return "working";
		
	}
	
	
	@GetMapping("/viewStudentdetails")
	public String viewSudentDetais() {
		
		return "working";
		
	}
	
	@GetMapping("/viewStudentdetails")
	public String viewSudentDetaisById() {
		
		return "working";
		
	}
	
	

}
