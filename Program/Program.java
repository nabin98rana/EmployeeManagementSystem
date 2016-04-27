/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncit.ems.Program;

import com.ems.util.Input;
import com.ems.util.TextFileHandler;
import com.ncit.ems.dao.EmployeeDAO;
import com.ncit.ems.daoimpl.EmployeeDAOImpl;
import com.ncit.ems.daoimpl.EmployeeDBImpl;
import com.ncit.entity.Employee;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Navin
 */
public class Program {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        int choice = 0;

        //EmployeeDAO dao = new EmployeeDAOImpl(new ArrayList<Employee>());
        EmployeeDAO dao = new EmployeeDBImpl();
        while (choice <= 8) {
            System.out.println("*************************************");
            System.out.println("|Welcome to Employee Mangement System|");
            System.out.println("*************************************");
            System.out.println("1.Add Employee");
            System.out.println("2.Edit Employee");
            System.out.println("3.Delete Employee");
            System.out.println("4.Search by Employee id");
            System.out.println("5.Show all Employees");
            System.out.println("6.Save to File");
            System.out.println("7.Load from  File");
            System.out.println("8.Exit");
            System.out.println("Enter your Choice[1-8]");

            try {

                choice = Input.getInt();

                switch (choice) {

                    case 1:
                        addEmployee(dao);
                        break;
                    case 2:
                        updateEmployee(dao);
                        break;
                    case 3:
                        deleteEmployee(dao);
                        break;
                    case 4:
                        searchById();
                        break;
                    case 5:
                        showAll(dao);
                        break;
                    case 6:
                        storeIntoFile(dao);
                        break;

                    case 7:
                        loadFromFile(dao);
                        break;

                    case 8:
                        System.exit(0);
                        break;
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }

        }

    }

    public static void addEmployee(EmployeeDAO dao) throws IOException, SQLException, ClassNotFoundException {

        String choice = "Y";
        while (choice.equalsIgnoreCase("Y")) {
            Employee emp = new Employee();
            System.out.print("Eneter Employee id:");
            emp.setId(Input.getInt());
            System.out.print("Eneter First Name:");
            emp.setFirstName(Input.getString());
            System.out.print("Eneter Last Name:");
            emp.setLastName(Input.getString());
            System.out.print("Eneter Email:");
            emp.setEmail(Input.getString());
            System.out.print("Eneter Contact Number:");
            emp.setContactNo(Input.getString());
            System.out.print("Eneter Salary:");
            emp.setSalary(Input.getDouble());

            dao.insert(emp);

            System.out.print("\r\n\r\n Do you want to continue??");
        }
    }

    public static void showAll(EmployeeDAO dao) throws SQLException, ClassNotFoundException {
        for (Employee e : dao.getAll()) {
            System.out.println(e.toString());
        }
    }

    public static void loadFromFile(EmployeeDAO dao) throws IOException {
        String path = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter file path to import Employee");
            path = Input.getString();
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("Invalid File path entry please try again");

            } else {
                valid = true;
                break;

            }
        }
        TextFileHandler fileHandler = new TextFileHandler(path);
        dao.loadFromFile(fileHandler);

    }

    public static void storeIntoFile(EmployeeDAO dao) throws IOException {
        String path = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter file path to import Employee");
            path = Input.getString();
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("Invalid File path entry please try again");

            } else {
                valid = true;
                break;

            }
        }
        TextFileHandler fileHandler = new TextFileHandler(path);
        dao.storeIntoFile(fileHandler);

    }

    public static void deleteEmployee(EmployeeDAO dao) throws IOException {
        Employee emp = new Employee();
        List<Employee> employeeList = new ArrayList<>();
        int id;
        id = Input.getInt();
        if (emp.getId() == id) {
            employeeList.remove(emp);

        }
    }

    public static void searchById() throws IOException {
        Employee e = new Employee();
        e.setId(Input.getInt());
    }

    public static void updateEmployee(EmployeeDAO dao) throws IOException, SQLException, ClassNotFoundException {

        Employee e = dao.getAll().get(0);
        System.out.println("Employee id" + e.getId() + "Employee name" + e.getFirstName() + "");

    }

}
