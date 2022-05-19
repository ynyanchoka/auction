package com.group.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DbImplTest {

    private  Db db;
    private Connection conn;
    @BeforeEach
    void setUp() {
        db = new DbImpl();
        conn = db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect(conn);
    }

    @Test
    void connect() {
        try{
            assertDoesNotThrow(()->{
                db.connect();
            });
        }catch (Exception exc){
            fail("Test Failed", exc);
        }
    }

    @Test
    void disconnect() {
        try{
            assertDoesNotThrow(()->{
                db.disconnect(conn);
            });
        }catch (Exception exception){
            fail("Test Failed", exception);
        }
    }
}