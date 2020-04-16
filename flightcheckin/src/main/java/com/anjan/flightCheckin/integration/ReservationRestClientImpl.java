package com.anjan.flightCheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.anjan.flightCheckin.integration.dto.Reservation;
import com.anjan.flightCheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URI = "http://localhost:8081/reservations/";

	@Override
	public Reservation findReservation(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URI + id,
				Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate template = new RestTemplate();
		Reservation reservation = template.postForObject(RESERVATION_REST_URI, request, Reservation.class);
		return reservation;
	}

}
