# Plane Management System ✈️  

This project was developed as part of my university coursework.  
It simulates a simple airline ticketing system with the ability to:  

- **Buy a ticket** (with full input validation)  
- **Cancel a ticket**  
- **View and find available seats**  
- **Print ticket information**  
- **Search for specific tickets**  
- **Save results** to a text file for later reference  

---

## Features  

- Interactive **menu-driven interface** for user navigation  
- Strong **input validation** to prevent invalid seat numbers or duplicate bookings  
- Tickets and passengers represented as **objects**, following **Object-Oriented Programming (OOP)** principles  
- **Persistent storage** of ticket information using text files  
- Use of **arrays** (and loops) to manage seat allocation and availability  
- **Separation of concerns** between classes (e.g., `Person`, `Ticket`, and the main program class)  

---

## Example Screenshots  

### Program Menu  
<p align="center">
  <img width="940" height="609" alt="image" src="https://github.com/user-attachments/assets/bcd47694-5e5f-4b9b-a733-c9275918388b" />
</p>  

### Input Validation  
<p align="center">
  <img width="371" height="148" alt="image" src="https://github.com/user-attachments/assets/ba9d920b-4d55-4599-9b8b-c3684e7031b7" />
</p>  

### Ticket Information  
<p align="center">
  <img width="319" height="254" alt="image" src="https://github.com/user-attachments/assets/ccd46fc6-51bc-4848-9452-de59fd767736" />
</p>  

### Saved Text File  
<p align="center">
  <img width="189" height="296" alt="image" src="https://github.com/user-attachments/assets/ee8a0b78-6684-4d70-be47-20f7a26d26f3" />

</p>  

---

## Programming Techniques Used  

This project demonstrates a variety of programming concepts, including:  

- **Object-Oriented Programming (OOP)**  
  - `Person` and `Ticket` classes model real-world entities.  
  - Encapsulation ensures that attributes like passenger details and ticket info are well-structured.  
- **Arrays & Iteration**  
  - Seats are tracked using arrays, allowing efficient searching, allocation, and cancellation.  
- **Validation**  
  - Ensures correct seat numbers, prevents invalid inputs, and avoids duplicate bookings.  
- **File Handling**  
  - Ticket details are written to and read from a text file for persistence.  
- **Menu-Driven Interface**  
  - Implemented using loops and conditionals for a smooth user experience.  

---

## How to Run  

### Prerequisites  
- [Java 17+](https://adoptium.net/) (or compatible JDK)  
- [Apache Maven](https://maven.apache.org/)  

### Steps  
1. Clone this repository:  
   ```bash
   git clone https://github.com/Mgilgil/PlaneManagement.git
2. Run W2046446_PlaneManagement.java
