package com.group.interfaces;

import com.group.models.Users;
import org.sql2o.Connection;

public interface IUser {
    boolean createUser(Connection connection, Users user);

    Users loginUser(Connection connection, String email, String password);

    Users getUserById(Connection connection, int id);
}
