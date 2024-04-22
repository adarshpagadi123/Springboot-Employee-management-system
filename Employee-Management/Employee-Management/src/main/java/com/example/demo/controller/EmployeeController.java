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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.serviceimpl.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value="/empsave")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/empupdated/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id){
		return new ResponseEntity<Employee>(employeeservice.updateEmployee(employee,id),HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value="/empget")
	public List<Employee> getAllEmployee() {
		return employeeservice.getAllEmployee();
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value="/empgetById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")int id) {
		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(id),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping(value="/empdeleteById/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		employeeservice.deleteEmployee(id);
		return new ResponseEntity<String>("employee deleted",HttpStatus.OK);	
	}
	
	/*@PostMapping("/time-in")
    public void timeIn(@RequestBody Employee employee) {
        employeeservice.saveTimeIn(employee);
    }

    @PostMapping("/time-out")
    public void timeOut(@RequestBody Employee employee) {
        employeeservice.saveTimeOut(employee);
    }
    @GetMapping("/time-tracking/{employeeId}")
    public ResponseEntity<EmployeeTimeTracking> getTimeTracking(@PathVariable String employeeId) {
        EmployeeTimeTracking timeTracking = employeeservice.getTimeTracking(employeeId);
        if (timeTracking != null) {
            return ResponseEntity.ok(timeTracking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

}
