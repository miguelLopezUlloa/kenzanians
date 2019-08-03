package com.mikauran.kenzanians.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.UriComponentsBuilder;

import com.mikauran.kenzanians.model.Employee;
import com.mikauran.kenzanians.service.EmployeeService;

@SuppressWarnings("unused")
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080"})
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	

	/**
	 * Retrieve All Employees
	 * 
	 * @return
	 */
	@RequestMapping(value = "/employee/", method= RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllEmployees(){
		
		List<Employee> employees = employeeService.findAllEmployees();
		
		if(employees.isEmpty()){
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK );
	}
	
	
	/**
	 * Retrieve All Employees
	 * 
	 * @return
	 */
	@RequestMapping(value = "/employee_active/", method= RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllEmployeesActive(){
		
		List<Employee> employees = employeeService.findAllEmployeesActive();
		
		if(employees.isEmpty()){
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK );
	}
	
	/**
	 * Retrieve an Employee by Id
	 * 
	 * @param id
	 * @return ResponseEnity
	 */
	@RequestMapping(value = "/employee/{id}", method= RequestMethod.GET, 
			produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee>  getEmployee(@PathVariable("id")  Long id){
		
		System.out.println("Fetching Employee with id " + id);
		/*Optional<Employee> employee = employeeService.findById(id);
		
		if(employee.isPresent()) {
			
			Employee emplo = employee.get();
		}
		
		if(employee == null){
			System.out.println("Employee with id" + id + "not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.OK);*/
		
		
		return employeeService.findById(id)
		          .map(record -> ResponseEntity.ok().body(record))
		          .orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * This method create a new Employee
	 * 
	 * @param employee
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/employee/", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmployee(@Valid @RequestBody Employee employee, UriComponentsBuilder ucBuilder){
		
		System.out.println("Creating Employee " + employee.getEmployeeName());
		
		if(employeeService.isEmployeeExist(employee)){
			System.out.println("A Employee with name " + employee.getEmployeeName() + " alredy exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		employeeService.saveEmployee(employee);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri() );
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/** 
	 * This method help to update an Employee
	 * 
	 * @param id
	 * @param employee
	 * @return
	 */
	/*@RequestMapping(value = "/employee/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Employee>  updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
		
		System.out.println("Updating Employee " + id);
		
		Optional<Employee> currentEmployee = employeeService.findById(id);
		
		if(currentEmployee.isPresent()) {
			Employee emplo = currentEmployee.get();
			
			emplo.setEmployeeName(employee.getEmployeeName());
			emplo.setLast_name(employee.getLast_name());
			emplo.setMiddle_name(employee.getMiddle_name());
			emplo.setDob(employee.getDob());
			emplo.setDoe(employee.getDoe());
			emplo.setStatus(employee.getStatus());
			emplo.setAddress(employee.getAddress());
			emplo.setEmail(employee.getEmail());
			
			employeeService.updateEmployee(emplo); 
		}else {
			System.out.println("Employee with id " + id + "not found");
			new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/employee/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Employee>  updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
		
		System.out.println("Updating Employee " + id);
		
		return employeeService.findById(id)
		        .map(emplo -> {
		        	emplo.setEmployeeName(employee.getEmployeeName());
					emplo.setLast_name(employee.getLast_name());
					emplo.setMiddle_name(employee.getMiddle_name());
					emplo.setDob(employee.getDob());
					emplo.setDoe(employee.getDoe());
					emplo.setStatus(employee.getStatus());
					emplo.setAddress(employee.getAddress());
					emplo.setEmail(employee.getEmail());
		            
		            Employee updated = employeeService.updateEmployee(emplo);
		            
		            return ResponseEntity.ok().body(updated);
		        }).orElse(ResponseEntity.notFound().build());
		
	}
	
	
	/**
	 * 
	 * This method help to delete an Employee
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/employee/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		System.out.println("Fetching and Deleting Employee with id " + id);
		
		 return employeeService.findById(id)
        .map(employee -> {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
	/**
	 * This method help to delete all Employees
	 * 
	 * @return
	 */
	@RequestMapping(value = "/employee/", method= RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteAllEmployees(){
		System.out.println("Deleting All Employees");
		
		employeeService.deleteAllEmployees();
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
	
	
}//End class
