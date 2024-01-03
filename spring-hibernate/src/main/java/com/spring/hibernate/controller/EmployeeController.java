package com.spring.hibernate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.entity.Employee;
import com.spring.hibernate.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeServiceInterface service;
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		logger.info("Request to get all employees list");
		return service.getAllEmployees();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee savedEmp = service.addEmployee(emp);
		return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> addEmployee(@PathVariable("id") Long id) {
		Employee empFetched = service.getEmployeeById(id);
		return new ResponseEntity<Employee>(empFetched, HttpStatus.CREATED);
	}
}
