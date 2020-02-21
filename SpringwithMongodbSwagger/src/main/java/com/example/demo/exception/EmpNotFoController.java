package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmpNotFoController extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EmpNotFoController() {
		// TODO Auto-generated constructor stub
		super();
	}
	public EmpNotFoController(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	@ExceptionHandler(value=EmpNotFoController.class)
	public ResponseEntity<Object> exception(EmpNotFoController exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
	/**
	 * 
	 */
}
