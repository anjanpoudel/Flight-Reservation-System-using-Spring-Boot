package com.anjan.flightreservation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESER_SEQ")
    @SequenceGenerator(sequenceName = "RESERVATION_SEQ", allocationSize = 1, name = "RESER_SEQ")
	private int id;
	
	@Column(name="checked_in")
	private Boolean checkedIn;
	
	@Column(name="number_of_bags")
	private int numberOfBags;
	
	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassanger() {
		return passenger;
	}

	public void setPessanger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
