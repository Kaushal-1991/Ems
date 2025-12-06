package com.ems.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.DepartmentDto;
import com.ems.entity.Department;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.DepartmentMapper;
import com.ems.repository.DepartmentRepository;
import com.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Department department = DepartmentMapper.mapToEntity(departmentDto);
		Department saveDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDto(saveDepartment);
	}

	@Override
	public DepartmentDto getDepartment(Long id) {
		Department deparment = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee id is not exists : " + id));
		return DepartmentMapper.mapToDto(deparment);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {
        List<Department> allDepartment = departmentRepository.findAll();      
		return allDepartment.stream().map((dept) -> DepartmentMapper.mapToDto(dept)).collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long departId, DepartmentDto departmentDto) {
		Department department = departmentRepository.findById(departId).orElseThrow(() -> new ResourceNotFoundException("Employee id is not exists : " + departId));
		department.setDepartmentName(departmentDto.getDepartmentName());
		department.setDepartmentDescription(departmentDto.getDepartmentDescription());
		departmentRepository.save(department);
		return DepartmentMapper.mapToDto(department);
	}

	@Override
	public void deleteDepartment(Long deptId) {
		Department department = departmentRepository.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Employee id is not exists : " + deptId));
		departmentRepository.delete(department);
	}

}
