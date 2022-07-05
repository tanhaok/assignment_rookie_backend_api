package com.assignment.backend.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.backend.data.entities.Account;
import com.assignment.backend.data.entities.Ordered;

@Repository
public interface OrderRepository extends JpaRepository<Ordered, Integer> {
    List<Ordered> findByAccount(Account acc);
}
