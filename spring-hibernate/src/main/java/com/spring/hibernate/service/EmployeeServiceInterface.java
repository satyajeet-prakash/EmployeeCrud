package com.spring.hibernate.service;

import java.util.List;
import java.util.Optional;

import com.spring.hibernate.entity.Employee;

public interface EmployeeServiceInterface {

	List<Employee> getAllEmployees();
	
	Employee addEmployee(Employee emp);

	Optional<Employee> getEmployeeById(Long id);
	
	void deleteEmployeedById(Long id);
	
	void deleteAllEmp();
}
