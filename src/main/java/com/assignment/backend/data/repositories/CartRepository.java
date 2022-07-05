package com.assignment.backend.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.backend.data.entities.Account;
import com.assignment.backend.data.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
    Cart findByAccountAndActive(Account account, boolean active);
}
