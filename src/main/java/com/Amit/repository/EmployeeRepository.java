package com.Amit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Amit.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
public List<Employee> findByEmpAgeLessThan(int empAge);	

//public Employee findByEmpEmailAndPassword(String empEmail,String password);

}
