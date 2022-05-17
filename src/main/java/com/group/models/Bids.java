package com.group.models;

import java.sql.Timestamp;

public class Bids {
    private int id;
    private String bidderName;
    private int bidAmount;
    private Timestamp bidDate;
    private boolean status;

    public Bids(String bidderName, int bidAmount, Timestamp bidDate, boolean status) {
        this.bidderName = bidderName;
        this.bidAmount = bidAmount;
        this.bidDate = bidDate;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBidderName() {
        return bidderName;
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
}
