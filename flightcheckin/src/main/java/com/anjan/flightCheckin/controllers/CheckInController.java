package com.anjan.flightCheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anjan.flightCheckin.integration.ReservationRestClient;
import com.anjan.flightCheckin.integration.dto.Reservation;

@Controller
public class CheckInController 
{
	@Autowired
	ReservationRestClient restClient; 
	
	@RequestMapping("/showcheckin")
	public String showStartCheckin() 
	{
		System.out.println("Hello World");
		return "startCheckIn"; 
	}
	
	@RequestMapping("/startcheckin")
	public String startCheckIn(@RequestParam("reservationId") Integer reservationId, ModelMap modelMap) 
	{
		System.out.println("Start Check in is Starting ...");
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation",reservation);
		System.out.println("Start Check in is about to End ...");
		return "displayReservationDetails";
	}
}
