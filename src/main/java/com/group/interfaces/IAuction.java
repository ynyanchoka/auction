package com.group.interfaces;

import com.group.models.AuctionItem;
import org.sql2o.Connection;

import java.util.List;

public interface IAuction {
    AuctionItem createItem(Connection connection, AuctionItem auctionItem);

    List<AuctionItem> getAllItems(Connection connection);

    List<AuctionItem> getUsersAuctionItems(Connection connection, int id);

    AuctionItem getItemById(Connection connection, int id);

    boolean deleteAuctionItem(Connection connection, int id);

}
