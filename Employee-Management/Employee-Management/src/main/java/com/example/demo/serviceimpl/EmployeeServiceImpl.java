package com.example.demo.serviceimpl;

//import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository){
		this.employeeRepository=employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Employee existingEmployee = employeeRepository.findById(id).orElse(employee);
		existingEmployee.setFname(employee.getFname());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.findById(id).orElse(null);
		employeeRepository.deleteById(id);	
	}

	/*@Override
	public void saveTimeIn(Employee employee) {
		employee.setTimeIn(LocalDateTime.now());
		employeeRepository.save(employee);
	}
	@Override
	public void saveTimeOut(Employee employee) {
		employee.setTimeOut(LocalDateTime.now());
		employeeRepository.save(employee);
	}
	
	 public EmployeeTimeTracking getTimeTracking(String employeeId) {
	        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
	        if (employeeOptional.isPresent()) {
	            Employee employee = employeeOptional.get();
	            EmployeeTimeTracking timeTracking = new EmployeeTimeTracking();
	            timeTracking.setEmployeeId(employeeId);
	            timeTracking.setTimeIn(employee.getTimeIn());
	            timeTracking.setTimeOut(employee.getTimeOut());
	            return timeTracking;
	        } else {
	            return null;
	        }
	    }
*/

}
