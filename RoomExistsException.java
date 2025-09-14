//Exception to handle adding a room that is already on the list
package HotelReservationSystem;

public class RoomExistsException extends RuntimeException{
	public RoomExistsException() {
		super("This room already exists.");
	}
	
	public RoomExistsException(String message) {
		super(message);
	}
}
