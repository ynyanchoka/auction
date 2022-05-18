package com.group.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;

class SeederTest {

    private Connection conn;

    @BeforeEach
    void setUp() {
        Db db = new DbImpl();
        conn = db.connect();
    }

    @AfterEach
    void tearDown() {
        Seeder.drop(conn);
    }

    @Test
    void seed() {
        try{
            assertDoesNotThrow(()->{
                Seeder.seed(conn);
            });
        }catch (Exception exc){
            fail("Test Failed", exc);
        }
    }
}