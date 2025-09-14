//A hotel reservation system. contains a few added reservations and employees and a menu driven interface to add more, cancel, search, etc.
package HotelReservationSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.format.DateTimeParseException;

public class HotelReservationSystem {
	public static void main(String[] args) {
		//Creating ArrayLists of rooms, reservations, and employees
		ArrayList<Room> rooms = new ArrayList<>();
		ArrayList<Reservation> reservations = new ArrayList<>();
		ArrayList<Employee> employees = new ArrayList<>();

		//Methods to add to the ArrayLists
		starterRooms(rooms);
		starterReservations(rooms, reservations);
		starterEmployees(employees);

		//Creating a hotel object
		Hotel hotel = new Hotel(rooms, reservations, employees);

		Scanner input = new Scanner(System.in);
		
		//Menu driven interface
		int option;
		System.out.println("Welcome to Seaside Hotel!");
		try {
			do {
				//displays menu
				option = displayMenu(input);

				switch (option) {
				case 1: {
					//Displays pricing and room options
					displayPricing();
					break;
				}

				case 2: {
					//Adds a reservation
					addReservation(input, rooms, reservations, hotel);
					break;
				}

				case 3: {
					//Cancels a reservation
					cancelReservation(input, reservations, hotel);
					break;
				}

				case 4: {
					//finds a reservation
					findReservation(input, reservations, hotel);
					break;
				}
				case 5: {
					//adds a room
					addRoom(input, hotel, rooms);
					break;
				}
				case 6: {
					//finds a room
					findRoom(input, rooms, hotel);
					break;
				}
				case 7: {
					//adds an employee
					addEmployee(input, employees, hotel);
					break;
				}
				case 8: {
					//finds an employee
					findEmployee(input, employees, hotel);
					break;
				}
				case 9: {
					//displays current reservations
					displayReservations(reservations, hotel);
					break;
				}
				case 10: {
					//displays current rooms
					displayRooms(rooms, hotel);
					break;
				}
				case 11: {
					//displays current employees
					displayEmployees(employees, hotel);
					break;
				}
				}
				//repeats menu until user enters -1
			} while (option != -1);
			//Handles input mismatch exceptions
		} catch (InputMismatchException e) {
			System.out.println("An exception was thrown due to input mismatch.");
		}
	}

	
	//Adds rooms to ArrayList
	public static void starterRooms(ArrayList<Room> rooms) {
		String roomType;
		//Adds 10 rooms that's numbers are 101-111
		for (int i = 101; i < 111; i++) {
			int roomNumber = i;
			int nightlyRate;
			//Sets all rooms to available
			boolean isAvailable = true;
			//Assigns every third room to suite and sets price
			if (i % 3 == 0) {
				roomType = "suite";
				nightlyRate = 200;
				//Assigns every third room to single and sets price
			} else if (i % 3 == 1) {
				roomType = "single";
				nightlyRate = 100;
				//Assigns every third room to double and sets price
			} else {
				roomType = "double";
				nightlyRate = 150;
			}
			//Creates new room object and adds to the ArrayList
			Room room = new Room(roomNumber, roomType, isAvailable, nightlyRate);
			rooms.add(room);
		}
	}

	//Adds reservations to the ArrayList
	public static void starterReservations(ArrayList<Room> rooms, ArrayList<Reservation> reservations) {
		//Creates three addresses
		Address one = new Address("Main Street", "Brooklyn", "New York", "11213");
		Address two = new Address("Flamingo Street", "Miami", "Florida", "33140");
		Address three = new Address("Forbes Avenue", "Pittsburgh", "Pennsylvania", "15217");
		
		//Creates three guests
		Guest GOne = new Guest("Alice", "Johns", Gender.F, one, "1990-12-10", "456", "786-241-7834", "alice@gmail.com");
		Guest Gtwo = new Guest("Max", "Bar", Gender.M, two, "1976-09-16", "457", "305-241-7834", "max@gmail.com");
		Guest Gthree = new Guest("Patty", "Smith", Gender.F, three, "1967-05-21", "458", "412-241-7834",
				"patty@gmail.com");

		//Creates three reservations
		Reservation Rone = new Reservation(rooms.get(0), GOne, BookingStatus.CONFIRMED, "2025-06-07", "2025-06-12");
		Reservation Rtwo = new Reservation(rooms.get(1), Gtwo, BookingStatus.PENDING, "2025-08-16", "2025-08-19");
		Reservation Rthree = new Reservation(rooms.get(2), Gthree, BookingStatus.CONFIRMED, "2025-06-20", "2025-06-27");

		//Adds the reservations to the ArrayList
		reservations.add(Rone);
		reservations.add(Rtwo);
		reservations.add(Rthree);
	}

	//Adds employees to the ArrayList
	public static void starterEmployees(ArrayList<Employee> employees) {
		//Creates three employees (yes they are all neighbors ;)
		Address one = new Address("Main Street", "Brooklyn", "New York", "11213");
		Employee EOne = new Employee("John", "Jhonson", Gender.M, one, "1900-10-03", "72453", "Housekeeper",
				"Maintenance");
		Employee Etwo = new Employee("Kara", "Jacobs", Gender.F, one, "1964-12-13", "82941", "Desk Clerk",
				"Front Office");
		Employee Ethree = new Employee("Keith", "Carls", Gender.M, one, "1981-02-04", "84092", "Concierge",
				"Costomer Service");

		//adds the employees to the ArrayList
		employees.add(EOne);
		employees.add(Etwo);
		employees.add(Ethree);
	}

	//Displays menu and returns user's option
	public static int displayMenu(Scanner input) {
		int option;
		System.out.println("How can we help you today?\n");
		System.out.println(
				"1. Room options and pricing\n2. Book a reservation\n3. Cancel a reservation\n4. Find a reservation"
						+ "\n5. Add a hotel room \n6. Find a room's details \n7. Add an employee \n8. Find an employee \n9. Display all reservations"
						+ "\n10. Display all rooms \n11. Display all Employees");
		System.out.print("\nEnter option 1-11 or -1 to exit: ");
		option = input.nextInt();
		input.nextLine();
		//Input validation for 1-11
		while (option != -1 && option < 1 || option > 11) {
			System.out.print("Your input was invalid please try again. Enter an option 1-11 or -1 to exit: ");
			option = input.nextInt();
			input.nextLine();
		}
		return option;
	}

	//Displays pricing and room type details
	public static void displayPricing() {
		System.out.println("\nThere are three room options");
		System.out.println(
				"Single\n$100 per night/nOne king size bed provided\n\nDouble\n$150 per night\nTwo queen size beds provided"
						+ "\n\nSuite\n$200 per night\nTwo queen size beds and living and kitchenette space provided\n");
	}
	
	//adds a reservation to the list and checks for room type and dates availability
	public static void addReservation(Scanner input, ArrayList<Room> rooms, ArrayList<Reservation> reservations,
			Hotel hotel) {
		//Gets new booking's room type
		System.out.println("\nPlease enter the details for your stay below.");
		System.out.print("Room Type (Single/ Double/ Suite): ");
		String roomType = input.nextLine().toLowerCase();
		//input validation
		while (!roomType.equals("suite") && !roomType.equals("double") && !roomType.equals("single")) {
			System.out.print("Enter single, double, or suite for you room type: ");
			roomType = input.nextLine().toLowerCase();
		}
		
		//Method to find rooms on list of same type and returns as new ArrayList
		ArrayList<Room> matchingRooms = matchingRooms(roomType, input, rooms);
		
		//get's reservations checkin and out dates
		LocalDate checkIn = LocalDate.now();
		LocalDate checkOut = LocalDate.now();
		try {
			System.out.print("Check In Date (YYYY-MM-DD): ");
			String in = input.nextLine();
			checkIn = LocalDate.parse(in);
			System.out.print("Check Out Date (YYYY-MM-DD): ");
			String out = input.nextLine();
			checkOut = LocalDate.parse(out);
			//validates checkout is after checkin
			while (checkOut.isBefore(checkIn)) {
				System.out.println(
						"The check in date must be before the check out date. Please re-enter the correct dates below.");
				System.out.print("Check In Date (YYYY-MM-DD): ");
				in = input.nextLine();
				checkIn = LocalDate.parse(in);
				System.out.print("Check Out Date (YYYY-MM-DD): ");
				out = input.nextLine();
				checkOut = LocalDate.parse(out);
			}
		
		//method to check if room of that type is available for those dates and return which room should be used
		Room reserveRoom = availableRoom(matchingRooms, hotel.getReservations(), checkIn, checkOut);
		//if there is an available room gets rest of info for the reservation
		if (reserveRoom != null) {
			//calls a person method to get some of the info
			Person person = addPerson(input);
			System.out.print("Phone number: ");
			String phoneNumber = input.nextLine();
			System.out.print("Email: ");
			String email = input.nextLine();
			//Changes reservation number to a int and adds 1 to assign the new reservation to the next number
			int reservationNum = Integer.parseInt(hotel.getReservations().getLast().getGuest().getReservationNumber()) + 1;
			//Reverts new number back to a string
			String reservationNumber = String.valueOf(reservationNum);
			//Instantiates new reservation
			Guest addedGuest = new Guest(person, reservationNumber, phoneNumber,
					email);
			Reservation addedReservation = new Reservation(reserveRoom, addedGuest, BookingStatus.CONFIRMED, checkIn,
					checkOut);
			try {
				//uses object's method to add the new reservation to the list
				hotel.addReservation(addedReservation);
				//handles if the reservation already exists
			} catch (ReservationExistsException e) {
				System.out.println(e.getMessage());
			}
			//Displays message and new reservation
			System.out.println(
					"\n\nYou have successfully booked your stay. We can't wait to see you soon!\n\n" + addedReservation + "\n");
			//Displays message if no availability then
		} else
			System.out.println(
					"\nWe're sorry, there is no availablitiy for those dates. Please try again for different dates or room type.\n");
		//handles wrong checkin, checkout, or birthdates
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage() + "\n");
			//handles wrong date formatting
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format. Must be entered as YYYY-MM-DD.\n");
			input.nextLine();
		}
	}

	//Finds all rooms of the same type as the new reservation wants and returns ArrayList of matching type
		public static ArrayList<Room> matchingRooms(String roomType, Scanner input, ArrayList<Room> rooms) {
			//creates the matching rooms list
			ArrayList<Room> matchingRooms = new ArrayList<>();
			//loops through rooms and compares type, adds the equivalent type to new ArrayList
			for (Room r : rooms) {
				if (r.getRoomType().toLowerCase().equals(roomType))
					matchingRooms.add(r);
			}
			return matchingRooms;
		}
		
		//Checks if there is a room of certain type available for given dates
		public static Room availableRoom(ArrayList<Room> matchingRooms, ArrayList<Reservation> reservations,
				 LocalDate checkIn, LocalDate checkOut) {
			//loops through rooms of right type
			for (Room room : matchingRooms) {
				//returns room if available for those dates
				if (overlappingDates(reservations, room, checkIn, checkOut))
					return room;
			}
			return null;
		}
		
	//Checks if a room doesn't overlap bookings
	public static boolean overlappingDates(ArrayList<Reservation> reservations, Room room, LocalDate checkIn,
			LocalDate checkOut) {
		//loops through the reservations
		for (Reservation r : reservations) {
			//finds the passed in room number
			if (r.getRoom().equals(room)) {
				//if the dates overlap it returns false otherwise returns true
				if ((r.getCheckInDate().isBefore(checkOut) && r.getCheckOutDate().isAfter(checkIn)))
					return false;
			}
		}
		return true;
	}

	//Gets user info needed to instantiate a person object
	public static Person addPerson(Scanner input) {
		System.out.print("First name: ");
		String first = input.nextLine();
		System.out.print("Last name: ");
		String last = input.nextLine();
		Gender g;
		System.out.print("Gender (M/F): ");
		char gender = input.nextLine().toUpperCase().charAt(0);
		//input validation
		while (gender != 'M' && gender != 'F') {
			System.out.print("Male or Female must be entered: ");
			gender = input.nextLine().toUpperCase().charAt(0);
		}
		//assigns enum
		if (gender == 'M')
			g = Gender.M;
		else
			g = Gender.F;
		System.out.println("Address");
		System.out.print("Street: ");
		String street = input.nextLine();
		System.out.print("City: ");
		String city = input.nextLine();
		System.out.print("State: ");
		String state = input.nextLine();
		System.out.print("Zipcode: ");
		String zipcode = input.nextLine();
		System.out.print("Birthdate: (YYYY-MM-DD): ");
		String birthdate = input.nextLine();
		//Instantiates and returns person object
		Person person = new Person(first, last, g, street, city, state, zipcode, birthdate);
		return person;
	}

	//Cancels a reservation
	public static void cancelReservation(Scanner input, ArrayList<Reservation> reservations, Hotel hotel) {
		//Gets reservation number to cancel
		System.out.print("\nEnter the reservation number you'd like to cancel: ");
		String num = input.next();
		Reservation cancel = null;
			//Finds matching reservation that was cancelled
			for (Reservation r : hotel.getReservations()) {
				if (r.getGuest().getReservationNumber().equals(num)) {
					//Switches its booking status to cancelled
					cancel = r;
					r.setBookingStatus(BookingStatus.CANCELLED);
					break;}}
					try {
						//Cancel and displayed cancelled reservation
						hotel.cancelReservation(num);
					
					System.out.println("\nThe reservations has been successfully cancelled.\n" + cancel);
				
			//Handles if reservation number doesn't exist
		} catch (ReservationNotFoundException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}
	
	//adds a room
		public static void addRoom(Scanner input, Hotel hotel, ArrayList<Room> rooms) {
			//gets room type
			System.out.print("Enter the type of room being added (single/ double/ suite): ");
			String type = input.nextLine().toLowerCase();
			//input validation
			while (!type.equals("single") && !type.equals("double") && !type.equals("suite")) {
				System.out.print("Your input was invalid. Enter single/double/suite as the room type: ");
				type = input.nextLine().toLowerCase();
			}
			//assigns its rate based on type according to the system's pricing
			int rate;
			if (type.equals("single"))
				rate = 100;
			else if (type.equals("double"))
				rate = 150;
			else
				rate = 200;

			//gets room number
			System.out.print("Enter room number: ");
			int num = input.nextInt();
			//creates new room
			Room r = new Room(num, type, true, rate);
			try {
				//adds room to list and displays was completed
				hotel.addRoom(r);
				System.out.println("\nThe room has been successfully added. \n" + r + "\n");
				//handles if room added already exists
			} catch (RoomExistsException e) {
				System.out.println("\n" + e.getMessage() + "\n");
			}
		}

	//Finds a guest based on the reservation number
	public static void findReservation(Scanner input, ArrayList<Reservation> reservations, Hotel hotel) {
		//gets the reservation number
		System.out.print("Enter the reservation number: ");
		String num = input.next();
		try {
			//calls method to find and return guest and displays
			Guest g = hotel.guestInfo(num);
			System.out.println("\n" + g + "\n");
			//Handles if reservation number doesn't exist
		} catch (ReservationNotFoundException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	
	//finds room details based on its number
	public static void findRoom(Scanner input, ArrayList<Room> rooms, Hotel hotel) {
		//gets room number
		System.out.print("Enter a room number: ");
		int num = input.nextInt();
		//calls method to find room
		Room r = hotel.roomInfo(num);
		//displays room if found or message if not
		if (r == null)
			System.out.println("\nThere is no room with this number currently in the system.\n");
		else
			System.out.println("\n" + r + "\n");
	}

	//adds an employee to the list
	public static void addEmployee(Scanner input, ArrayList<Employee> employees, Hotel hotel) {
		//gets imployee's info
		System.out.println("\nEnter the new employee's information below.\n");
		//calls person method to get some of the info
		Person person = addPerson(input);
		System.out.print("Employee ID number: ");
		String id = input.nextLine();
		System.out.print("Role: ");
		String role = input.nextLine();
		System.out.print("Department: ");
		String department = input.nextLine();
		//creates new employee object
		Employee addedEmployee = new Employee(person, id, role, department);
		try {
			//adds employee to list and displays it
			hotel.addEmployee(addedEmployee);
			System.out.println("\nA new employee was successfully added.\n\n" + addedEmployee + "\n");
			//handles if employee is already on the list
		} catch (EmployeeExistsException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	//Finds and displays employee based on id number
	public static void findEmployee(Scanner input, ArrayList<Employee> employees, Hotel hotel) {
		//gets id number
		System.out.print("\nEnter employee ID: ");
		String idNum = input.next();
		//calls object's method to find and return employee
		Employee e = hotel.employeeInfo(idNum);
		//displays employee if found or message if not
		if (e == null)
			System.out.println("\nThere is no employee with this ID currently in the system.\n");
		else
			System.out.println("\n" + e + "\n");
	}

	//Displays reservations list
	public static void displayReservations(ArrayList<Reservation> reservations, Hotel hotel) {
		System.out.println("\nReservation List:");
		for (Reservation r : hotel.getReservations()) {
			System.out.println(r);
			System.out.println();
		}
	}

	//displays rooms list
	public static void displayRooms(ArrayList<Room> rooms, Hotel hotel) {
		System.out.println("\nHotel Rooms:");
		for (Room r : hotel.getRooms()) {	//uses hotel object's list since deep copy and original not changed with additions, etc.
			System.out.println(r);
			System.out.println();
		}
	}

	//displays employees list
	public static void displayEmployees(ArrayList<Employee> employees, Hotel hotel) {
		System.out.println("\nEmployee List:");
		for (Employee e : hotel.getEmployees()) {
			System.out.println(e);
			System.out.println();
		}
	}
}