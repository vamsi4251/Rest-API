package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.employee_payload;
import com.example.demo.service.employeeservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class employee_controler {
	@Autowired 
	employeeservice service;
	
	@PostMapping("/insert")
	public ResponseEntity<employee_payload>adduser(@Valid @RequestBody employee_payload emp){
		
		employee_payload employee=this.service.adduser(emp);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<employee_payload>updateusers(@Valid @PathVariable int id,@RequestBody employee_payload emp){
		employee_payload employee=this.service.update(emp, id);
		return ResponseEntity.ok(employee);
	}

}
