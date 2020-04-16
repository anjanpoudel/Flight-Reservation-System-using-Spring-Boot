package com.anjan.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjan.flightreservation.controller.ReservationController;
import com.anjan.flightreservation.dto.ReservationRequest;
import com.anjan.flightreservation.entities.Flight;
import com.anjan.flightreservation.entities.Passenger;
import com.anjan.flightreservation.entities.Reservation;
import com.anjan.flightreservation.repos.FlightRepository;
import com.anjan.flightreservation.repos.PassengerRepository;
import com.anjan.flightreservation.repos.ReservationRepository;

@Service
public class ReservatonServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository; 
	
	
	@Autowired
	PassengerRepository passangerRepo; 
	
	@Autowired
	ReservationRepository reservationRepo; 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservatonServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) 
	{
		LOGGER.info("Inside bookFlight() ");
		Integer flightId = request.getFlightId(); 
		LOGGER.info("Fetching flight for flight id: " + flightId);
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passanger = new Passenger(); 
		passanger.setFirstName(request.getPassangerFirstName());
		passanger.setLastName(request.getPassangerLastName());
		passanger.setPhone(request.getPassangerPhone());
		passanger.setEmail(request.getPassangerEmail());
		LOGGER.info("Saving the passanger: " + passanger);
		Passenger savedPassanger = passangerRepo.save(passanger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPessanger(savedPassanger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the reservation : " + flightId);
		Reservation savedReservation = reservationRepo.save(reservation); 
		return savedReservation;
	}


}
