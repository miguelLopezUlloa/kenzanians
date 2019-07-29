package com.mikauran.kenzanians.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
import javax.persistence.Table;

//import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@SuppressWarnings("serial")
@Entity
@Table(name="employees")
//@EntityListeners(AuditingEntityListener.class)
public class Employee implements Serializable {
	
	@SuppressWarnings("unused")
	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String employeeName;
	
	@Column 
	private String last_name;
	
	@Column
	private String middle_name;
	
	@Column
	private String address;
	
	@Column
	private String email;
	
	@Column
	private LocalDate dob;
	
	@Column
	private LocalDate doe;
	
	@Column
	private String status;
	
	public Employee(){

	}

	
	
	/**
	 * @param id
	 * @param employeeName
	 * @param last_name
	 * @param address
	 * @param email
	 */
	public Employee(Long id, String employeeName, String last_name, String middle_name, String address, String email,
			LocalDate dob, LocalDate doe, String status) {
		//super();
		this.id = id;
		this.employeeName = employeeName;
		this.last_name = last_name;
		this.middle_name = middle_name;
		this.address = address;
		this.email = email;
		this.dob = dob;
		this.doe = doe;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoe() {
		return doe;
	}

	public void setDoe(LocalDate doe) {
		this.doe = doe;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", last_name=" + last_name + ", middle_name="
				+ middle_name + ", address=" + address + ", email=" + email + ", dob=" + dob + ", doe=" + doe
				+ ", status=" + status + "]";
	}

	

}
