package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Salary;
import com.example.demo.repository.SalaryRepository;

@Service
public class SalaryServiceImpl implements SalaryService{
	
	@Autowired
	SalaryRepository salaryrepository;

	@Override
	public Salary saveSalary(Salary salary) {
		return salaryrepository.save(salary);
	}

	@Override
	public List<Salary> getAllsalary() {
		return salaryrepository.findAll();
	}

	@Override
	public Salary getSalaryById(int id) {
		return salaryrepository.findById(id).orElse(null);
	}

	@Override
	public Salary updateSalary(Salary salary, int id) {
	Salary Existingsalary =salaryrepository.findById(id).orElse(salary);
	Existingsalary.setAmount(salary.getAmount());
	salaryrepository.save(Existingsalary);
		return Existingsalary;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		salaryrepository.findById(id).orElse(null);
		salaryrepository.deleteById(id);
	}

}
