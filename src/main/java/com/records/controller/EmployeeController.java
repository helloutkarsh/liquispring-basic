package com.records.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.records.models.Employee;
import com.records.repository.EmployeeRepository;
import com.records.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/") @ResponseBody
		public String home() {
		System.out.println("home working!");
			return "You're up and running!";
		}
	
	@PostMapping("/add")@ResponseBody
		public String addEmployee(@RequestBody Employee emp) {
		
		System.out.println("<--- Receiving employee details from API call --->");
		if(emp.getEmpid().equalsIgnoreCase(empService.checkEmpid(emp.getEmpid()))) {
			return "Employee ID already Exists!";
		}
		else {
			empService.addEmployee(emp);
			return "Success!";
		}
		
	}
}
