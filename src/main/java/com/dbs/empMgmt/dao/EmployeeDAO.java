package com.dbs.empMgmt.dao;

import com.dbs.empMgmt.model.Employee;
import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee update(long empId, Employee employee);

    List<Employee> findAll();

    Employee findById(long id);

    void deleteEmployee(long id);
}