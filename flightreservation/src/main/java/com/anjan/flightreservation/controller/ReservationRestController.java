package com.anjan.flightreservation.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjan.flightreservation.dto.ReservationUpdateRequest;
import com.anjan.flightreservation.entities.Reservation;
import com.anjan.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepo; 
	
	@GetMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Integer id) 
	{
		Reservation reservation = reservationRepo.findById(id).get();
		return reservation == null ? new Reservation() : reservation;
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepo.findById(request.getId()).get(); 
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(true);
		return reservationRepo.save(reservation);
	}
}
