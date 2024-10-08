package com.codandospring.springboot.cruddemo.rest;

import com.codandospring.springboot.cruddemo.entity.Employee;
import com.codandospring.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    //add mapping para GET /employees/{employeeId} procura por dados cadastrados


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Não foi possível localizar o id: " + employeeId);
        }

        return theEmployee;
    }


    //add mapping para POST /employees = add novo funcionário
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }


    //add mapping para PUT /employees - update funcionário existente
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //mapping para DELETE /employees/{employeeId}
    @DeleteMapping("/employees/{employeeId}")
        public String deleteEmployee(@PathVariable int employeeId){

            Employee tempEmployee = employeeService.findById(employeeId);

            //checa se id existe, caso nao throw exception

            if(tempEmployee == null){
                throw new RuntimeException("Id " + employeeId + " não encontrado!");
            }

            employeeService.deleteById(employeeId);

            return "Cadastro de ID "+employeeId+" deletado com sucesso.";

        }

    }

