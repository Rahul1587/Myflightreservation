package com.rahul.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.flightreservation.dto.ReservationRequest;
import com.rahul.flightreservation.entities.Flight;
import com.rahul.flightreservation.entities.Passenger;
import com.rahul.flightreservation.entities.Reservation;
import com.rahul.flightreservation.repos.FlightRepository;
import com.rahul.flightreservation.repos.PassengerRepository;
import com.rahul.flightreservation.repos.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// TODO Auto-generated method stub
		
		Flight flight = flightRepository.findById(request.getFlightId()).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);	
		
		return savedReservation;
	}



}
