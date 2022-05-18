package com.group.dao;

import com.group.interfaces.IBid;
import com.group.models.Bids;
import org.sql2o.Connection;

import java.util.List;

public class BidDao implements IBid {
    /**
     * @param connection
     * @param bid
     * @return
     */
    @Override
    public boolean createBid(Connection connection, Bids bid) {
        try {
            String query = "INSERT INTO bids(auctionitem, userid, biddername, bidamount, status)" +
                    "VALUES(:auctionItem,:userId, :bidderName, :bidAmount, :status)";
            return connection.createQuery(query)
                    .bind(bid)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }

    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public List<Bids> getBidsByAuctionId(Connection connection, int id) {
        try {
            String query = "SELECT * FROM bids WHERE auctionitem = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(Bids.class);
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }

    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public List<Bids> getBidsByUserId(Connection connection, int id) {
        try {
            String query = "SELECT * FROM bids WHERE userid = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(Bids.class);
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }

    /**
     * @param connection
     * @param id
     * @param status
     * @return
     */
    @Override
    public boolean updateBid(Connection connection, int id, boolean status) {
        try {
            String query = "UPDATE bids " +
                    "SET status = :status WHERE id=:id";
            return connection.createQuery(query, true)
                    .addParameter("id", id)
                    .addParameter("status", status)
                    .executeUpdate()
                    .getKey() != null;
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }

    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public boolean deleteBid(Connection connection, int id) {
        try {
            String query = "DELETE FROM bids WHERE id = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }
}
