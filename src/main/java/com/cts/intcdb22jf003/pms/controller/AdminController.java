package com.cts.intcdb22jf003.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pms/admin/api")
public class AdminController {
	
	@GetMapping("/hello")
	
	public String hello()
	{
		return "Welcome";
	}

	
@PostMapping("/welcome")
	
	public String welcomeAdmin(@RequestBody String fullname)
	{
		return "Welcome "+fullname;
		
	}
}
