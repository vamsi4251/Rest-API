package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.employee;

public interface employeerepo extends CrudRepository<employee, Integer> {

}
