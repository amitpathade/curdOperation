package com.Amit.service;

import java.util.List;

import com.Amit.entities.Employee;

public interface EmployeeServiceI {
	
	public Employee SaveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(int Id);
	
	public Employee getEmployeeByIdQuryparameter(int Id);
	
	public List<Employee> SavaAllEmployee(List<Employee> list);

	public List<Employee> getAgeLessThan(int empAge);
	
	public Employee UpdateEmployee(Employee emp);
	
	public List<Employee> UpdateAllEmployee(List<Employee> list);
	
	public boolean DeleteEmpById(int id);
	
	public boolean DeleteAllEmployee();
	
//	public boolean LoginCheck(String email,String password);
}
