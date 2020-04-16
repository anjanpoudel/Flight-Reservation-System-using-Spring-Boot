package com.anjan.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anjan.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
