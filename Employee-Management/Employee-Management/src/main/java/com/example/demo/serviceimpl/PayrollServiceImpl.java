package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payroll;
import com.example.demo.repository.PayrollRepository;

@Service
public class PayrollServiceImpl implements PayrollService{
	
	@Autowired
	PayrollRepository payrollrepository;


	@Override
	public Payroll savePayroll(Payroll payroll) {
		return payrollrepository.save(payroll);
	}

	@Override
	public List<Payroll> getAllpayroll() {
		return payrollrepository.findAll();
	}

	@Override
	public Payroll getPayrollById(int id) {
		return payrollrepository.findById(id).orElse(null);
	}

	@Override
	public Payroll updatePayroll(Payroll payroll, int id) {
	Payroll Existingpayroll =payrollrepository.findById(id).orElse(payroll);
	Existingpayroll.setDate(payroll.getDate());
	payrollrepository.save(Existingpayroll);
		return Existingpayroll;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		payrollrepository.findById(id).orElse(null);
		payrollrepository.deleteById(id);
	}

}
