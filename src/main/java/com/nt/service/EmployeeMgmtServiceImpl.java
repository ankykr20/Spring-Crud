package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO empDAO;
	
	@Override
	public List<Employee> findAllEmployees() {
		//Use DAO
		List<Employee> list = empDAO.getAllEmployees();
		
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) {
		//Use DAO..
		int count = empDAO.insertEmployee(emp);
		return count==0?"Employee Not Registered":"Employee is Registered.!";
	}
	
	@Override
	public Employee findEmployeeByNo(int no) {
		//Use DAO..
		Employee emp = empDAO.getEmployeeByNo(no);
		return emp;
	}
	
	@Override
	public String modifyEmployeeDetailsByNo(Employee emp) {
		//USe DAO...
		int count = empDAO.updateEmployeeByNo(emp);
		return count==0?"Employee not found for updation":"Employee found and updation";
	}
	
	@Override
	public String removeEmployeeByNo(int no) {
		int count = empDAO.deleteEmployeeByNo(no);
		
		return count==0?"Employee not found for deletion" :"Employee found and Deleted";
	}
}
