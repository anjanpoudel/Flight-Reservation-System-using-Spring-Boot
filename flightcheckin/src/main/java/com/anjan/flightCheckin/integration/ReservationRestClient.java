package com.anjan.flightCheckin.integration;

import com.anjan.flightCheckin.integration.dto.Reservation;
import com.anjan.flightCheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Integer id);
	public Reservation updateReservation(ReservationUpdateRequest request);
}
