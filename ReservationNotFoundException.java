//Exception to handle searching for a reservation that doesn't exist
package HotelReservationSystem;

public class ReservationNotFoundException extends RuntimeException{
	public ReservationNotFoundException() {
		super("The reservation entered was not found.");
	}
	
	public ReservationNotFoundException(String message) {
		super(message);
	}
}
