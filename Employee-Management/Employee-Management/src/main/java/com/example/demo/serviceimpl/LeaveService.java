package com.example.demo.serviceimpl;

import java.util.List;

import com.example.demo.model.Leave;

public interface LeaveService {
	
	Leave saveLeave(Leave leave);
	
	List<Leave> getAllleave();
	
	Leave getLeaveById(int id);
	
	Leave updateLeave(Leave leave,int id);
	
	void deleteById(int id);
	
}
