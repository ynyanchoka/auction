package com.group.dao;

import com.group.database.Db;
import com.group.database.DbImpl;
import com.group.database.Seeder;
import com.group.interfaces.IAuction;
import com.group.models.Auctions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuctionDaoTest {

    private Connection conn;
    private Db db;

    @BeforeEach
    void setUp() {
        db = new DbImpl();
        conn = db.connect();
        Seeder.seed(conn);
    }

    @AfterEach
    void tearDown() {
        Seeder.drop(conn);
    }

    @Test
    void createItem() {
        try {
            IAuction auctionDao = new AuctionDao();
            Auctions auctions = new Auctions(1, "Test Item",
                    "https://something", 100, "Test Description");
            assertTrue(auctionDao.createItem(conn, auctions));
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void getAllItems() {
        try {
            IAuction auctionDao = new AuctionDao();
            auctionDao.createItem(conn, new Auctions(1, "Test Item",
                    "https://something", 100, "Test Description"));
            auctionDao.createItem(conn, new Auctions(1, "Test Item",
                    "https://something", 100, "Test Description"));

            List<Auctions> auctions = auctionDao.getAllItems(conn);
            assertTrue(auctions.size() > 0);
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void getUsersAuctionItems() {
        try {
            IAuction auctionDao = new AuctionDao();
            auctionDao.createItem(conn, new Auctions(1, "Test Item",
                    "https://something", 100, "Test Description"));
            auctionDao.createItem(conn, new Auctions(2, "Test Item",
                    "https://something", 100, "Test Description"));

            List<Auctions> auctions = auctionDao.getUsersAuctionItems(conn, 1);
            assertEquals(1, auctions.size());
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void getItemById() {
        try {
            IAuction auctionDao = new AuctionDao();
            auctionDao.createItem(conn, new Auctions(1, "Test Item",
                    "https://something", 100, "Test Description"));

            Auctions auctions = auctionDao.getItemById(conn, 1);
            assertEquals("Test Item", auctions.getItemName());
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void deleteAuctionItem() {
        try {
            IAuction auctionDao = new AuctionDao();
            auctionDao.createItem(conn, new Auctions(1, "Test Item",
                    "https://something", 100, "Test Description"));
            assertTrue(auctionDao.deleteAuctionItem(conn, 1));
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }
}