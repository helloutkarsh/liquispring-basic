package com.records.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.records.models.Employee;
import com.records.repository.EmployeeRepository;

@Service // specialized form of @Component; shows that the class provides some business logic
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository EmpRepo;
	
	public void addEmployee(Employee e) {
		EmpRepo.save(e);
		System.out.println("Saved: "+ e.toString());
	}
	public String checkEmpid(String empid) {
		if(EmpRepo.findEmployeeByEmpid(empid)!=null) return empid;
		else return "-1";
	}
}