//Hotel class: aggregates arraylists of rooms, employees, and reservations and some basic functional methods to add, remove, search, ect.
package HotelReservationSystem;
import java.time.LocalDate;
import java.util.ArrayList;
public class Hotel {
		private ArrayList<Room> rooms = new ArrayList<>();
		private ArrayList<Reservation> reservations = new ArrayList<>();
		private ArrayList<Employee> employees = new ArrayList<>();

		public Hotel() {
			
		}
		
		//Constructor with deep copies of ArrayList fields
		public Hotel(ArrayList <Room> rooms, ArrayList<Reservation> reservations, ArrayList<Employee> employees) {
			this.rooms = new ArrayList<>();
			for (Room r: rooms) {
				this.rooms.add(new Room(r));		
			this.reservations = new ArrayList<>();
			}
			for (Reservation r: reservations) {
				this.reservations.add(new Reservation(r));
			}
			this.employees = new ArrayList<>();
			for (Employee e: employees) {
				this.employees.add(new Employee(e));
			}
		}

		//Setters and getters with deep copies
		public void setRooms(ArrayList<Room> rooms) {
			this.rooms = new ArrayList<>();
			for (Room r: rooms) {
				this.rooms.add(new Room(r));	
			}
		}

		public void setReservations(ArrayList<Reservation> reservations) {
			this.reservations = new ArrayList<>();
			for (Reservation r: reservations) {
				this.reservations.add(new Reservation(r));
			}
		}

		public void setEmployees(ArrayList<Employee> employees) {
			this.employees = new ArrayList<>();
			for (Employee e: employees) {
				this.employees.add(new Employee(e));
			}
		}
		
		public ArrayList<Room> getRooms() {
			ArrayList <Room> copyRooms = new ArrayList<>();
			for (Room r: rooms) {
				copyRooms.add(new Room(r));	
			}
			return copyRooms;
		}

		public ArrayList<Reservation> getReservations() {
			ArrayList <Reservation> copyReservations = new ArrayList<>();
			for (Reservation r: reservations) {
				copyReservations.add(new Reservation(r));
			}
			return copyReservations;
		}

		public ArrayList<Employee> getEmployees() {
			ArrayList<Employee> copyEmployees = new ArrayList<>();
			for(Employee e: employees) {
				copyEmployees.add(new Employee(e));
			}
			return copyEmployees;
		}
		
		
		//to string
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append("Rooms/n" + rooms + "\n\nReservations\n" + reservations + "\n\nEmployees" + employees);
			return str.toString();
		}
		
		//Method to add a room to the ArrayList
		public void addRoom(Room r) {
			for (Room room : rooms) {
				if (room.equals(r))
					throw new RoomExistsException(); }
				rooms.add(r);
				}
			
		//Method to add a reservation to the ArrayList
		public void addReservation(Reservation r) {
			for (Reservation rsv: reservations) {
				if (rsv.equals(r))
					throw new ReservationExistsException(); }
				reservations.add(r);
				}
		
		//Method to cancel a reservation
		public void cancelReservation(String reservationNumber) {
			for(int i=0; i<reservations.size(); i++) {
				if(reservations.get(i).getGuest().getReservationNumber().equals(reservationNumber)) {
					reservations.remove(i); 
					return;}
			}
				throw new ReservationNotFoundException();
		}
		
		//Method to find a room's information
		public Room roomInfo(int roomNumber) {
			for(Room r: rooms) {
				if (r.getRoomNumber()==roomNumber)
					return r;}
			return null;
			}
		
		//Method to find a guest's information
		public Guest guestInfo(String reservationNumber) {
			for(Reservation r: reservations) {
				if(r.getGuest().getReservationNumber().equals(reservationNumber))
					return r.getGuest();
			}
			return null;
		}
		
		//Method to add an employee to the ArrayList
		public void addEmployee(Employee e) {
			for (Employee emp: employees) {
				if (emp.equals(e))
					throw new EmployeeExistsException();
			}
			employees.add(e);
		}
		
		//Method to find an employee's information
		public Employee employeeInfo(String employeeID) {
			for(Employee e: employees) {
				if(e.getEmployeeID().equals(employeeID))
					return e;
			}
			return null;
		}
	}
