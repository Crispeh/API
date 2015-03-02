package com.crispeh.apicore.network;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Joey on 3/1/2015.
 */
public final class MySQL {

    private Connection con;

    public MySQL(String ip, String userName, String password, String dbName) {
        try{
            ComboPooledDataSource source = new ComboPooledDataSource();
            source.setDriverClass("com.mysql.jdbc.Driver");
            source.setJdbcUrl("jdbc:mysql://" + ip + "/" + dbName + "?user=" + userName + "&password=" + password);
            source.setUser(userName);
            source.setPassword(password);
            con = source.getConnection();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return con;
    }
    public void closeConnection() {
        if(con != null) {
            try{
                con.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
