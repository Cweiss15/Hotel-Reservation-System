//Guest class inherits person
package HotelReservationSystem;
import java.time.LocalDate;
public class Guest extends Person {
	private String reservationNumber;
	private String phoneNumber;
	private String email;
	
	//Constructors (throws exception if fields left blank
	public Guest (String f, String l, Gender g, Address addr, String birthdate, String reservationNumber, String phoneNumber,
			String email) {
	super(f, l, g, addr, birthdate);
	if(reservationNumber.trim().isEmpty()) {
		throw new IllegalArgumentException ("A valid number must be entered.");
	}
	this.reservationNumber = reservationNumber;
	if(phoneNumber.trim().isEmpty()) {
		throw new IllegalArgumentException ("A valid number must be entered.");
	}
	this.phoneNumber = phoneNumber;
	if(email.trim().isEmpty()) {
		throw new IllegalArgumentException ("A valid email address must be entered.");
	}
	this.email = email;
	}

	public Guest (Person p, String reservationNumber, String phoneNumber, String email) {
		this(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), p.getBirthdate().toString(), reservationNumber, phoneNumber, email);
	}
	
	//Copy constructor
	public Guest (Guest g) {
		this(g.getFirstName(), g.getLastName(), g.getGender(), g.getAddress(), g.getBirthdate().toString(), g.reservationNumber, g.phoneNumber, g.email);
	}

	//Setters and getters
	public void setReservationNumber(String reservationNumber) {
		if(reservationNumber.trim().isEmpty()) {
			throw new IllegalArgumentException ("A valid number must be entered.");
		}
		this.reservationNumber = reservationNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.trim().isEmpty()) {
			throw new IllegalArgumentException ("A valid number must be entered.");
		}
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		if(email.trim().isEmpty()) {
			throw new IllegalArgumentException ("A valid email address must be entered.");
		}
		this.email = email;
	}
	
	public String getReservationNumber() {
		return reservationNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	//to string
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nRevervation number: " + reservationNumber + "\nPhone number: " + phoneNumber + "\nEmail: " + email);
		return str.toString();
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if(obj==this)
			return true;
		if(!(obj instanceof Guest))
		return false;
		Guest other = (Guest) obj;
		return other.reservationNumber == reservationNumber;
	}
	
}
