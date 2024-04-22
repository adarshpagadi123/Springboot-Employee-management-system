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

import com.example.demo.model.Leave;
import com.example.demo.serviceimpl.LeaveService;

@RestController
public class LeaveController {
	
	@Autowired
	LeaveService leaveservice;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value="/leavesave")
	public ResponseEntity<Leave> saveLeave(@RequestBody Leave leave) {
		return new ResponseEntity<Leave>(leaveservice.saveLeave(leave),HttpStatus.CREATED);
	}
	
	@PutMapping("/leaveupdated/{id}")
    public ResponseEntity<Leave> updateLeave(@RequestBody Leave leave,@PathVariable("id") int id){
		return new ResponseEntity<Leave>(leaveservice.updateLeave(leave,id),HttpStatus.OK);
    }
	
	@GetMapping(value="/leaveget")
	public List<Leave> getAllLeave() {
		return leaveservice.getAllleave();
	}
	
	@GetMapping(value="/leavegetById/{id}")
	public ResponseEntity<Leave> getLeaveById(@PathVariable("id")int id) {
		return new ResponseEntity<Leave>(leaveservice.getLeaveById(id),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/leavedeleteById/{id}")
	public ResponseEntity<String> deleteLeave(@PathVariable("id") int id) {
		leaveservice.deleteById(id);
		return new ResponseEntity<String>("leave deleted",HttpStatus.OK);	
	}

}
