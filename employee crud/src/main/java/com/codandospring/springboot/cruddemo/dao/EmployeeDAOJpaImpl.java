package com.codandospring.springboot.cruddemo.dao;

import com.codandospring.springboot.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //define um campo para gerenciar entidades
    private EntityManager entityManager;

    //constructor injection
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //cria a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //executa a query e pega o resultado
        List<Employee> employees = theQuery.getResultList();

        //retorna o resultado
        return employees;
    }

    @Override
    public Employee findById(int theId) {
       //get employee
       Employee theEmployee = entityManager.find(Employee.class, theId);

       //retorna o employee
       return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

       //salva o employee
        Employee dbEmployee = entityManager.merge(theEmployee);

       //retorna o dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //encontra o employee pelo id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //deleta o employee
        entityManager.remove(theEmployee);

    }
}
