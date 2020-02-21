package com.example.demo.resource;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;
import java.util.logging.*;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.Employee;
import com.example.demo.services.employee.EmployeeDAL;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
@RequestMapping("user/employee")
//@Api(value = "EmployeeControllerAPI")

@RestController

public class EmpController {

	
	@Autowired
	private EmployeeDAL empDal;
	
	
	@GetMapping(value = "/")
	public List<Employee> getAllEmployee()
	{
		
		return empDal.getAllEmployee();
	} 	
	@RequestMapping(value = "/user/{emp_id}", method = RequestMethod.GET)
	@ApiOperation(value="Find employee by ID",notes="Get employee by specfic employee",response = Contact.class)
	//public ResponseEntity<Object> getEmployeeById(@PathVariable String emp_id,@RequestBody Employee emp) {
		public Optional<Employee>getEmployeeById(@ApiParam(value="The given is get the detials about employee")@PathVariable String emp_id)	
		{
		
		//Optional <Employee> u=  
		return empDal.getEmployeeById(emp_id);
		
			
	}

	
	@RequestMapping(value="/admin/create",method=RequestMethod.POST)
	@ApiOperation(value="Insert a new employee",notes="Give the detail about employee",response = Contact.class)
	public String addNewEmployee(Employee emp)
	{	
		System.out.println(emp);
	
		return empDal.addNewEmployee(emp);
		
		 
	}
	@RequestMapping(value="/admin/delete/{emp_id}",method=RequestMethod.GET)
	@ApiOperation(value="Delete employee by ID",notes="Delete employee by specfic employee id",response = Contact.class)
	public String deleteEmployee(@PathVariable String emp_id)
	{
		return empDal.deleteEmployee(emp_id);
		
	}
	@GetMapping(value="/admin/update/{emp_id}")
	public String updateEmployee(@RequestBody Employee emp)
	{
		
		 empDal.updateEmployee(emp);
		 return "Upadte";
		
	}
	
//	@RequestMapping(value = "/{company_id}", method = RequestMethod.GET)
//	public Optional <Employee> getCompanyById(@PathVariable String company_id) {
//			
//		Optional <Employee> u=  empDal.getEmployeeById(company_id);
//			return u;
			
//	}
	
		
		
		
	
}
