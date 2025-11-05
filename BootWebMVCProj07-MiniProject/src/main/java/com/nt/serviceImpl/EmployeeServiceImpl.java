package com.nt.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.EmployeeEntity;
import com.nt.repository.EmployeeRepository;
import com.nt.service.IEmployeeService;
import com.nt.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	
	@Autowired
	private EmployeeRepository empRepo;
	@Value("${username}")
	private String name;
	
	@Override
	public List<EmployeeEntity> getAllEmployee() {
		
		return empRepo.findAll();
	}


	@Override
	public String insertEmployeRecord(EmployeeVO empVo) {
		EmployeeEntity emp = new EmployeeEntity();
		BeanUtils.copyProperties(empVo, emp);
		
		emp.setCreatedBy( name);
		
		empRepo.save(emp);
		return  emp.getEmpno()+" Employee is registered successfully...!";
	}


	@Override
	public String updateEmployee(EmployeeVO empVo) {
		 EmployeeEntity emp = empRepo.findById(empVo.getEmpno()).orElseThrow(()-> new EmployeeIdNotFoundException("Invalid EmpNo"));
		// EmployeeEntity emp = new EmployeeEntity();
			BeanUtils.copyProperties(empVo, emp);
			
			emp.setCreatedBy( name);
			emp.setUpdatedBy(name);
			empRepo.save(emp);
		return empVo.getEmpno()+" Employee updated successfully...!";
	}


	@Override
	public String deleteEmployeeById(Long empno) {
		//use Repo
		empRepo.deleteById(empno);
		return empno +" Employee is deleted successfully....!";
	}
	
	
	
	@Override
	public EmployeeEntity getEmployee(Long empno) {
		 EmployeeEntity entity = empRepo.findById(empno).orElseThrow(()-> new EmployeeIdNotFoundException("Invalid EmpNo"));
		return entity;
	}


	@Override
	public Page<EmployeeVO> getEmpByPage(Pageable pageable) {
		
		Page<EmployeeEntity> page = empRepo.findAll(pageable);
		// copy all the page<EmployeeEntity> into list
		List<EmployeeEntity> list = page.getContent();
		
		
		List<EmployeeVO> empvolist = new ArrayList<EmployeeVO>();
		list.forEach( entity ->{
			
			// create employeevo object
			EmployeeVO empvo = new EmployeeVO();
			BeanUtils.copyProperties(entity, empvo);
			// we can calculate gross salary and net salary here
			empvolist.add(empvo);
		});
		Page<EmployeeVO> volist= new PageImpl<EmployeeVO>(empvolist, pageable,page.getTotalElements());
		return volist;
	}



}
