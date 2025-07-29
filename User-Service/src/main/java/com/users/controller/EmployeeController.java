package com.users.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.entity.Employee;
import com.users.entity.ModuleAccess;
import com.users.repository.EmployeeRepository;
import com.users.repository.ModuleAccessRepository;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModuleAccessRepository moduleAccessRepository;
	
	Employee employee;
	
	
	@GetMapping("/getEmployeeInfo")
	public Employee getEmployeeInfo(@RequestHeader("userName") String userName) {
		
		    employee=employeeRepository.findEmployeeByEmail(userName);
			return employee;

	}

	
	
	
	
	@GetMapping("/getEmployeeWithModuleAccess")
	public ResponseEntity<?> getEmploye(@RequestHeader("userName") String  userName){
		
		try {
			Map<String,Object> employeeDetails=new HashMap<String, Object>();
		Employee employee=employeeRepository.findEmployeeByEmail(userName);
		ModuleAccess module=moduleAccessRepository.findByEmployeeId(employee.getEmployeeId());
        
		employeeDetails.put("employeeInfo", employee);
		employeeDetails.put("moduleAccess", module);
		
		return ResponseEntity.ok(employee);
		
		}catch(Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
