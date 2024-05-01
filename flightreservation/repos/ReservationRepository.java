package com.rahul.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
