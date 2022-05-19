package com.group.models;

import java.sql.Timestamp;

public class Bids {
    private int id;

    private int userId;
    private int auctionItem;
    private String bidderName;
    private int bidAmount;
    private Timestamp bidDate;
    private boolean status;

    public Bids(int userId, String bidderName, int auctionItem, int bidAmount, boolean status) {
        this.userId = userId;
        this.bidderName = bidderName;
        this.auctionItem = auctionItem;
        this.bidAmount = bidAmount;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public String getBidderName() {
        return bidderName;
    }

    public int getAuctionItem() {
        return auctionItem;
    }


    public int getBidAmount() {
        return bidAmount;
    }

    public Timestamp getBidDate() {
        return bidDate;
    }

    public boolean isStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}
