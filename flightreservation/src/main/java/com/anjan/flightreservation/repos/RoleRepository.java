package com.anjan.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anjan.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
