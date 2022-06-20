package com.assignment.backend.data.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem implements Serializable{

    @Id
    @Column(name = "cart_id")
    private int cartId;

    @Id
    @Column(name = "pro_id")
    private int proId;

    @Column(name = "quantity")
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    private Product product;
}
