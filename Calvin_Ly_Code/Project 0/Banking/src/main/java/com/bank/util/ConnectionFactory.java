package com.bank.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    /*we use this class to generate our connections
     *to our DB. it leverages
     * the app.properties file for its credentials
     */
    private static ConnectionFactory cf = null;
    private static Boolean build = true;
    //singleton design pattern because only want one connection object
    private ConnectionFactory(){
        build = false;
    }
    public static synchronized ConnectionFactory getInstance(){
        if(build) cf = new ConnectionFactory();
        return cf;
    }

    //need a conn object to make connection:
    public Connection getConnection(){
        Connection conn = null;
        Properties prop = new Properties();
        String path = "C:/Users/Calvin/IdeaProjects/Banking/src/main/resources/application.properties";
        try {
            prop.load(new FileReader(path));//load in the properties file
            Class.forName(prop.getProperty("driver"));//prop.getProperty("driver") is returning "oracle.jdbc.driver.OracleDriver"
            //giving conn the credentials to connect
            conn = DriverManager.getConnection(
                    prop.getProperty("url"),
                    prop.getProperty("user"),
                    prop.getProperty("password"));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

