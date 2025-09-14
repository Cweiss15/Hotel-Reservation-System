package HotelReservationSystem;

import java.util.Objects;

public class Room {
	private int roomNumber;
	private String roomType;
	private boolean isAvailable;
	private double nightlyRate;

	public Room(int roomNumber, String roomType, boolean isAvailable, double nightlyRate) {
		if (roomNumber < 0) {
			throw new IllegalArgumentException("Please enter a positive value for room number.");
		}
		this.roomNumber = roomNumber;
		if (roomType.trim().isEmpty()) {
			throw new IllegalArgumentException("Please enter the room type.");
		}
		this.roomType = roomType;
		this.isAvailable = isAvailable;
		if (nightlyRate < 0) {
			throw new InvalidRateException();
		}
		this.nightlyRate = nightlyRate;
	}

	public Room(int roomNumber, String roomType, double nightlyRate) {
		this(0, roomType, false, nightlyRate);
	}

	public Room(int roomNumber) {
		this(roomNumber, "Unkown", false, 0);
	}

	public Room(String roomType) {
		this(0, roomType, false, 0);
	}

	public Room(boolean isAvailable) {
		this(0, "Unkown", isAvailable, 0);
	}

	public Room(double nightlyRate) {
		this(0, "Unkown", false, nightlyRate);
	}

	public Room() {
	}
	
	public Room(Room r) {
		this(r.roomNumber, r.roomType, r.isAvailable, r.nightlyRate);
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		if (roomNumber < 0) {
			throw new IllegalArgumentException("Please enter a positive value for room number.");
		}
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
		if (roomType.trim().isEmpty()) {
			throw new IllegalArgumentException("Please enter the room type.");
		}
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getNightlyRate() {
		return nightlyRate;
	}

	public void setNightlyRate(double nightlyRate) {
		this.nightlyRate = nightlyRate;
		if (nightlyRate < 0) {
			throw new InvalidRateException();
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Room number: " + roomNumber + "\nRoom Type: " + roomType + "\nAvailable: " + isAvailable
				+ "\nNightly Rate: " + nightlyRate);
		return str.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return roomNumber == other.roomNumber;
	}
}
