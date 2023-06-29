package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jt;
	private static final String GET_EMPS_QUERY = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP";
	private static final String INSERT_EMPS_QUERY = "INSERT INTO EMP(EMPNO, ENAME, JOB, SAL, DEPTNO) VALUES (EMP_NO_SEQ.NEXTVAL,?,?,?,?)";
	private static final String GET_EMP_BY_NO = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE EMPNO = ?";
	private static final String UPDATE_EMP_BY_NO = "UPDATE EMP SET ENAME=?, JOB=?, SAL=?, DEPTNO=? WHERE EMPNO=?";
	private static final String DELETE_EMP_BY_NO = "DELETE FROM EMP WHERE EMPNO=?";
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> listEmps = jt.query(GET_EMPS_QUERY,
											rs->{
												List<Employee> list = new ArrayList();
												while(rs.next()) {
													Employee emp = new Employee();
													emp.setEmpno(rs.getInt(1));
													emp.setEname(rs.getString(2));
													emp.setJob(rs.getString(3));
													emp.setSal(rs.getFloat(4));
													emp.setDeptno(rs.getInt(5));
													list.add(emp);
												}//While end
												return list;
											});
		return listEmps;
	}

	@Override
	public int insertEmployee(Employee emp) {
		int count = jt.update(INSERT_EMPS_QUERY, emp.getEname(),
												emp.getJob(),
												emp.getSal(),
												emp.getDeptno());
		return count;
	}
	
	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO,(rs, rowwnum)->{
												//Copy ResultSet Object Single Record to Employee class obj..
												Employee e = new Employee();
												e.setEmpno(rs.getInt(1));
												e.setEname(rs.getString(2));
												e.setJob(rs.getString(3));
												e.setSal(rs.getFloat(4));
												e.setDeptno(rs.getInt(5));
											return e;
		}, no);
	return emp;
	}
	
	@Override 
	public int updateEmployeeByNo(Employee emp) {
		int count = jt.update(UPDATE_EMP_BY_NO,
								emp.getEname(),
								emp.getJob(),
								emp.getSal(),
								emp.getDeptno(),
								emp.getEmpno());
		return count;
	}
	
	@Override
	public int deleteEmployeeByNo(int no) {
		int count = jt.update(DELETE_EMP_BY_NO, no);
		return count;
	}
}
