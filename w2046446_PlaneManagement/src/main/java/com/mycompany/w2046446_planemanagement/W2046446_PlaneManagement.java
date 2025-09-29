/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.w2046446_planemanagement;

import java.util.*;

/**
 *
 * @author msi
 */
public class W2046446_PlaneManagement {

    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");
        Ticket[][] tickets = {{null,null,null,null,null,null,null,null,null,null,null,null,null,null}, {null,null,null,null,null,null,null,null,null,null,null,null}, {null,null,null,null,null,null,null,null,null,null,null,null}, {null,null,null,null,null,null,null,null,null,null,null,null,null,null}};
        Scanner input = new Scanner(System.in);  // above code is a 2 dimensional array for rows and seats. 4 rows and 14 or 12 seats on each row
        boolean menuQuit = false;  // Set to false so program can loop until '0' is entered to quit
        while (menuQuit != true) {
            System.out.println("*************************************************");
            System.out.println("*                 MENU OPTIONS                  *");
            System.out.println("*************************************************");
            System.out.println("    1) Buy a seat");
            System.out.println("    2) Cancel a seat");
            System.out.println("    3) Find first available seat");
            System.out.println("    4) Show seating plan");
            System.out.println("    5) Print tickets information and total sales ");
            System.out.println("    6) Search ticket");
            System.out.println("    0) Quit");
            System.out.println("*************************************************");
            boolean correct = false;
            int option = 0;  // Checks if a valid menu option is entered from 1-6
            while (correct != true) {
                try {
                    System.out.println("Please select an option: ");
                    option = input.nextInt();
                    if (option < 0 || option > 6) {
                        System.out.println("Please select an option between 0 and 6");
                    } else {
                        correct = true;
                    }
                } catch (InputMismatchException e) { // if an integer is not entered code doesn't crash.
                    System.out.println("Please enter an integer");
                    input.next();
                }
            }
            switch (option) {  // calls methods based on user choice in menu.
                case 0:
                    System.out.println("Programme terminated. Goodbye!");
                    menuQuit = true;
                    break;
                case 1:
                    buy_seat(tickets);
                    break;
                case 2:
                    cancel_seat(tickets);
                    break;
                case 3:
                    find_first_available(tickets);
                    break;
                case 4:
                    show_seating_plan(tickets);
                    break;
                case 5:
                    print_tickets_info(tickets);
                    break;
                case 6:
                    search_ticket(tickets);
                    break;
            }
        }

    } 
    private static String enter_ticket_row () {
        Scanner input = new Scanner(System.in);
        boolean validRow = false;
        String row = "";  // asks the user to enter a row letter and loops until valid row letter is entered.
        while (validRow != true) {
            try {
                System.out.println("Enter Row: ");
                row = input.nextLine();
                if (row.equals("A") || row.equals("B") || row.equals("C") || row.equals("D")) {
                    validRow = true;
                }
                else {
                    System.out.println("Row is not correct.");
                }
            } catch (InputMismatchException e) { // not needed necessarily as almost all inputs can be cast into string.
                System.out.println("Row is not correct.");
                input.next();
            }
        }
        return row;
    }
    private static int row_letter_to_number(String row){
        int rowNumber = 0;  // converts the row letter entered by user to a number so it can be used as an index for Ticket[][] array.
        switch (row) {
                case "A":
                    rowNumber = 0;
                    break;
               case "B":
                    rowNumber = 1;
                    break;
               case "C":
                   rowNumber = 2;
                   break;
               case "D":
                   rowNumber = 3;
                   break;
        }
        return rowNumber;
    }
    private static int enter_ticket_seat (Ticket[][] tickets, int rowNumber) {
        Scanner input = new Scanner(System.in);
        boolean validSeatNumber = false;
        int seatNumber = 0;  // allows user to input seat number until a valid choice is entered. 
        while (validSeatNumber != true) {
            try {
                System.out.println("Enter seat number: ");
                seatNumber = input.nextInt();
                if (seatNumber >0 && seatNumber <= tickets[rowNumber].length) {  //if an integer is entered it checks to see if this integer is between the correct ranges. As some rows have different number of seats tickets[rowNumber].length is used to check the length of the row which is how many seats it has.
                    validSeatNumber = true;
                    seatNumber = seatNumber-1;  // seatNumber is -1 to use as an index in array.
                }
                else {
                    System.out.println("Seat number out of range.");
                }
            } catch (InputMismatchException e) {  // stops the program from crashing if a non-integer is entered.
                System.out.println("Invalid seat number.");
                input.next();
            }
        }
        return seatNumber;
    }
    private static Ticket[][] buy_seat(Ticket[][] tickets) {
        Scanner input = new Scanner(System.in);
        int price;
        String row = enter_ticket_row(); // enter_ticket_row() method to ask user for row and to validate the row entered.
        int rowNumber = row_letter_to_number(row);  // calls row_letter_to_number() method and sends the row letter entered above as arguement.
        int seatNumber = enter_ticket_seat(tickets, rowNumber);  // gets seatNumber by calling enter_ticket_seat(). takes tickets array as arguement and rowNumber so it can use in method.
        if (seatNumber >= 0 && seatNumber <= 4) {  // sets price based on seat.
            price = 200;
        }
        else if (seatNumber >= 5 && seatNumber <= 8) {
            price = 150;
        }
        else {
            price = 180;
        }
        
        if (tickets[rowNumber][seatNumber] == null) {   //checks if seat is empty. if it is asks for personal information. If it isn't it returns tickets array without making any changes.
            System.out.println("Enter your name: ");
            String name = input.nextLine();
            System.out.println("Enter your surname: ");
            String surname = input.nextLine();
            System.out.println("Enter your email: ");
            String email = input.nextLine();
            Person person = new Person(name, surname, email);  // creates a new object of class Person using input entered above.
            person.setEmail(email);  // makes sure email entered is valid before making ticket
            Ticket ticket = new Ticket(row, seatNumber+1, price, person);   // creates a new object of class Ticket. seatNumber is +1 to return to original value entered and the value is unchanged so can be used as index later.
            ticket.save();  // uses save method of class Ticket to create a .txt file of ticket.
            tickets[rowNumber][seatNumber] = ticket;  // puts object ticket into array.
            System.out.println("Ticket Purchased.");
            return tickets;
        } 
        else {
            System.out.println("This seat is not available.");
            return tickets;
        }
        
    }
    private static Ticket[][] cancel_seat(Ticket[][] tickets) {
        String row = enter_ticket_row(); // similar to buy_ticket method. 
        int rowNumber = row_letter_to_number(row);
        int seatNumber = enter_ticket_seat(tickets, rowNumber); 
        if (tickets[rowNumber][seatNumber] != null) {  // checks to see if specified location in array is not empty. If it's not empty it deletes the object in that location.
            tickets[rowNumber][seatNumber].delete();  // deletes file using delete() method of class Ticket(this is an extra method I implemented not required by coursework).
            tickets[rowNumber][seatNumber] = null;  // changes location where ticket was to null.
            System.out.println("Ticket Cancelled.");
            return tickets;
        } 
        else {
            System.out.println("Ticket not found. This seat is already available");  // if specified location is already empty it prints message and returns array unchanged.
            return tickets;
        }
    }
    private static void find_first_available(Ticket[][] tickets) {
        boolean seatFound = false;
        int indexRow;
        String row = "";  // linear search algorithm below.
        for (indexRow = 0; indexRow <= 3; indexRow++) { // iterates 4 times because plane has 4 rows.
            int indexSeat = 0;  // after each iteration reset index for seat to zero otherwise while loop will stop after first row is completed.
            while ( indexSeat < tickets[indexRow].length && tickets[indexRow][indexSeat]!= null) {  //continues to search through each seat. If it's occupied the index is increased by 1 and this process is repeated until either an empty seat is found or the end of the row has been reached(no more seats left to check in that row)
                indexSeat++;
            }
            switch (indexRow) {  // switches to indexRow to corresponding letter so it can be printed below.
                case 0:
                    row = "A";
                    break;
                case 1:
                    row = "B";
                    break;
                case 2:
                   row = "C";
                   break;
                case 3:
                   row = "D";
                   break;
        }
            if (indexSeat != tickets[indexRow].length) {  // checks to see if indexSeat is not equal to length of the row. If it is a seat has not been found so we need to check next row. If it has been found it will display the seat.
                indexSeat++;
                System.out.println("First available seat is: "+ row + indexSeat );
                indexRow = 4;  // to break out of for loop.
                seatFound = true; 
            }
        }
        if (seatFound == false){
            System.out.println("No available seats");  // if seatFound variable hasn't changed after looping through all rows this mesaage is displayed.
        }
    }
    private static void show_seating_plan(Ticket[][] tickets) {
        int indexRow;
        for (indexRow = 0; indexRow <=3; indexRow++) {  // goes through each row.
            int indexSeat = 0;
            while (indexSeat < tickets[indexRow].length) {  // goes trhough each seat on each row.
                if (tickets[indexRow][indexSeat] == null){  // checks if seat is empty if empty prints 'O'.
                    System.out.print("O");
                }
                else {
                    System.out.print("X"); // if seat is not empty then it prints 'X'. 
                }
                indexSeat++;  // increments to next seat.
            }
            System.out.println("");  // allows next row to be printed on next line rather than on the same line.
        }
        System.out.println("");
    }
    private static void print_tickets_info(Ticket[][] tickets) {
        int indexRow;
        int indexSeat = 0;
        int ticketsSold = 0;
        int totalPrice = 0;
        System.out.println("Printing Ticket Information");
        System.out.println("---------------------------------------");
        for (indexRow = 0; indexRow <=3; indexRow++) {
            indexSeat = 0;
            while (indexSeat < tickets[indexRow].length) {  // goes through each row and seat and checks to see if there are any locations that are not empty.
                if (tickets[indexRow][indexSeat] != null){
                    ticketsSold++;
                    Ticket ticket = tickets[indexRow][indexSeat];
                    System.out.println("Ticket " +ticketsSold);  // ticket number.
                    System.out.println("---------------------------------------");
                    System.out.println("Ticket Information: ");
                    ticket.printTicket();  // uses printTicket() method of class Ticket to print ticket.
                    System.out.println("---------------------------------------");
                    totalPrice = totalPrice + ticket.getPrice();  // uses getter for attribute price in class Ticket to add to total.
                }
                indexSeat++;
            }
        }
        if (ticketsSold == 0) {
            System.out.println("---------------------------------------");
            System.out.println("No tickets sold.");  // if no tickets have been found this will display.
        }
        else {
            System.out.println("Total Sales: "+ totalPrice);  // 
        }
    }
    private static void search_ticket(Ticket[][] tickets) {
        String row = enter_ticket_row();  //asks user for row they are searching for.
        int rowNumber;
        rowNumber = row_letter_to_number(row);   //Converts row letter entered into number to be used as index in array.
        int seatNumber = enter_ticket_seat(tickets, rowNumber);  //asks user for seat they are searching for.
        if (tickets[rowNumber][seatNumber] == null) {  // if the index the user inputted is empty then print "Seat not found." 
            System.out.println("Seat not found.");
        }
        else {
            Ticket ticket = tickets[rowNumber][seatNumber];  // if the index the user inputted is not empty it will display ticket.
            System.out.println("---------------------------------------");
            System.out.println("Ticket Information: ");
            ticket.printTicket();
            System.out.println("---------------------------------------");
        }
    }
}
