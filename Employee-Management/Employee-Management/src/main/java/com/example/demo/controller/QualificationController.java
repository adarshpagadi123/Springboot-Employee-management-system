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

import com.example.demo.model.Qualification;
import com.example.demo.serviceimpl.QualificationService;

@RestController
public class QualificationController {
	
	@Autowired
	QualificationService qualificationservice;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value="/qualificationsave")
	public ResponseEntity<Qualification> saveQualification(@RequestBody Qualification qualification) {
		return new ResponseEntity<Qualification>(qualificationservice.saveQualification(qualification),HttpStatus.CREATED);
	}
	
	@PutMapping("/qualificationupdated/{id}")
    public ResponseEntity<Qualification> updateQualification(@RequestBody Qualification qualification,@PathVariable("id") int id){
		return new ResponseEntity<Qualification>(qualificationservice.updateQualification(qualification,id),HttpStatus.OK);
    }
	
	@GetMapping(value="/qualificationget")
	public List<Qualification> getAllQualification() {
		return qualificationservice.getAllQualification();
	}
	
	@GetMapping(value="/qualificationgetById/{id}")
	public ResponseEntity<Qualification> getQualificationById(@PathVariable("id")int id) {
		return new ResponseEntity<Qualification>(qualificationservice.getQualificationById(id),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/qualificationdeleteById/{id}")
	public ResponseEntity<String> deleteQualification(@PathVariable("id") int id) {
		qualificationservice.deleteById(id);
		return new ResponseEntity<String>("JobDepartment deleted",HttpStatus.OK);	
	}

}
