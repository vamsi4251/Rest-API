package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception_handling.ApiResponse;
import com.example.demo.model.employee;
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
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse>delete(@Valid @PathVariable int id){
		
		this.service.deleteusers(id);
		return new ResponseEntity<ApiResponse> (new ApiResponse("id deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<employee_payload>> getall(){
		return ResponseEntity.ok(this.service.getall());
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<employee_payload>getbyid(@Valid @PathVariable int id){
		
		return ResponseEntity.ok(this.service.getbyid(id));
	}

}
