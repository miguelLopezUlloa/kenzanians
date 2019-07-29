package com.mikauran.kenzanians.service;

import java.util.List;
import java.util.Optional;

import com.mikauran.kenzanians.model.Employee;

public interface EmployeeService {

	Optional<Employee> findById(Long id);
	
	Employee findByName(String name);
	
	void saveEmployee(Employee Employee);
	
	//void updateEmployee(Employee Employee);
	
	Employee updateEmployee(Employee Employee);
	
	void deleteEmployeeById(Long id);
	
	List<Employee> findAllEmployees();
	
	void deleteAllEmployees();
	
	public boolean isEmployeeExist(Employee Employee);
	
}
