package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empService;
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/emp_report")
	public String showEmployee(Map<String,Object> map) {
		//Use Service
		List<Employee> list = empService.findAllEmployees();
		//Add to the model Attribute..
		map.put("empsData", list);
		//return LVN
		return "show_report";
	}
	
	@GetMapping("/emp_add")
	public String showAddEmployeeFormPage(@ModelAttribute("emp") Employee emp){
		return "employee_register_form";
	}
	
	@PostMapping("/emp_add")
	public String processAddEmployeeFormPageSubmission(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		//Use Service
		String msg = empService.registerEmployee(emp);
		List<Employee> list = empService.findAllEmployees();
		//Keep the results in Model Attribute..
		map.put("resultMsg", msg);
		map.put("empsData", list);
		return "show_report";
	}
	
	@GetMapping("/emp_edit")
	public String showEditEmployeeForm(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		Employee emp1 = empService.findEmployeeByNo(no);
		BeanUtils.copyProperties(emp1, emp);  //given by spring api
		return "employee_edit_form";
	}
	
	@PostMapping("/emp_edit")
	public String processEditFormPageSubmission(@ModelAttribute("emp") Employee emp, Map<String, Object> map) {
		//Use Service..
		String msg = empService.modifyEmployeeDetailsByNo(emp);
		List<Employee> listEmps = empService.findAllEmployees();
		//Keep results in model attributes..
		map.put("resultMsg", msg);
		map.put("empsData", listEmps);
		return "show_report";
	}
	
	@GetMapping("/emp_delete")
	public String removeEmployee(@RequestParam("no") int no, Map<String, Object> map) {
		String msg = empService.removeEmployeeByNo(no);
		List<Employee> list = empService.findAllEmployees();
		map.put("resultMsg", msg);
		map.put("empsData", list);
		return "show_report";
	}
}
