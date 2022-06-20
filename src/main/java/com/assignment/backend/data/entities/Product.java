package com.assignment.backend.data.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private int proId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private String status;

    @Column(name = "num_of_product")
    private int numOfProduct;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
    private CartItem cartItem;

    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages;

    @OneToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<ProductRate> productRates;
}
