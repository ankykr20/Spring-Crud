package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> findAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee findEmployeeByNo(int no);
	public String modifyEmployeeDetailsByNo(Employee emp);
	public String removeEmployeeByNo(int no);
}
