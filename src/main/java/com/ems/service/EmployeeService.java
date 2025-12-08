package com.ems.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ems.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto dto);

	EmployeeDto getEmployee(Long employeeId);
	
	List<EmployeeDto> getAllEmployee();

	EmployeeDto updateEmployee(Long empId, EmployeeDto dto);
	
	void deleteEmployee(Long empId);

	Page<EmployeeDto> getEmployeeWithPagination(Pageable pageable);
   
}
