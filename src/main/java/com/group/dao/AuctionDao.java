package com.group.dao;

import com.group.interfaces.IAuction;
import com.group.models.Auctions;
import org.sql2o.Connection;

import java.util.List;

public class AuctionDao implements IAuction {

    /**
     * @param connection
     * @param auctions
     * @return
     */
    @Override
    public boolean createItem(Connection connection, Auctions auctions) {
        try {
            String query = "INSERT INTO auctions(createdby,itemname,imageurl,baseprice,description)" +
                    " VALUES(:createdBy,:itemName,:imageUrl,:basePrice,:description)";
            return connection.createQuery(query)
                    .bind(auctions)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }

    /**
     * @param connection
     * @return
     */
    @Override
    public List<Auctions> getAllItems(Connection connection) {
        try {
            String query = "SELECT * FROM auctions";
            return connection.createQuery(query)
                    .executeAndFetch(Auctions.class);
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
    public List<Auctions> getUsersAuctionItems(Connection connection, int id) {
        try {
            String query = "SELECT * FROM auctions WHERE createdby = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetch(Auctions.class);
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
    public Auctions getItemById(Connection connection, int id) {
        try {
            String query = "SELECT * FROM auctions WHERE id = :id";
            return connection.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Auctions.class);
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
                    .addParameter("id", id)
                    .executeUpdate()
                    .getResult() > 0;
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }
}
