package com.group.dao;

import com.group.interfaces.IAuction;
import com.group.models.AuctionItem;
import org.sql2o.Connection;

import java.util.List;

public class AuctionDao implements IAuction {

    /**
     * @param connection
     * @param auctionItem
     * @return
     */
    @Override
    public AuctionItem createItem(Connection connection, AuctionItem auctionItem) {
        try {
            String query = "INSERT INTO auctions(createby,itemname,imageurl,baseprice,description)" +
                    " VALUES(:createdBy,:itemName,:imageUrl,:basePrice,:description)";
            return connection.createQuery(query)
                    .bind(auctionItem)
                    .executeAndFetchFirst(AuctionItem.class);
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }

    /**
     * @param connection
     * @return
     */
    @Override
    public List<AuctionItem> getAllItems(Connection connection) {
        try {
            String query = "SELECT * FROM auctions";
            return connection.createQuery(query)
                    .executeAndFetch(AuctionItem.class);
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
    public List<AuctionItem> getUsersAuctionItems(Connection connection, int id) {
        try {
            String query = "SELECT * FROM auctions WHERE createdby = :id";
            return connection.createQuery(query)
                    .executeAndFetch(AuctionItem.class);
        } catch (Exception exc) {
            throw new RuntimeException("Error encountred", exc);
        }
    }

    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public AuctionItem getItemById(Connection connection, int id) {
        try {
            String query = "SELECT * FROM auctions WHERE id = :id";
            return connection.createQuery(query)
                    .executeAndFetchFirst(AuctionItem.class);
        } catch (Exception exc) {
            throw new RuntimeException("Error encountred", exc);
        }
    }

    /**
     * @param connection
     * @param id
     * @return
     */
    @Override
    public boolean deleteAuctionItem(Connection connection, int id) {
        try {
            String query = "DELETE FROM auctions WHERE id = :id";
            return connection.createQuery(query)
                    .addParameter("id",id)
                    .executeUpdate()
                    .getResult()>0;
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered",exc);
        }
    }
}
