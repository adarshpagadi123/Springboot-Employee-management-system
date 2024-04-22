package com.example.demo.serviceimpl;

import java.util.List;

import com.example.demo.model.Payroll;

public interface PayrollService {
	Payroll savePayroll(Payroll payroll);
	
	List<Payroll> getAllpayroll();
	
	Payroll getPayrollById(int id);
	
	Payroll updatePayroll(Payroll payroll,int id);
	
	void deleteById(int id);

}
