package com.api.service;

import com.api.entity.Employee;
import com.api.payload.EmployeeDto;
import com.api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> dtos = employees.stream().map(a->mapToDto(a)).collect(Collectors.toList());
        return dtos;
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = mapToEntity(employeeDto);

        Employee saveEmp = employeeRepository.save(employee);

        EmployeeDto dto =mapToDto(employee);
        return dto;
    }


    public void deleteEmployee(long id) {

        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(long id, Employee employee) {
        Employee emp = employeeRepository.findById(id).get();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setMobile(employee.getMobile());
        Employee updateEmp = employeeRepository.save(emp);
        return updateEmp;
    }


    Employee mapToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobile(employeeDto.getMobile());
        return employee;
    }

    EmployeeDto mapToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setMobile(employee.getMobile());
        return dto;
    }
}
