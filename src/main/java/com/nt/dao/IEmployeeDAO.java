package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> getAllEmployees();

	//Insert Operation..
	public int insertEmployee(Employee emp);
	
	//Select Operation..
	public Employee getEmployeeByNo(int no);
	
	//Update Operation
	public int updateEmployeeByNo(Employee emp);
	
	public int deleteEmployeeByNo(int no);
}

