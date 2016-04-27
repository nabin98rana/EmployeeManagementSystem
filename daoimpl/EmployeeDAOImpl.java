/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncit.ems.daoimpl;

import com.ems.util.TextFileHandler;
import com.ncit.ems.dao.EmployeeDAO;
import com.ncit.entity.Employee;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Navin
 */
public class EmployeeDAOImpl implements EmployeeDAO {
private List<Employee> employeeList=new ArrayList<>();

    public EmployeeDAOImpl(ArrayList<Employee> arrayList) {
      employeeList=new ArrayList<>();
               
        
    }
 public EmployeeDAOImpl(List<Employee> employeeList){
      this.employeeList=employeeList;
 }
    
   

    @Override
    public void loadFromFile(TextFileHandler fileHandler)throws IOException  {
        List<String> lines=fileHandler.read();

            for(String s:lines){
            /*String[] tokens=s.split(",");
            if(tokens.length>6){
            Employee e=new Employee();
            e.setId(Integer.parseInt(tokens[0]));
            e.setFirstName(tokens[1]);
            e.setLastName(tokens[2]);
            e.setEmail(tokens[3]);
            e.setContactNo(tokens[4]);
            e.setSalary(Double.parseDouble(tokens[5]));
                    */
                StringTokenizer tokenizer=new StringTokenizer(s,",");
                if(tokenizer.countTokens()>=5){
                    Employee e=new Employee();
            e.setId(Integer.parseInt(tokenizer.nextToken()));
            e.setFirstName(tokenizer.nextToken());
            e.setLastName(tokenizer.nextToken());
            e.setEmail(tokenizer.nextToken());
            e.setContactNo(tokenizer.nextToken());
            e.setSalary(Double.parseDouble(tokenizer.nextToken()));
                  
                   employeeList.add(e);
                
                }
                
             
   }
   }

   
@Override
    public int  insert(Employee e) {
       employeeList.add(e);
    return 0;
        
    }

    @Override
    public int update(Employee e) {
        employeeList.get(e.getId()).setFirstName(e.getFirstName());
        System.out.println("Employee id"+e.getId()+"updated in the database");
    return 1;
    }

    @Override
        public boolean delete(int id) {
        Employee e=getById(id);
        if(e!=null){
        employeeList.remove(e);
        return true;
        }
        return false ;
     
                
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
     public Employee getById(int id) {
        for(Employee e:employeeList){
        if(e.getId()==id){
        return e;
          }
       }
       return  null;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAll() {
     return employeeList;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> search(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void storeIntoFile(TextFileHandler fileHandler) throws IOException {
       String content="";
       for(Employee e:employeeList){
           content+=e.toCVS();
           
       }
       fileHandler.Write(content);
    }

 

    
    
}
