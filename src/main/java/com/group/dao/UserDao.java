package com.group.dao;

import com.group.interfaces.IUser;
import com.group.models.Users;
import org.sql2o.Connection;

public class UserDao implements IUser {
    /**
     * @param connection
     * @param user
     * @return
     */
    @Override
    public Users createUser(Connection connection, Users user) {
        try {
            String query = "INSERT INTO users(email, fullname, password)" +
                    "VALUES(:email, :fullName, :password)";
            return connection.createQuery(query)
                    .bind(user)
                    .executeAndFetchFirst(Users.class);
        } catch (Exception exc) {
            throw new RuntimeException("Error Encountered", exc);
        }
    }

    /**
     * @param connection
     * @param email
     * @param password
     * @return
     */
    @Override
    public Users loginUser(Connection connection, String email, String password) {
        try {
            String query = "SELECT * FROM users " +
                    "WHERE email=:email " +
                    "AND password=:password";
            return connection.createQuery(query)
                    .addParameter("email", email)
                    .addParameter("password", password)
                    .executeAndFetchFirst(Users.class);
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
    public Users getUserById(Connection connection, int id) {
        try {
            String query = "SELECT * FROM users WHERE id=:id";
            return connection.createQuery(query).addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        } catch (Exception exc) {
            throw new RuntimeException("Error encountered", exc);
        }
    }
}
