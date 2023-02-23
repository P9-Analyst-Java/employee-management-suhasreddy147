package com.deloitte.portal.dao;

import java.util.List;

import com.deloitte.portal.model.Employee;

public interface EmployeeDao {

	List<Employee> getAll();
	
	int deleteById(int id);
	
	int addOrUpdateEmployee(Employee e);
	
	Employee searchEmployeeById(int id);
	
	List<Employee> searchEmployeeByNameAndGender(String name, String gender);
	
}
