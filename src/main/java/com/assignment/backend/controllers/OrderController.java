package com.assignment.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.dto.request.OrderCreateDto;
import com.assignment.backend.dto.response.OrderResponseDto;
import com.assignment.backend.services.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * get all ordered for user
     * 
     * @param AccId account
     * @return List of account
     */
    @GetMapping("/{accId}")
    public List<OrderResponseDto> getAllOrderByAccId(@PathVariable int accId) {

        return this.orderService.getAllOrderByAccId(accId);
    }

    /**
     * get all ordered for admin role
     * 
     * @return
     */
    @GetMapping("/all")
    public List<OrderResponseDto> getAllOrder() {
        return this.orderService.getAllOrder();
    }

    /**
     * Create new ordered.
     * 
     * @param dto include two field: cart Id and AccId
     * @return Success or Error
     */
    @PostMapping()
    public ResponseEntity<?> createNewOrder(@Valid @RequestBody OrderCreateDto dto) {
        return this.orderService.createNewOrder(dto);
    }

    /**
     * update status of ordered
     * 
     * @param orderId
     * @return Success or Error
     */
    @PatchMapping("/{orderId}/{status}")
    public ResponseEntity<?> updateStatusOrder(@PathVariable int orderId, @PathVariable String status) {
        return this.orderService.updateStatusOrder(orderId, status);
    }

}
