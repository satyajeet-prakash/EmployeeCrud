package com.spring.hibernate.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee savedEmp = service.addEmployee(emp);
		return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/all")
	public List<Employee> getAllEmployees() {
		logger.info("Request to get all employees list");
		return service.getAllEmployees();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Optional<Employee> empFetched = service.getEmployeeById(id);
		if(empFetched.isPresent()) {
			return new ResponseEntity<Employee>(empFetched.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee empDetails) {
		if(service.getEmployeeById(id).isPresent()) {
			Employee emp = service.getEmployeeById(id).get();
			emp.setName(empDetails.getName());
			emp.setDesignation(empDetails.getDesignation());
			emp.setCity(empDetails.getCity());
			
			final Employee updatedEmp = service.addEmployee(emp);
			return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Long> deleteEmployeeById(@PathVariable("id") Long id) {
		service.deleteEmployeedById(id);
		return new ResponseEntity<Long>(HttpStatus.OK);
	}
	
	@GetMapping("/delete/all")
	public ResponseEntity<Long> deleteAll() {
		service.deleteAllEmp();
		return new ResponseEntity<Long>(HttpStatus.OK);
	}
}
