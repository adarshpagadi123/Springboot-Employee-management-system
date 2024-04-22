package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Salary;
import com.example.demo.serviceimpl.SalaryService;

public class SalaryController {
	
	@Autowired
	SalaryService salaryservice;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value="/salarysave")
	public ResponseEntity<Salary> saveSalary(@RequestBody Salary salary) {
		return new ResponseEntity<Salary>(salaryservice.saveSalary(salary),HttpStatus.CREATED);
	}
	
	@PutMapping("/salaryupdated/{id}")
    public ResponseEntity<Salary> updateSalary(@RequestBody Salary salary,@PathVariable("id") int id){
		return new ResponseEntity<Salary>(salaryservice.updateSalary(salary,id),HttpStatus.OK);
    }
	
	@GetMapping(value="/salaryget")
	public List<Salary> getAllSalary() {
		return salaryservice.getAllsalary();
	}
	
	@GetMapping(value="/salarygetById/{id}")
	public ResponseEntity<Salary> getSalaryById(@PathVariable("id")int id) {
		return new ResponseEntity<Salary>(salaryservice.getSalaryById(id),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/salarydeleteById/{id}")
	public ResponseEntity<String> deleteSalary(@PathVariable("id") int id) {
		salaryservice.deleteById(id);
		return new ResponseEntity<String>("salary deleted",HttpStatus.OK);	
	}

}
