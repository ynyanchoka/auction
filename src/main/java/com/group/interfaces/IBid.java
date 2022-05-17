package com.group.interfaces;

import com.group.models.Bids;
import org.sql2o.Connection;

import java.util.List;

public interface IBid {
    Bids createBid(Connection connection, Bids bid);

    List<Bids> getBidsByAuctionId(Connection connection, int id);

    List<Bids> getBidsByUserId(Connection connection, int id);

    boolean updateBid(Connection connection, Bids bid);

    boolean deleteBid(Connection connection, int id);
}
