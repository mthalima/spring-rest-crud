package com.codandospring.springboot.cruddemo.dao;


import com.codandospring.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {


    List<Employee> findAll();


}
