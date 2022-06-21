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
import javax.persistence.PrimaryKeyJoinColumn;
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

    @OneToOne(mappedBy = "product")
    @PrimaryKeyJoinColumn
    private ProductDetail productDetail;

    /**
     * default constructor
     */
    public Product() {
    }

    /**
     * @return the proId
     */
    public int getProId() {
        return proId;
    }

    /**
     * @param proId the proId to set
     */
    public void setProId(int proId) {
        this.proId = proId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the numOfProduct
     */
    public int getNumOfProduct() {
        return numOfProduct;
    }

    /**
     * @param numOfProduct the numOfProduct to set
     */
    public void setNumOfProduct(int numOfProduct) {
        this.numOfProduct = numOfProduct;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the cartItem
     */
    public CartItem getCartItem() {
        return cartItem;
    }

    /**
     * @param cartItem the cartItem to set
     */
    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    /**
     * @return the productImages
     */
    public Set<ProductImage> getProductImages() {
        return productImages;
    }

    /**
     * @param productImages the productImages to set
     */
    public void setProductImages(Set<ProductImage> productImages) {
        this.productImages = productImages;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the productRates
     */
    public Set<ProductRate> getProductRates() {
        return productRates;
    }

    /**
     * @param productRates the productRates to set
     */
    public void setProductRates(Set<ProductRate> productRates) {
        this.productRates = productRates;
    }

    /**
     * @return the productDetail
     */
    public ProductDetail getProductDetail() {
        return productDetail;
    }

    /**
     * @param productDetail the productDetail to set
     */
    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    } 
}
