/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Navin
 */
public class TextFileHandler {
String filePath;
    public TextFileHandler(String filePath) {
        this.filePath=filePath;
    }
    
    public void setFilePath(String filePath){
    this.filePath=filePath;
    }
    public List<String> read(String filePath) throws FileNotFoundException, IOException{
    List<String> lines=new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new FileReader(new File(filePath)));
        String line="";
        while(null!=(line=reader.readLine())){
            lines.add(line);
            
        }
        reader.close();
        return lines;
    }
    public  void Write(String content ) throws IOException{

        FileWriter writer=new FileWriter(new File(filePath));
        writer.write(content);
        writer.close();
}

    public List<String> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


