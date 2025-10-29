package com.nt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.EmployeeEntity;
import com.nt.repository.EmployeeRepository;
import com.nt.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public EmployeeEntity insertEmployeRecord(EmployeeEntity emp) {
		return empRepo.save(emp);
	}
	
	
	
	

}
