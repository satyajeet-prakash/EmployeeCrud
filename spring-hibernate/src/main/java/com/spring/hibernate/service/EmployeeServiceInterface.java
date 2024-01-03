package com.spring.hibernate.service;

import java.util.List;

import com.spring.hibernate.entity.Employee;

public interface EmployeeServiceInterface {

	List<Employee> getAllEmployees();
	
	Employee addEmployee(Employee emp);

	Employee getEmployeeById(Long id);
}
