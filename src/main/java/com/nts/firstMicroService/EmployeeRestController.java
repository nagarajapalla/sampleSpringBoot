package com.nts.firstMicroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.firstMicroService.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
 
    @Autowired
    private EmpService employeeService;
 
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
