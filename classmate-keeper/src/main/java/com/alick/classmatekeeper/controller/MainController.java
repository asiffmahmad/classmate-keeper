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
	
	@GetMapping("/add")
	public String addSudentDetais() {
		
		return "working";
		
	}
	
	

}
