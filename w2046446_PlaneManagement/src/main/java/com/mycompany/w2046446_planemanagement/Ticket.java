/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w2046446_planemanagement;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;  
import java.util.Scanner;
/**
 *
 * @author msi
 */
public class Ticket {
    private String row;
    private int seat;  // attributes
    private int price;
    private Person person;  // object of class Person
    
    public Ticket(String r, int s, int pr, Person p ) {  // constructor
        row = r;
        seat = s;
        price = pr;
        person = p;
    }
    
    public String getRow() { // getters
        return row;
    }
    
    public void setRow(String r) {  // setters
         row = r;
    }
    
    public int getSeat() {
        return seat;
    }
    
    public void setSeat(int s) {
        seat = s;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int pr) {
        price = pr;
    }
    
    public Person getPerson() {
        return person;
    }
    
    public void setPerson(Person p) {
        person = p;
    }
    
    public void printTicket() {  // print information about object.
        System.out.println("Row: " +row);
        System.out.println("Seat: " +seat);
        System.out.println("Price: "+ price);
        person.printPerson();  // uses printPerson() method of class Person to print information about object.
    }
    
    public void save(){
        File myDirectory = new File("./Tickets");  // creates directory called Tickets if it doesn't exist already.
            if (!myDirectory.exists()){
                myDirectory.mkdirs();
            }
            String directoryName = "./Tickets/";
            String fileName = row + seat +".txt";
        try {
            File file = new File(directoryName + fileName);  // to create a new file with row and seat as the name in Tickets.
            boolean file_created = file.createNewFile();
            if (file_created) {
                System.out.println("Ticket created: " + file.getName());  // if .createNewFile() method returns true then the file didn't exist and it was created.
            }
            else {
                if (file.exists()){
                    System.out.println("Ticket already exists.");  
                }
                else {
                    System.out.println("Error while creating file: " + file.getName());  // if .createNewFile() method returns false and file.exists() method returns false then the file couldn't be created.
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();  // java requires exception handling when creating files.
        }
        try {
            FileWriter file = new FileWriter(directoryName + fileName);  // writes into or creates file to write into.
            file.write( row +"\n");
            file.write(seat +"\n");  // information to write into file. /n is to create new lines.
            file.write(price +"\n");
            file.write(person.getName() +"\n");
            file.write(person.getSurname() +"\n");
            file.write(person.getEmail() +"\n");
            file.close();  // saves changes ti file.
        }
        catch (IOException e) {
            System.out.println("Error while writing in a file.");  
            e.printStackTrace();
        }
    }
    
    public void delete() {  // extra method I implemented myself. Deletes file when ticket is cancelled.
        File myDirectory = new File("./Tickets");
            if (!myDirectory.exists()){
                myDirectory.mkdirs();
            }
            String directoryName = "./Tickets/";
            String fileName = row + seat +".txt";
        File file = new File(directoryName + fileName);
        if (file.exists()){  // if the file exists in Tickets it will delelte file.
            file.delete();
            System.out.println("Ticket deleted.");
        }
    }
}
    
