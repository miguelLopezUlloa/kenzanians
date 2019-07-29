package com.mikauran.kenzanians.repository;

import org.springframework.data.repository.CrudRepository;

import com.mikauran.kenzanians.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	public Employee findByEmployeeName(String name);
}
