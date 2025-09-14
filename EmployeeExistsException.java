//Exception for adding an employee that's already on the list
package HotelReservationSystem;

public class EmployeeExistsException extends RuntimeException {
	public EmployeeExistsException() {
		super("This employee already exists.");
	}
	
	public EmployeeExistsException(String message) {
		super(message);
	}

}
