package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.EmployeeEntity;
import com.nt.service.IEmployeeService;
import com.nt.vo.EmployeeVO;

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
	public String showRegisterEmployeePage(Map<String, Object> map) {
		map.put("emp", new EmployeeEntity());
		// return LVN
		return "register_employee";
	}
	
	@PostMapping("/add")
	public String registerEmployee(@ModelAttribute("emp") EmployeeVO emp, RedirectAttributes attrs) {
		
		// user service
		String msg = empService.insertEmployeRecord(emp);

		attrs.addFlashAttribute("resultMsg",msg);
		
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String showEditPage(@ModelAttribute("emp") EmployeeVO empvo, @RequestParam("empno") Long empno) {
		
		// use Service
		EmployeeEntity employee = empService.getEmployee(empno);
		
		BeanUtils.copyProperties(employee, empvo);
	
		return "edit_employee";
	}
	
	@PostMapping("/edit")
	public String EditEmployee(RedirectAttributes attrs, @ModelAttribute("emp") EmployeeVO empVo) {
		
		// use Service
		String msg = empService.updateEmployee(empVo);
		
		// add object to rediect attributes
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String getMethodName(@RequestParam("empno") Long empno, RedirectAttributes attrs) {
		String msg = empService.deleteEmployeeById(empno);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/pagereport")
	public String showDataByPagination(@PageableDefault(page=0,size=3,sort="empno",direction=Sort.Direction.ASC) Pageable pageable , Map<String, Object> map ) {
		// call service
		Page<EmployeeVO> empByPage = empService.getEmpByPage(pageable);
		map.put("empList", empByPage);
		return "show_page_report";
	}
	
	

}
