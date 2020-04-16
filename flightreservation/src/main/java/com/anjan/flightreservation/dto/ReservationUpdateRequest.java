package com.anjan.flightreservation.dto;

public class ReservationUpdateRequest {
	private int id;
	private boolean checkedIn;
	private int numberOfBags;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCheckIn() {
		return checkedIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkedIn = checkIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
}
