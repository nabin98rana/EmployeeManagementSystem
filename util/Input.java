/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Navin
 */
public class Input {
    public static String getString()throws IOException{
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    return reader.readLine();
    }

    public static int getInt()throws IOException{
    return Integer.parseInt(getString());
    }
       public static Double getDouble()throws IOException{
    return Double.parseDouble(getString());
    }
    
}
