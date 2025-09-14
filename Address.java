//Address class
package HotelReservationSystem;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public Address (String street, String city, String state, String zipcode){
		
		this.street=street;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZipCode() {
		return zipcode;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder ();
		str.append("Address: " + street + " " + city + ", " + state + " " + zipcode);
		return str.toString();
	}
}
