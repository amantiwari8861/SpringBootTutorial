package com.amazon.order.general;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Product {
    //for every product
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long sellerId;
    private String category;
    private String subCategory;
    private String productTitle;
    private double mrp;
    private double price;
    private String brand;
    private String modelName;
    private String productDescription;
    private String shortDescription;
    private int stockQuantity;
    private String recordCreated;

    //for mobile, shoes
    private String colors;

    //for mobile, television
    private String screenSize;

    //for mobile
    private String wirelessCarrier;
    private String operatingSystem;
    private String cellularTechnology;
    private String memoryStorageCapacity;
    private String internalMemory;
    private String frontCamera;
    private String rearCamera;
    private String batteryCapacity;
    private String connectivityTechnology;
    private String wirelessNetworkTechnology;	
    
    //for television
    private String supportedInternetServices;
    private String displayTechnology;
    private String productDimensions;
    private String resolution;
    private String refreshRate;
    private String specialFeature;
    private String includedComponents;

    //for shoes
    private String sizes;
    
}
