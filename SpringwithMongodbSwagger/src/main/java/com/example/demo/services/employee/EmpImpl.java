package com.example.demo.services.employee;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domains.Employee;
import com.example.demo.exception.EmpNotFoController;
import com.example.demo.repositories.EmployeeRespo;
import com.example.demo.services.company.CompanyDAL;



@Service
public class EmpImpl implements EmployeeDAL{
	
	
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MongoTemplate template;
	
	
	@Autowired
	private EmployeeRespo empresp;
	
	@Autowired
	private CompanyDAL comresp;
	// Employee e1;
	
	
	public List<Employee>getAllEmployee()
	{
		
		log.info("Get all employee");
		return template.findAll(Employee.class);
	}
	
	//public ResponseEntity<Object>getEmployeeById(String emp_id,Employee emp)
	public Optional<Employee> getEmployeeById(String emp_id)
	{
		return empresp.findById(emp_id);
		
		
		/*
		 * log.info("Get  employee By id");
		 * 
		 * Optional<Employee> emp1=empresp.findById(emp_id); if(emp1.isPresent()) {
		 * return new ResponseEntity<>("Employee found", HttpStatus.OK);
		 * 
		 * } else { throw new EmpNotFoController("Employee not find"); }
		 */
		
		
		
	}
	public String addNewEmployee(Employee emp)
	{
		
		
		String s=emp.getCompany_id();
		
		boolean b=comresp.IsCompanyIsExsists(s);
		if(b==true)
		{
			log.info("Add a employee");
			empresp.save(emp);
			
			return "employee "+emp.getEmp_name()+" inserted Successfully";
			
		}
		else
		{
			log.error("Company not valid");
			
					
					return "Not inserted";
		}
	
	}
	public String deleteEmployee(String emp_id)
	{
		Optional<Employee> emp=empresp.findById(emp_id);
		empresp.deleteById(emp_id);
		log.info("Get deleted employee");
		return "Employee "+emp.get()+"Deleted";
		
	}
	
	
	public String updateEmployee(Employee emp)
	{
		
		log.info("Updated employee");
		empresp.save(emp);
		return "Updated";
	}

	
	
	
		
	
}
	
	
	
	
	
	
	

