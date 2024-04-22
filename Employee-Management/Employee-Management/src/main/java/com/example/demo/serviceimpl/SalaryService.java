package com.example.demo.serviceimpl;

import java.util.List;

import com.example.demo.model.Salary;

public interface SalaryService {
	Salary saveSalary(Salary salary);
	
	List<Salary> getAllsalary();
	
	Salary getSalaryById(int id);
	
	Salary updateSalary(Salary salary,int id);
	
	void deleteById(int id);

}
