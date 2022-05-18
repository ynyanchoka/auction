package com.group.database;

import org.sql2o.Connection;

public class Seeder {
    public static void seed(Connection connection) {
        try {
            String bids = "CREATE TABLE IF NOT EXISTS bids(id SERIAL PRIMARY KEY, " +
                    "auctionitem INTEGER, biddername TEXT, " +
                    "bidamount INTEGER, biddate TIMESTAMP default CURRENT_TIMESTAMP, status BOOLEAN)";

            String users = "CREATE TABLE IF NOT EXISTS users(id SERIAL PRIMARY KEY, " +
                    "email VARCHAR(255), fullname TEXT, password VARCHAR(255))";

            String auction = "CREATE TABLE IF NOT EXISTS auctions(id SERIAL PRIMARY KEY, " +
                    "createdby INTEGER, itemname TEXT, imageurl VARCHAR(255), " +
                    "baseprice INTEGER, description TEXT, " +
                    "createdat TIMESTAMP default CURRENT_TIMESTAMP)";

            connection.createQuery(bids).executeUpdate();
            connection.createQuery(users).executeUpdate();
            connection.createQuery(auction).executeUpdate();

        } catch (Exception exc) {
            throw new RuntimeException("Couldnt create tables", exc);
        }
    }

    public static void drop(Connection connection) {
        try {
            connection.createQuery("DROP TABLE users; " +
                    "DROP TABLE auctions; " +
                    "DROP TABLE bids");
        } catch (Exception exc) {
            throw new RuntimeException("Couldnt Drop the tables", exc);
        }
    }
}
