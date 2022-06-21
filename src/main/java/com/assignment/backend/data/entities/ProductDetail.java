package com.assignment.backend.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @Column(name = "pro_id")
    private int proId;

    @Column(name = "num_of")
    private int numOfPage;

    @Column(name = "published")
    private int published;

    @Column(name = "cover_type")
    private String coverType;

    @Column(name = "publish_com")
    private String publishCom;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pro_id")
    private Product product;

    /**
     * default constructor
     */
    public ProductDetail() {
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
     * @return the numOfPage
     */
    public int getNumOfPage() {
        return numOfPage;
    }

    /**
     * @param numOfPage the numOfPage to set
     */
    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }

    /**
     * @return the published
     */
    public int getPublished() {
        return published;
    }

    /**
     * @param published the published to set
     */
    public void setPublished(int published) {
        this.published = published;
    }

    /**
     * @return the coverType
     */
    public String getCoverType() {
        return coverType;
    }

    /**
     * @param coverType the coverType to set
     */
    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    /**
     * @return the publishCom
     */
    public String getPublishCom() {
        return publishCom;
    }

    /**
     * @param publishCom the publishCom to set
     */
    public void setPublishCom(String publishCom) {
        this.publishCom = publishCom;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
