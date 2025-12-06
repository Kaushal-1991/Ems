package com.ems.service;

import java.util.List;

import com.ems.dto.DepartmentDto;

public interface DepartmentService {
	
  DepartmentDto createDepartment(DepartmentDto departmentDto);
  
  DepartmentDto getDepartment(Long id);
  
  List<DepartmentDto> getAllDepartment();
  
  DepartmentDto updateDepartment(Long departId,DepartmentDto departmentDto);
  
  void deleteDepartment(Long deptId);
}
