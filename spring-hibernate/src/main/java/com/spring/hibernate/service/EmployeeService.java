package com.spring.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.entity.Employee;
import com.spring.hibernate.repo.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	private EmployeeRepo repository;

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return repository.save(emp);
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteEmployeedById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAllEmp() {
		repository.deleteAll();
	}
	
	
}
