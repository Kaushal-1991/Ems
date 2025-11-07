package com.ems.mapper;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;

public class EmployeeMapper {
   
	public static EmployeeDto mapToDto(Employee emp) {
		return new EmployeeDto(
		   emp.getId(),
		   emp.getFirstName(),
		   emp.getLastName(),
		   emp.getEmail()
		);
	}
	
	public static Employee mapToEntity(EmployeeDto empDto) {
		return new Employee(
		     empDto.getId(),
		     empDto.getFirstName(),
		     empDto.getLastName(),
		     empDto.getEmail()		
	    );
	}
}
