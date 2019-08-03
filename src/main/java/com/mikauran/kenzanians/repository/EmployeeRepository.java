package com.mikauran.kenzanians.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mikauran.kenzanians.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	public Employee findByEmployeeName(String name);
	
    @Query("SELECT e FROM Employee e WHERE e.status ='ACTIVE' ")
	public List<Employee> findAllEmployeesActive();
	

}
