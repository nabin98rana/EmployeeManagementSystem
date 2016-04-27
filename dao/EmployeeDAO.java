package com.ncit.ems.dao;

import com.ems.util.TextFileHandler;
import com.ncit.entity.Employee;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Navin
 */
public interface EmployeeDAO {
    public int insert(Employee e)throws SQLException,ClassNotFoundException;
    public int update(Employee e);
    public boolean delete(int id);
    public Employee getById(int id);
    public List<Employee> getAll()throws SQLException,ClassNotFoundException;
    public List<Employee>search(String param);
    public void loadFromFile(TextFileHandler fileHandler)throws IOException;
    public void storeIntoFile(TextFileHandler fileHandler)throws IOException;
}

