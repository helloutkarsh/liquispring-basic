package com.records.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.records.models.Employee;

@Repository //provides indication that this interface emphasizes CRUD operations | not necessary for interface who are extending to the JPA repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findEmployeeByEmpid(String empid);
}
