package com.nt.serviceImpl;

public class EmployeeIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeIdNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeIdNotFoundException(String msg) {
		super(msg);
	}
}
