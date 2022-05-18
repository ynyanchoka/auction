package com.group.database;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DbImpl extends Db{
    /**
     * @return 
     */
    @Override
    public Connection connect() {
       try{
           String connectionString = "jdbc:postgresql://localhost:5432/auction";
           return new Sql2o(connectionString, null, null).open();
       }catch (Exception exc){
           throw new RuntimeException("Something happened", exc);
       }
    }

    /**
     * @param connection 
     */
    @Override
    public void disconnect(Connection connection) {
        try{
            connection.close();
        }catch (Exception exc){
            throw new RuntimeException("Cannot close", exc);
        }
    }
}
