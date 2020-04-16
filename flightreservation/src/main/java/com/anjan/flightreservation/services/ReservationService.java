package com.anjan.flightreservation.services;

import com.anjan.flightreservation.dto.ReservationRequest;
import com.anjan.flightreservation.entities.Reservation;

public interface ReservationService 
{
	public Reservation bookFlight(ReservationRequest request);
}
