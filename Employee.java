//Employee class inherits person
package HotelReservationSystem;

import java.time.LocalDate;

public class Employee extends Person {
	public String employeeID;
	public String role;
	public String department;
	
	//Constructors
	public Employee (String f, String l, Gender g, Address
			addr, String birthdate, String employeeID,
			String role, String department) {
		super(f, l, g, addr, birthdate);
		this.employeeID = employeeID;
		this.role = role;
		this.department = department;
	}
	
	public Employee(Person p, String employeeID,
			String role, String department) {
		this(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), p.getBirthdate().toString(), employeeID, role, department);
	}
	
	//Copy constructor
	public Employee (Employee e) {
		this(e.getFirstName(), e.getLastName(), e.getGender(), e.getAddress(), 
				e.getBirthdate().toString(), e.employeeID, 
				e.role, e.department);
	}

	//Setters and getters
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}

	public String getRole() {
		return role;
	}

	public String getDepartment() {
		return department;
	}

	//to string
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nEmplyee ID: " + employeeID + "\nJob title: " + role + "\nDepartment: " + department);
		return str.toString();
	}
	
	// equals
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Employee other = (Employee) obj;
		return employeeID.equals(other.employeeID);
	}
}
