/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncit.ems.daoimpl;

import com.ems.util.DBConnection;
import com.ems.util.TextFileHandler;
import com.ncit.ems.dao.EmployeeDAO;
import com.ncit.entity.Employee;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Navin
 */
public class EmployeeDBImpl implements EmployeeDAO{

    
   
    @Override
    public int insert(Employee e)throws SQLException,ClassNotFoundException{
        DBConnection conn=new DBConnection();
        String sql="INSERT INTO tbl_employees(first_name,last_name,email,contact_no,salary)VALUES";
        sql+="('"+e.getFirstName()+"','"+e.getLastName()+"','"+e.getContactNo()+"','"+e.getEmail()+"',"+e.getSalary()+")";
       return conn.executeUpdate(sql);
        
    }

    @Override
    public int update(Employee e) {
        return 0;
        
    }

    @Override
    public boolean delete(int id) {
        return false;
       
    }

    @Override
    public Employee getById(int id) {
        return null;
      
    }

    @Override
    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
    List<Employee> employeeList=new ArrayList<>();
     
    DBConnection conn=new DBConnection();
    String sql="SELECT *from tbl_employee";
        ResultSet rs= conn.executeQuery(sql);
        while(rs.next()){
        Employee emp=new Employee();
        emp.setId(rs.getInt("employee_id"));
        emp.setFirstName(rs.getString("first_name"));
        emp.setLastName(rs.getString("last_name"));
        emp.setEmail(rs.getString("email"));
        emp.setContactNo(rs.getString("contact_no"));
        emp.setSalary(rs.getDouble("salary"));
        
        employeeList.add(emp);
        }
     
    return employeeList;  
    }

    @Override
    public List<Employee> search(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadFromFile(TextFileHandler fileHandler) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void storeIntoFile(TextFileHandler fileHandler) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
