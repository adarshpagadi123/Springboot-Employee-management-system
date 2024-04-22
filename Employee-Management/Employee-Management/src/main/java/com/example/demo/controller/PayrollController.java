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

import com.example.demo.model.Payroll;
import com.example.demo.serviceimpl.PayrollService;

public class PayrollController {
	
	@Autowired
	PayrollService payrollservice;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value="/payrollsave")
	public ResponseEntity<Payroll> savePayroll(@RequestBody Payroll payroll) {
		return new ResponseEntity<Payroll>(payrollservice.savePayroll(payroll),HttpStatus.CREATED);
	}
	
	@PutMapping("/payrollupdated/{id}")
    public ResponseEntity<Payroll> updatePayroll(@RequestBody Payroll payroll,@PathVariable("id") int id){
		return new ResponseEntity<Payroll>(payrollservice.updatePayroll(payroll,id),HttpStatus.OK);
    }
	
	@GetMapping(value="/payrollget")
	public List<Payroll> getAllPayroll() {
		return payrollservice.getAllpayroll();
	}
	
	@GetMapping(value="/payrollgetById/{id}")
	public ResponseEntity<Payroll> getPayrollById(@PathVariable("id")int id) {
		return new ResponseEntity<Payroll>(payrollservice.getPayrollById(id),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/payrolldeleteById/{id}")
	public ResponseEntity<String> deletePayroll(@PathVariable("id") int id) {
		payrollservice.deleteById(id);
		return new ResponseEntity<String>("payroll deleted",HttpStatus.OK);	
	}

}
