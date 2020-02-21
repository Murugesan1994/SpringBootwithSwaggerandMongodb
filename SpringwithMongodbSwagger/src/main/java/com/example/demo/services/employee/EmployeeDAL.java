package com.example.demo.services.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.domains.Employee;

public interface EmployeeDAL {

	List<Employee>getAllEmployee();
	Optional<Employee>getEmployeeById(String emp_id); 
	String addNewEmployee(Employee emp);
	
	
	String deleteEmployee(String  emp_id);
	String updateEmployee( Employee emp);
		
}
