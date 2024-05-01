package com.rahul.flightreservation.services;

import com.rahul.flightreservation.dto.ReservationRequest;
import com.rahul.flightreservation.entities.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);
}
