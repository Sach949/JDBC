package com.xworkz.ecommerce.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "product_info")
@Entity
@Data
public class ProductEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "QUANTITY_AVAIL")
    private String qtyAvailable;

}
