package com.example.demo.serviceimpl;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	
    public List<Employee> getAllEmployee();
    
    Employee getEmployeeById(int id);
    
    Employee updateEmployee(Employee employee,int id);
    
    void deleteEmployee(int id);
    
   // void saveTimeIn(Employee employee);
    
   // void saveTimeOut(Employee employee);

}
