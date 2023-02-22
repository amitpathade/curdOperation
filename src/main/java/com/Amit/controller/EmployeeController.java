package com.Amit.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Amit.entities.Employee;
import com.Amit.service.EmployeeServiceI;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@PostMapping(value="/saveEmployee",consumes= {"application/xml","application/json"},produces= {"Application/xml","application/json"})
	public ResponseEntity<Employee> SaveEmployee(@RequestBody Employee emp){
	
			Employee employee=employeeServiceI.SaveEmployee(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		
	}

	@GetMapping(value="/getAllEmployee",produces={"application/json","application/xml"})
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> allEmployee = employeeServiceI.getAllEmployee();
		
		return new ResponseEntity<	List<Employee>>(allEmployee,HttpStatus.OK);
		
	}
	@PostMapping(value="/SaveAllEmployee",consumes= {"application/xml","application/json"},produces= {"Application/xml","application/json"})
	public ResponseEntity<List<Employee>> SavaAllEmployee( @RequestBody List<Employee> list){
		System.out.println(list);
		List<Employee> savaAllEmployee = employeeServiceI.SavaAllEmployee(list);
		
		return new ResponseEntity<List<Employee>>(savaAllEmployee,HttpStatus.CREATED);
		
	}
	@GetMapping(value="/getEmployeeIdPathParam/{Id}",produces={"application/json"})
	public ResponseEntity<Employee> getEmployeeIdPathParam(@PathVariable int Id){

		 
		Employee employeeById = employeeServiceI.getEmployeeById(Id);
		
		return new ResponseEntity<Employee> (employeeById,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getEmployeeIdquryParameter",produces={"application/json"})
	public ResponseEntity<Employee> getEmployeeIdquryParameter(@RequestParam int Id){

		 
		 Employee employeeByIdQuryparameter = employeeServiceI.getEmployeeByIdQuryparameter(Id);
		
		return new ResponseEntity<Employee> (employeeByIdQuryparameter,HttpStatus.OK);
		
	
	}
	
	@GetMapping(value="/getAgeLessThan/{empAge}",produces={"application/json"})
	public ResponseEntity<List<Employee>> getAgeLessThan(@PathVariable int empAge){
		List<Employee> list = employeeServiceI.getAgeLessThan(empAge);
		return new ResponseEntity<List<Employee>> (list,HttpStatus.OK) ;
		
			
	}
	@PutMapping(value="/UpdateEmployee",consumes= {"application/xml","application/json"},produces= {"Application/xml","application/json"})
	public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee emp){
		
		Employee employee=employeeServiceI.UpdateEmployee(emp);
	return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	
}
	@PutMapping(value="/UpdateAllEmployee",produces= {"Application/xml","application/json"})
	public ResponseEntity<List<Employee>> UpdateAllEmployee( @RequestBody List<Employee> list){
		System.out.println(list);
		List<Employee> savaAllEmployee = employeeServiceI.UpdateAllEmployee(list);
		
		return new ResponseEntity<List<Employee>>(savaAllEmployee,HttpStatus.CREATED);
	
}
//	@GetMapping(value="/localCheck/{empEmail}/{password}")
//	public ResponseEntity<String> localCheck(@PathVariable String empEmail,@PathVariable String password){
//		boolean loginCheck = employeeServiceI.LoginCheck(empEmail, password);
//		if(loginCheck) {
//			String msg="login sucessfull";
//			return new ResponseEntity<String>(msg,HttpStatus.OK);
//			
//		}else {
//			String msg1="login Unsucessfull";
//			return new ResponseEntity<String>(msg1,HttpStatus.OK);  
//		}
//		
		
		
			//}
		@DeleteMapping("/DeleteEmpById/{Empid}")
	public ResponseEntity<String> DeleteEmpById(@PathVariable int Empid){
		boolean deleteEmpById = employeeServiceI.DeleteEmpById(Empid);
		if(deleteEmpById) {
			
			return new ResponseEntity<String>("id deleted", HttpStatus.OK);
		}else{
		
		return new ResponseEntity<String>("id  not deleted", HttpStatus.OK);
		
		}}
		
		@DeleteMapping("/DeleteAll/{Empid}")
		public ResponseEntity<String> DeleteAll(){
			boolean deleteEmpById = employeeServiceI.DeleteAllEmployee();
			if(deleteEmpById) {
				
				return new ResponseEntity<String>("Allid deleted", HttpStatus.OK);
			}else{
			
			return new ResponseEntity<String>("Allid  not deleted", HttpStatus.OK);
			
			}
		}
	
	
	

}


