package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
		return "show_report";
	}
	
	
	
	

}
