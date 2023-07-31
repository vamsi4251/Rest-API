package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.employee_payload;


public interface employeeservice {
	employee_payload adduser(employee_payload emp);
	employee_payload update(employee_payload emp,int id);
	void deleteusers(int id);
	List<employee_payload>getall();
	employee_payload getbyid(int id);
	
	
	
}
