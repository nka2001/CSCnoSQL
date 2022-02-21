/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab;

import org.dizitart.no2.Cursor;
import org.dizitart.no2.Document;
import static org.dizitart.no2.Document.createDocument;
import org.dizitart.no2.Filter;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteBuilder;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.filters.Filters;
import static org.dizitart.no2.filters.Filters.eq;

import java.util.Scanner;

/**
 *
 * @author soblab
 */
public class Main {

    public static void main(String[] args) {
        Nitrite db1 = Nitrite.builder()
                .filePath("./company.db")
                .openOrCreate();

        NitriteCollection c = db1.getCollection("Employees");

        createDoc(c, 1, "rose diaz", 100000);
        createDoc(c, 2, "Mateo Lopez", 50000);
        createDoc(c, 3, "John Smith", 75000);

        /**
         * ****************************
         */
        //with filters
        /**
         * ****************************
         */
        //Cursor r2 = c.find(Filter.eq("firstName","John"));
        /*
        for(Document doc : r2){
            System.out.println(doc.toString());;
        }
         */
        db1.close();
    }

    public static void createDoc(NitriteCollection c, int id, String name, double salary) {

        Document d = createDocument("id", id)
                .put("firstName", name)
                .put("Salary", salary);

        c.insert(d);

    }

    public static void deleteEmp(NitriteCollection c, int id) {
        c.remove(eq("id", id));

    }

    public static void displayEmp(NitriteCollection c) {
        Cursor r = c.find();

        for (Document doc : r) {
            System.out.println(doc.toString());;
        }
        /* filters
         Cursor results = c.find(Filters.gt("Salary", 70000.0));
        for (Document currDoc : results) {
            System.out.println(currDoc.toString());;
        }
         */
    }
}
