package com.example.demo.serviceimpl;

import java.util.List;

import com.example.demo.model.JobDepartment;

public interface JobDepartmentService {
	
	public JobDepartment saveJobDepartment(JobDepartment jobDepartment);

	List<JobDepartment> getAllJobDepartment();

	JobDepartment getJobDepartmentById(int id);

	JobDepartment updateJobDepartment(JobDepartment jobDepartment,int id);

	void deleteById(int id);
}
