package com.group.models;

import java.sql.Timestamp;

public class Auctions {

    private int id;
    private int createdBy;
    private String itemName;
    private String imageUrl;
    private int basePrice;
    private String description;
    private Timestamp createdAt;

    public Auctions(int createdBy, String itemName, String imageUrl,
                    int basePrice, String description
                      ) {
        this.createdBy = createdBy;
        this.itemName = itemName;
        this.imageUrl = imageUrl;
        this.basePrice = basePrice;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public String getItemName() {
        return itemName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
