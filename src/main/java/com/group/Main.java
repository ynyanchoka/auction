package com.group;

import com.group.database.Db;
import com.group.database.DbImpl;
import com.group.database.Seeder;
import com.group.utils.Router;
import org.sql2o.Connection;

public class Main {
    public static void main(String[] args) {
        Db db = new DbImpl();
        Connection conn = db.connect();
        Seeder.seed(conn);
        Router.run(conn);
    }

}