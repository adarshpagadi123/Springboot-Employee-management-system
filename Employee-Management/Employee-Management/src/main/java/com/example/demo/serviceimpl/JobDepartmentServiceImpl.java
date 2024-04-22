package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.JobDepartment;
import com.example.demo.repository.JobDepartmentRepository;

@Service
public class JobDepartmentServiceImpl implements JobDepartmentService{
	private JobDepartmentRepository jobDepartmentRepository;

    @Autowired
    public JobDepartmentServiceImpl(JobDepartmentRepository jobDepartmentRepository){
        this.jobDepartmentRepository=jobDepartmentRepository;
    }
    @Override
    public JobDepartment saveJobDepartment(JobDepartment jobDepartment) {
        return jobDepartmentRepository.save(jobDepartment);
    }
	@Override
	public List<JobDepartment> getAllJobDepartment() {
		return jobDepartmentRepository.findAll();
	}
	
	@Override
	public JobDepartment getJobDepartmentById(int id) {
		return jobDepartmentRepository.findById(id).orElse(null);
	}
	@Override
	public JobDepartment updateJobDepartment(JobDepartment jobDepartment, int id) {
		JobDepartment ExistingjobDepartment   =jobDepartmentRepository.findById(id).orElse(jobDepartment);
		ExistingjobDepartment.setJob_dept(jobDepartment.getJob_dept());
		jobDepartmentRepository.save(ExistingjobDepartment);
		return ExistingjobDepartment;
	}
	@Override
	public void deleteById(int id) {
		jobDepartmentRepository.findById(id).orElse(null);
		jobDepartmentRepository.deleteById(id);
		
	}

}
