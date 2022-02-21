/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteBuilder;

/**
 *
 * @author soblab
 */
public class Main {

    public static void main(String[] args) {
        Nitrite db1 = Nitrite.builder()
                .filePath("./company.db")
                .openOrCreate();
        
        
        
        
        
        
        
        
        
        
        
        db1.close();
    }
}
