package com.ems.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.DepartmentDto;
import com.ems.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DeparmentControlller {
	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto departmentDtos = departmentService.createDepartment(departmentDto);
		return new ResponseEntity<>(departmentDtos,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long id){
		DepartmentDto departmentDto = departmentService.getDepartment(id);
		return ResponseEntity.ok(departmentDto);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllEmployee(){
		List<DepartmentDto> allDepartment = departmentService.getAllDepartment();
		return ResponseEntity.ok(allDepartment);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto,@PathVariable(name= "id") Long deptId){
		DepartmentDto updateDepartment = departmentService.updateDepartment(deptId, departmentDto);
		return new ResponseEntity<>(updateDepartment,HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable(name = "id") Long deptId){
		departmentService.deleteDepartment(deptId);
		return new ResponseEntity<>("Department Deleted Suceessfilly : " + deptId,HttpStatus.OK);
	}
}
