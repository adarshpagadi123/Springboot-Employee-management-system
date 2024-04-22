package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Leave;
import com.example.demo.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	LeaveRepository leaverepository;

	@Override
	public Leave saveLeave(Leave leave) {
		return leaverepository.save(leave);
	}

	@Override
	public List<Leave> getAllleave() {
		return leaverepository.findAll();
	}

	@Override
	public Leave getLeaveById(int id) {
		return leaverepository.findById(id).orElse(null);
	}

	@Override
	public Leave updateLeave(Leave leave, int id) {
	Leave Existingleave =leaverepository.findById(id).orElse(leave);
	Existingleave.setDate(leave.getDate());
	leaverepository.save(Existingleave);
		return Existingleave;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		leaverepository.findById(id).orElse(null);
		leaverepository.deleteById(id);
	}

}
