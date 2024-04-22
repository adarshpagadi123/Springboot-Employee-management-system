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

import com.example.demo.model.JobDepartment;
import com.example.demo.serviceimpl.JobDepartmentService;

@RestController
public class JobDepartmentController {
	
	@Autowired
	JobDepartmentService jobdepartmentservice;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value="/jobdepartmentsave")
	public ResponseEntity<JobDepartment> saveJobDepartment(@RequestBody JobDepartment jobdepartment) {
		return new ResponseEntity<JobDepartment>(jobdepartmentservice.saveJobDepartment(jobdepartment),HttpStatus.CREATED);
	}
	
	@PutMapping("/jobdeptupdated/{id}")
    public ResponseEntity<JobDepartment> updateJobDepartment(@RequestBody JobDepartment employee,@PathVariable("id") int id){
		return new ResponseEntity<JobDepartment>(jobdepartmentservice.updateJobDepartment(employee,id),HttpStatus.OK);
    }
	
	@GetMapping(value="/jobdeptget")
	public List<JobDepartment> getAllJobDepartment() {
		return jobdepartmentservice.getAllJobDepartment();
	}
	
	@GetMapping(value="/jobdeptgetById/{id}")
	public ResponseEntity<JobDepartment> getJobDepartmentById(@PathVariable("id")int id) {
		return new ResponseEntity<JobDepartment>(jobdepartmentservice.getJobDepartmentById(id),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/jobdeptdeleteById/{id}")
	public ResponseEntity<String> deleteJobDepartment(@PathVariable("id") int id) {
		jobdepartmentservice.deleteById(id);
		return new ResponseEntity<String>("JobDepartment deleted",HttpStatus.OK);	
	}

}
