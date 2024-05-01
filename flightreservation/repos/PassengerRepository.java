package com.rahul.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
