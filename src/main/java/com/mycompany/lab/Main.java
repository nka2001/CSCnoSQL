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
        Scanner scan = new Scanner(System.in);

        int choice;
        System.out.println("please enter a choice: 1 for adding, 2 for deleting, and 3 for displaying");
        choice = scan.nextInt();

        if (choice == 1) {

            int id;
            String name;
            int salary;

            System.out.println("Please enter the ID");
            id = scan.nextInt();

            System.out.println("Please enter the name");
            name = scan.next();

            System.out.println("Please enter the salary");
            salary = scan.nextInt();

            createDoc(c, id, name, salary);
        }
        else if(choice == 2){
            System.out.println("please enter an id");
            int id = scan.nextInt();
            
            deleteEmp(c,id);
        }
        else if(choice == 3){
            displayEmp(c);
        }
        else{
            System.out.println("error wrong choice");
        }

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
