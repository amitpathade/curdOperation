package com.Amit.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.Amit.entities.Employee;
import com.Amit.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee SaveEmployee(Employee emp) {
	Employee save=	 employeeRepository.save(emp);
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}

	@Override
	public List<Employee> SavaAllEmployee(List<Employee> list) {
		List<Employee> saveAll = employeeRepository.saveAll(list);
		return saveAll;
	}

	@Override
	public Employee getEmployeeById(int Id) {
		Employee findById = employeeRepository.findById(Id).get();
		return findById;
	}

	@Override
	public Employee getEmployeeByIdQuryparameter(int Id) {
		Employee findById = employeeRepository.findById(Id).get();
		return findById;
	}

	@Override
	public List<Employee> getAgeLessThan(int empAge) {
		List<Employee> list = employeeRepository.findByEmpAgeLessThan(empAge);
		
		
		return list;
	}

	@Override
	public Employee UpdateEmployee(Employee emp) {
		Employee save = employeeRepository.save(emp);
		
		return save;
	}

	@Override
	public List<Employee> UpdateAllEmployee(List<Employee> list) {
		List<Employee> saveAll = employeeRepository.saveAll(list);
		return saveAll;
	}
//
//	@Override
//	public boolean LoginCheck(String email, String password) {
//		Employee employee = employeeRepository.findByEmpEmailAndPassword(email, password);
//		if(employee !=null) {
//			return true;
//		}else
//		return false;
//	}

	@Override
	public boolean DeleteEmpById(int id) {
		
		boolean existsById = employeeRepository.existsById(id);
		if(existsById) {
		employeeRepository.deleteById(id);
		
		return true;
		
	}else {
		return false;
	}


}

	@Override
	public boolean DeleteAllEmployee() {
		
		List<Employee> findAll = employeeRepository.findAll();
		if(findAll !=null) {
		employeeRepository.deleteAll();
		return true;
		}else {
			return false;
		}
	}

//	@Override
//	public boolean LoginCheck(String email, String password) {
//	Employee findByEmpEmailAndPassword = employeeRepository.findByEmpEmailAndPassword(email, password);
//		if(findByEmpEmailAndPassword==null) {
//			return false;
//		}
//		else {
//			return true;
//		}
//	}
}



