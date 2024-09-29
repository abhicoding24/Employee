package com.api.controller;

import com.api.entity.Employee;
import com.api.payload.EmployeeDto;
import com.api.repository.EmployeeRepository;
import com.api.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService,
                              EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){

           List<EmployeeDto> employees = employeeService.getEmployees();
           return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmp(@RequestBody EmployeeDto employeeDto){
       EmployeeDto saveEmpDto = employeeService.saveEmployee(employeeDto);
       return new ResponseEntity<>(saveEmpDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmp(@RequestParam long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Record Deleted..", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable long id,@RequestBody Employee employee){

        Employee updatedEmp = employeeService.updateEmployee(id,employee);
        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
    }
}

