package com.rahul.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rahul.flightreservation.dto.ReservationRequest;
import com.rahul.flightreservation.entities.Flight;
import com.rahul.flightreservation.entities.Reservation;
import com.rahul.flightreservation.repos.FlightRepository;
import com.rahul.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,
			ModelMap modelMap)
	{
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
		
	}
	
	@PostMapping(value = "/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
//		LOGGER.info("completeReservation()  " + request);

		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());
		return "reservationConfirmation";

	}
	
	
}
