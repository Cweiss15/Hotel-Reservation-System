//Exception to handle check out date that's earlier than check in date and birthdate after the current date
package HotelReservationSystem;

public class InvalidDateException extends RuntimeException{
	public InvalidDateException() {
		super("An invalid date has been entered.");
	}
	
	public InvalidDateException(String message) {
		super(message);
	}
}
