package com.codandospring.springboot.cruddemo.service;

import com.codandospring.springboot.cruddemo.dao.EmployeeDAO;
import com.codandospring.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
