package com.testing.pdev.service;

import java.util.List;

import com.testing.pdev.model.Employee;

public interface EmployeeDAO {

	void persist(Employee transientInstance);
	List<Employee> getEmployeeNameQuery(String param);
	void remove(Employee persistentInstance);
	Employee merge(Employee detachedInstance);
	Employee findById(int id) throws Exception;
	
}
