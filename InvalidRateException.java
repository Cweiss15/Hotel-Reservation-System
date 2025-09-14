//Exception to handle a negative rate input
package HotelReservationSystem;

public class InvalidRateException extends RuntimeException {
	public InvalidRateException() {
		super("An invalid rate has been entered.");
	}
	
	public InvalidRateException(String message) {
		super(message);
	}
}
