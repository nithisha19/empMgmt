package com.dbs.empMgmt.service;

import com.dbs.empMgmt.model.Employee;
import java.util.List;

public interface EmployeeService {

   Employee saveEmployee(Employee employee);

   List<Employee> listAll();

   Employee findById(long empId);

   void deleteEmployee(long empId);
}