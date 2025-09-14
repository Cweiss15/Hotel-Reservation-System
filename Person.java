//Person class, inherited in guest and employees
package HotelReservationSystem;
import java.time.LocalDate;
public class Person {
	private String firstName;
	private String lastName;
	private Gender gender;
	private Address address;
	private LocalDate birthdate;
	
	//Constructors
	public Person(String firstName, String lastName, Gender gender, Address address, String birthdate) {
		this(firstName, lastName, gender, address, LocalDate.parse(birthdate));
	}
	
	public Person(String firstName, String lastName, Gender gender, String street, String city, String state, String zipcode, String birthdate) {
		this(firstName, lastName, gender, new Address(street, city, state, zipcode), LocalDate.parse(birthdate));
	}
	
	public Person(String firstName, String lastName, Gender gender, Address address, LocalDate birthdate) {
		if (firstName.trim().isEmpty())
			throw new IllegalArgumentException("This field is required.");
		this.firstName = firstName;
		if (lastName.trim().isEmpty())
			throw new IllegalArgumentException("This field is required.");
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		if(birthdate.isAfter(LocalDate.now()))
			throw new InvalidDateException("Please enter a valid birthdate.");
		this.birthdate = birthdate;
	}
	
	//Copy constructor
	public Person(Person p) {
		this(p.firstName, p.lastName, p.gender, p.address, p.birthdate);
	}

	//Setters and getters
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setLastName(String lastName) {
		if (lastName.trim().isEmpty())
			throw new IllegalArgumentException("This field is required.");
		this.lastName = lastName;
	}

	public void setAddress(Address address) {
		
		this.address = address;
	}

	//to string
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Name: " + firstName + " " + lastName + "\nGender: " + gender + "\n" + address + "\nBirhtdate: "  + birthdate);
		return str.toString();
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return(other.firstName.equals(firstName) && other.lastName.equals(lastName) && other.birthdate.equals(birthdate));
	}
	} 


