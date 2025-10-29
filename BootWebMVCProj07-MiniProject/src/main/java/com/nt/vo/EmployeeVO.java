package com.nt.vo;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {

	private Long empno;
	
	@Column(length=30)
	private String empName;
	
	@Column(length=30)
	private String addrs;
	
	@Column(length=30)
	private String desg;
	
	@Column(length=30)
	private Double salary;
}
