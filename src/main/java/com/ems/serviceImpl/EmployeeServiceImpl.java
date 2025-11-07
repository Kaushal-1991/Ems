package com.ems.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.EmployeeMapper;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto dto) {
		Employee emp = EmployeeMapper.mapToEntity(dto);	
		Employee empSaved = employeeRepository.save(emp);
		return EmployeeMapper.mapToDto(empSaved);
	}

	@Override
	public EmployeeDto getEmployee(Long employeeId) {
		Employee emp = employeeRepository.findById(employeeId)
				                         .orElseThrow(() -> new ResourceNotFoundException("Employee id is not exists : " + employeeId));
		return EmployeeMapper.mapToDto(emp);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> emp= employeeRepository.findAll();
		return emp.stream().map((employee) -> EmployeeMapper.mapToDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto dto) {
		Employee emp = employeeRepository.findById(employeeId)
				                         .orElseThrow(() -> new ResourceNotFoundException("Employee id is not exists : " + employeeId));
		
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		employeeRepository.save(emp);
   		
		return EmployeeMapper.mapToDto(emp);
	}

	@Override
	public void deleteEmployee(Long empId) {
		Employee emp = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee id is not exists : " + empId));
		
		employeeRepository.delete(emp);
	}
}
