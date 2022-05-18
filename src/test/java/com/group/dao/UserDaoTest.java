package com.group.dao;

import com.group.database.Db;
import com.group.database.DbImpl;
import com.group.database.Seeder;
import com.group.interfaces.IUser;
import com.group.models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class UserDaoTest {

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
    void createUser() {
        try {
            IUser userDao = new UserDao();
            Users users = new Users("doe@gmail.com", "John Doe", "1234Test");
            assertTrue(userDao.createUser(conn, users));
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }

    }

    @Test
    void loginUser() {
        try {
            IUser userDao = new UserDao();
            Users users = new Users("doe@gmail.com", "John Doe", "1234Test");
            userDao.createUser(conn, users);
            Users user = userDao.loginUser(conn, "doe@gmail.com", "1234Test");
            assertTrue(user != null);
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }
    }

    @Test
    void getUserById() {
        try {
            IUser userDao = new UserDao();
            Users users = new Users("doe@gmail.com", "John Doe", "1234Test");
            userDao.createUser(conn, users);
            Users user = userDao.getUserById(conn, 1);
            assertTrue(user != null);
        } catch (Exception exc) {
            fail("Test Failed", exc);
        }

    }
}