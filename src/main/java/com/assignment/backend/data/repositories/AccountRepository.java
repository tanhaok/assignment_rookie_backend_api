package com.assignment.backend.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.backend.data.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    /**
     * find user have username
     * 
     * @param username username to compare
     * @return Optional<Account>
     */
    Optional<Account> findByUsername(String username);

    /**
     * Check existing of username
     * 
     * @param username username to check
     * @return true: if exist else false
     */
    Boolean existsByUsername(String username);
}
