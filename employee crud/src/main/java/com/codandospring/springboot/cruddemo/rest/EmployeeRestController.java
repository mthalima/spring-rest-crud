package com.codandospring.springboot.cruddemo.rest;

import com.codandospring.springboot.cruddemo.entity.Employee;
import com.codandospring.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //inject employee DAO
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }


    //expõe "/employee" e retorna uma lista de employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


}
