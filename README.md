# Hotel Reservation System

A Java-based hotel reservation system built to practice Object-Oriented Programming (OOP) fundamentals.  
The system includes functionality for adding, finding, and canceling reservations, as well as managing guests and employees.  

## Features
- Prevents double-booking by checking for overlapping reservation dates  
- Supports guest, employee, and room management 

## OOP Skills Used
- **Classes & Objects**: Separate classes for Reservations, Guests, Employees, and Rooms  
- **Inheritance & Aggregation**: Employees and Guests modeled with shared and specialized attributes  
- **Enums**: Booking status (e.g., `CONFIRMED`, `CANCELED`)  
- **Custom Exceptions**: Custom exception handling for invalid operations  
- **Collections**: `ArrayList` used for holding current reservation data 

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/cweiss15/Hotel-Reservation-System.git
2. Open the project in your preferred IDE (e.g., Eclipse, IntelliJ).
3. Run the HotelReservationSystem.java file to launch the program.
