package com.anjan.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anjan.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
