package com.nt.service;

import java.util.List;

import com.nt.model.EmployeeEntity;
import com.nt.vo.EmployeeVO;

public interface IEmployeeService {

	
	public List<EmployeeEntity> getAllEmployee();

	public  String insertEmployeRecord(EmployeeVO empVo);

	public String updateEmployee(EmployeeVO empVo);

	public EmployeeEntity getEmployee(Long empno);

	public String deleteEmployeeById(Long empno);
}
