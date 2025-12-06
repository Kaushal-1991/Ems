package com.ems.mapper;

import com.ems.dto.DepartmentDto;
import com.ems.entity.Department;

public class DepartmentMapper {
   
	// Convert department to department dto
	
	public static DepartmentDto mapToDto(Department department) {
		return new DepartmentDto(
			department.getId(),
		    department.getDepartmentName(),
		    department.getDepartmentDescription()
		);
	}
	
	//Convert departmentDto to department
	
	public static Department mapToEntity(DepartmentDto departmentDto) {
		return new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription()
	    );
	}
}
