package com.assignment.backend.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.backend.data.entities.Role;
import com.assignment.backend.data.entities.TypeRole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(TypeRole role);
}