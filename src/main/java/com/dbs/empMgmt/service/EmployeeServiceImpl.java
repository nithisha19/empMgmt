package com.dbs.empMgmt.service;

import com.dbs.empMgmt.dao.EmployeeDAO;
import com.dbs.empMgmt.model.Employee;
import com.dbs.empMgmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("hibernateDAO") EmployeeDAO employeeDAO, EmployeeRepository employeeRepository){
        this.employeeDAO = employeeDAO;
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
        //return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public List<Employee> listAll() {
        //return this.employeeDAO.findAll();
    	return null;
    }

    @Override
    @Transactional
    public Employee findById(long empId)  {
        //return this.employeeDAO.findById(empId);
    	return null;
    }

    @Override
    @Transactional
    public void deleteEmployee(long empId) {
        //this.employeeDAO.deleteEmployee(empId);
    }
}