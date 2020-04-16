package com.anjan.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anjan.flightreservation.dto.ReservationRequest;
import com.anjan.flightreservation.entities.Flight;
import com.anjan.flightreservation.entities.Reservation;
import com.anjan.flightreservation.repos.FlightRepository;
import com.anjan.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepo; 
	
	@Autowired
	ReservationService reservationService; 
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Integer flightId, ModelMap modelMap)
	{
		LOGGER.info("Inside show complete Reservation invoked with flight id" + flightId);
		Flight flight = flightRepo.findById(flightId).get();
		modelMap.addAttribute("flight",flight); 
		LOGGER.info("Flight is : " + flight);
		return "completeReservation"; 
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap)
	{
		LOGGER.info("Inside the completeReservation method " + request);

		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg","Reservtion created Successfully and id is " + reservation.getId()); 
		return "reservationConformation"; 
	}
}
