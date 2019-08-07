/*Add below in application-context.xml
 *  	1.add the dependencies
 * 		Add spring-orm
 * 		Add hibernate
 * 		mysql
 *		 2. sessionFactory
 * 		datasource
 * 		hibernateProperties
 * 		3. transaction manager
 * In DAOImpl
 * HibernateDAOImpl
 * 		Autowire with sessionFactory
 * In Employee.java we need to write the following
 * 		@Entity
 * 		@Table
 * 		@Column
 * 		@Id
 * 		@GenerateValue*/

package com.dbs.empMgmt.dao;
import com.dbs.empMgmt.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateDAO")
public class HibernateDAOImpl implements EmployeeDAO {

    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @Override
    public Employee save(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public Employee update(long id, Employee employee) {
        Session currentSession=sessionFactory.getCurrentSession();
        Employee returnedEmployee=currentSession.byId(Employee.class).load(id);
        if(returnedEmployee != null){
            returnedEmployee.setName(employee.getName());
            returnedEmployee.setDateOfBirth(employee.getDateOfBirth());
            returnedEmployee.setDepartmentName(employee.getDepartmentName());
            currentSession.saveOrUpdate(returnedEmployee);
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Employee").list();
    }

    @Override
    public Employee findById(long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.byId(Employee.class).load(id);
        session.delete(employee);
    }
}