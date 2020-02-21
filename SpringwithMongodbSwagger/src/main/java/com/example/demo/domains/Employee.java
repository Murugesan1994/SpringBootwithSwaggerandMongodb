package com.example.demo.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Document(collection="Company")
@ApiModel(description = "This class detaila about employee")
public class Employee {
	@Id
	@ApiModelProperty(notes="The unique Id for employee")
	private String emp_id;
	@ApiModelProperty(notes="The name for employee")
	private String emp_name;
	
	/*
	 * public Employee(String emp_id, String emp_name, String company_id, String
	 * company_name) { super(); this.emp_id = emp_id; this.emp_name = emp_name;
	 * this.company_id = company_id; this.company_name = company_name; }
	 */
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	@ApiModelProperty(notes="The company Id for employee")
	private String company_id;
	@ApiModelProperty(notes="The company name for employee")
	private String company_name;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", company_id=" + company_id
				+ ", company_name=" + company_name + "]";
	}
	

	
	
	
}
	
	


