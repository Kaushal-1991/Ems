package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	//Create Employee
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto dto) {
		EmployeeDto empDto = employeeService.createEmployee(dto);	
		return new ResponseEntity<>(empDto,HttpStatus.CREATED);
		
	}
	
	//Get Employee
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId){
		EmployeeDto empDto = employeeService.getEmployee(employeeId);
		return ResponseEntity.ok(empDto);
	}
	
	//Get All Employee
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
		return ResponseEntity.ok(allEmployee);
	}
	
	//Update Employee
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId,@RequestBody EmployeeDto dto){
		EmployeeDto empDto = employeeService.updateEmployee(empId,dto);
		return new ResponseEntity<>(empDto,HttpStatus.CREATED);
	}
	
	//Update Employee
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empId){
		employeeService.deleteEmployee(empId);
		return ResponseEntity.ok("Employee deleted successfully with ID: " + empId);
	}
}
