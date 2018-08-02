package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControllerClass {

	@RequestMapping("/test")
	public EmployeeDTO test() {
		EmployeeDTO dto=new EmployeeDTO("123", "Vamshi", "23", "123456789");
		return dto;
	}
}
