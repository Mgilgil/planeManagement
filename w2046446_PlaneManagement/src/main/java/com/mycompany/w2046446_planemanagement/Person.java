/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w2046446_planemanagement;

import java.util.Scanner;

/**
 *
 * @author msi
 */
public class Person {
    private String name;
    private String surname;   // attributes
    private String email;
    
    public Person(String n, String s, String e) {   // constructor
        name = n;
        surname = s;
        email = e;
    }
    
    public String getName() {  // getters
        return name;
    }
    
    public void setName(String n) {  // setters
        name = n;
    }
        
    
    public String getSurname() {
        return surname;
    }
    
     public void setSurname(String s) {
        surname = s;
    }
    
    public String getEmail() {
        return email;
    }
    
     public void setEmail(String e) {
        Scanner input = new Scanner(System.in);
        boolean validEmail = false;
        while (validEmail == false) {
            if (email.contains("@") && email.contains(".")){  // validation for email. checks if email has an '@' and '.'. 
                validEmail = true;
            }
            else {
                System.out.println("Incorrect email. Please enter a vaild email. ");
                email = input.nextLine();
            }
        }
    }
     
    public void printPerson() {  // to print information about object.
         System.out.println("Name: "+ name);
         System.out.println("Surname: "+ surname);
         System.out.println("Email: "+ email);
    }
}
