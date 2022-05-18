package com.group.interfaces;

import com.group.models.Auctions;
import org.sql2o.Connection;

import java.util.List;

public interface IAuction {
    boolean createItem(Connection connection, Auctions auctions);

    List<Auctions> getAllItems(Connection connection);

    List<Auctions> getUsersAuctionItems(Connection connection, int id);

    Auctions getItemById(Connection connection, int id);

    boolean deleteAuctionItem(Connection connection, int id);

}
