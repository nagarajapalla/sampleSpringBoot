package com.nts.firstMicroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.firstMicroService.entity.Employee;
import com.nts.firstMicroService.entity.EmployeeRepository;

@Service
public class EmpService {
	
	public int saveEmp(List<Emp> empList){
		return 1;
	}
	
	public Emp getEmp(Integer empId){
		Emp emp = new Emp();emp.setName("Raj");
		emp.setAge(23);
		return   emp;
	}
	
	   @Autowired
	    private EmployeeRepository employeeRepository1;
	 
	    public Employee getEmployeeByName(String name) {
	        return employeeRepository1.findByName(name);
	    }

		public List<Employee> getAllEmployees() {
			// TODO Auto-generated method stub
			return employeeRepository1.findAll();
		}

}
