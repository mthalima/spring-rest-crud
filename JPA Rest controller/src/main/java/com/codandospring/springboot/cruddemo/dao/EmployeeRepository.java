package com.codandospring.springboot.cruddemo.dao;

import com.codandospring.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

    //apenas isso, nao precisa de mais codigo

}
