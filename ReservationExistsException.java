//Exception to handle adding a reservation that is already on the list
package HotelReservationSystem;

public class ReservationExistsException extends RuntimeException{
	public ReservationExistsException() {
		super("This reservation already exists.");
	}
	
	public ReservationExistsException(String message) {
		super(message);
	}
}
