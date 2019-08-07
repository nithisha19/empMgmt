package com.dbs.empMgmt.client;

import com.dbs.empMgmt.controller.EmployeeController;
import com.dbs.empMgmt.model.Address;
import com.dbs.empMgmt.model.BankAccount;
import com.dbs.empMgmt.model.Dependency;
import com.dbs.empMgmt.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.time.LocalDate;

public class EmpManagementClient {

    private static  EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        employeeController = applicationContext.getBean(EmployeeController.class);
        saveEmployees();
        //listAllEmployees();
       // fetchEmployeeDetailsById(12);
    }

    private static void fetchEmployeeDetailsById(int i) {
        System.out.println("Employee with id "+i +" is " +employeeController.findById(i));
    }

    private static void listAllEmployees() {
        employeeController.listAll().forEach(System.out::println);
    }



    private static void saveEmployees(){
        Employee employee = new Employee("Harish", LocalDate.of(1985,5, 25), "HR");

        Address address = new Address();
        address.setStreet("18th Main");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setZip("577142");

        BankAccount account1 = new BankAccount();
        account1.setPan("AOY45G88M");
        account1.setAccountBalance(5_000);
        BankAccount account2 = new BankAccount();
        account2.setPan("AOY45GG88M");
        account2.setAccountBalance(15_000);
        Dependency dependency1=new Dependency();
        dependency1.setName("Nithisha");
        dependency1.setAge(21);
        Dependency dependency2=new Dependency();
        dependency2.setName("Hamsini");
        dependency2.setAge(22);

        employee.addBankAccount(account1);
        employee.addBankAccount(account2);

        employee.setAddress(address);
        address.setEmployee(employee);
        
        employee.addDependency(dependency1);
        employee.addDependency(dependency2);
        dependency1.setEmployee(employee);
        dependency2.setEmployee(employee);
        
        employeeController.saveEmployee(employee);
       // employee = new Employee("VInayak", LocalDate.of(1985,6, 18), "Payroll");
        //employeeController.saveEmployee(employee);
       // employee = new Employee("Harish", LocalDate.of(1981,3, 25), "HR");
        //employeeController.saveEmployee(employee);
        
    }
}