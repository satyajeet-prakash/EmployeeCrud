package com.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.entity.Employee;
import com.spring.hibernate.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repository;
	
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
}
