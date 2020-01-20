package com.eats.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eats.model.Employee;
import com.eats.repository.EmployeeRepository;
import com.eats.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository; 
	
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

}
