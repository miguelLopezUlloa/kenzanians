package com.mikauran.kenzanians.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikauran.kenzanians.model.Employee;
import com.mikauran.kenzanians.repository.EmployeeRepository;
import com.mikauran.kenzanians.service.EmployeeService;


@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> findAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	
	public Employee findByName(String name) {
		return employeeRepository.findByEmployeeName(name);
	}

	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	//Old Style support not functional programming
	/*public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}*/

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}

	
	public boolean isEmployeeExist(Employee employee) {
		return findByName(employee.getEmployeeName()) !=null;
	}
	

}
