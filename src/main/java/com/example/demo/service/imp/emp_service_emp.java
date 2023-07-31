package com.example.demo.service.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception_handling.ResourceNotFoundException;
import com.example.demo.model.employee;
import com.example.demo.payload.employee_payload;
import com.example.demo.repo.employeerepo;
import com.example.demo.service.employeeservice;

@Service
public class emp_service_emp implements employeeservice {
	@Autowired
	employeerepo repo;
	
	@Autowired
	ModelMapper modelmapper;

	@Override
	public employee_payload adduser(employee_payload emp) {
		employee e=this.dto_employee(emp);
		employee savesemployee=this.repo.save(e);
		return this.employee_dto(savesemployee);
	}

	@Override
	public employee_payload update(employee_payload emp, int id) {
		employee e=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("employee","id", id));
		e.setName(emp.getName());
		e.setEmail(emp.getEmail());
		e.setPassword(emp.getPassword());
		employee e1=this.repo.save(e);
		employee_payload ep=this.employee_dto(e1);
		return ep;
		
	}

	@Override
	public void deleteusers(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<employee_payload> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employee_payload getbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public employee dto_employee(employee_payload ep) {
		employee employee=this.modelmapper.map(ep,employee.class);
		return employee;
	}
	
	public employee_payload employee_dto(employee emp) {
		employee_payload employeedao=this.modelmapper.map(emp,employee_payload.class);
		return employeedao;
	}
	
	
	
	
//	public employee dto_employee(employee_payload e_p) {
//		employee e=this.modelmapper.map(e_p,employee.class);
//		return e;
//	}
//	
//	public employee_payload emp_dto(employee emp) {
//		employee_payload ep=this.modelmapper.map(emp,employee_payload.class);
//		return ep;
//	}

}
