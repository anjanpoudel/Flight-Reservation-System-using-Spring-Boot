package com.anjan.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anjan.flightreservation.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);

//	Users findbyEmail(String email);

}
