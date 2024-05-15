package org.gestao_reserva.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    //db name 
    private static final String users = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/test";

    private static Connection conn;


    public static Connection getConnection(){

        try{
            if(conn == null){
                conn = DriverManager.getConnection(url, users, password);
                System.out.println("conectado");
            }
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
}
