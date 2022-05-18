package com.group.dao;

import com.group.database.Db;
import com.group.database.DbImpl;
import com.group.database.Seeder;
import com.group.interfaces.IBid;
import com.group.models.Bids;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BidDaoTest {

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
    void createBid() {
        try {
            IBid bidDao = new BidDao();
            Bids bids = new Bids(1, "John Doe", 1, 100, false);
            assertTrue(bidDao.createBid(conn, bids));
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void getBidsByAuctionId() {
        try {
            IBid bidDao = new BidDao();
            bidDao.createBid(conn, new Bids(1, "John Doe", 1, 100, false));
            bidDao.createBid(conn, new Bids(1, "John Doe", 1, 100, false));

            List<Bids> bids = bidDao.getBidsByAuctionId(conn, 1);
            assertTrue(bids.size() > 0);
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void getBidsByUserId() {
        try {
            IBid bidDao = new BidDao();
            bidDao.createBid(conn, new Bids(1, "John Doe", 1, 100, false));
            bidDao.createBid(conn, new Bids(1, "John Doe", 1, 100, false));

            List<Bids> bids = bidDao.getBidsByUserId(conn, 1);
            assertTrue(bids.size() > 0);
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void updateBid() {
        try {
            IBid bidDao = new BidDao();
            bidDao.createBid(conn, new Bids(1, "John Doe", 1, 100, false));
            assertTrue(bidDao.updateBid(conn, 1, true));
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void deleteBid() {
        try {
            IBid bidDao = new BidDao();
            bidDao.createBid(conn, new Bids(1, "John Doe", 1, 100, false));
            assertTrue(bidDao.deleteBid(conn, 1));
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }
}