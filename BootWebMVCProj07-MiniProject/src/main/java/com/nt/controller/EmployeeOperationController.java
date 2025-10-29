package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.EmployeeEntity;
import com.nt.service.IEmployeeService;

@Controller
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeService empService;
	
	@GetMapping("/")
	public String getWelcomePage() {
		return "welcome";
	}
	
	@GetMapping("/report")
	public String showRepost(Map<String, Object> map) {
		
		List<EmployeeEntity> allEmployee = empService.getAllEmployee();
		
		// add to model attributes
		
		map.put("empList", allEmployee);
		// return LVN
		return "show_report";
	}
	
	
	@GetMapping("/add")
	public String addEmployee(Map<String, Object> map) {
		map.put("emp", new EmployeeEntity());
		// return LVN
		return "register_employee";
	}
	
	@PostMapping("/add")
	public String registerEmployee(@ModelAttribute("emp") EmployeeEntity emp, Map<String , Object> map) {
		
		// user service
		EmployeeEntity insertEmployeRecord = empService.insertEmployeRecord(emp);
		//map.put("empList", insertEmployeRecord);
		return "redirect:report";
	}
	
	
	

}
