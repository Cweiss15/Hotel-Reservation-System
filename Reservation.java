//Reservation class: aggregates room and guest
package HotelReservationSystem;
import java.time.LocalDate;
public class Reservation {
	private Room room;
	private Guest guest;
	private BookingStatus bookingStatus;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	
	//Overloaded constructors
	public Reservation (Room room, Guest guest, BookingStatus bookingStatus, LocalDate checkInDate, LocalDate checkOutDate) {
		this.room = room;
		this.guest = guest;
		this.bookingStatus = bookingStatus;
		this.checkInDate = checkInDate;
		if (checkOutDate.isBefore(checkInDate))
			throw new InvalidDateException("The check out date must be after the check in date.");
		this.checkOutDate = checkOutDate;
	}
	
	public Reservation (Room room, Guest guest, BookingStatus bookingStatus, String checkInDate, String checkOutDate) {
		this(room, guest, bookingStatus, LocalDate.parse(checkInDate), LocalDate.parse(checkOutDate));
	}
	
	public Reservation (int roomNumber, String roomType, boolean isAvailable, double nightlyRate, 
			String f, String l, Gender g, Address addr, String birthdate, String reservationNumber, String phoneNumber,
			String email, BookingStatus bookingStatus, LocalDate checkInDate, LocalDate checkOutDate) {
		this(new Room(roomNumber, roomType, isAvailable, nightlyRate), new Guest(f, l, g, addr, birthdate, reservationNumber, phoneNumber, email),
				bookingStatus, checkInDate, checkOutDate);
	}
	
	public Reservation (Room room, Guest guest) {
		this.room=room;
		this.guest=guest;
	}
	
	public Reservation () {
		
	}
	
	//Copy constructor
	public Reservation (Reservation r) {
		this(new Room(r.room), new Guest(r.guest), r.bookingStatus, r.checkInDate, r.checkOutDate);
	}
	
	//setters and getters
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		if (checkOutDate.isBefore(checkInDate))
			throw new InvalidDateException("The check out date must be after the check in date.");
		this.checkOutDate = checkOutDate;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	
	public Guest getGuest() {
		return guest;
	}
	
	public Room getRoom() {
		return room;
	}

	//to string
	@Override
	public String toString() {
	StringBuilder str = new StringBuilder();
	str.append(guest + "\n" + room + "\nBooking Status: " + bookingStatus + "\nCheck in: " + checkInDate + "\nCheck out: " + checkOutDate);
	return str.toString();
	}
	
}
