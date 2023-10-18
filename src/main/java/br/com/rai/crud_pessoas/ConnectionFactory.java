/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.rai.crud_pessoas;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String host = "";
    private static final String port = "";
    private static final String user = "";
    private static final String password = "";
    private static final String db = "";
    
    public static Connection conectar() throws Exception{
//        String conection = "jdbc:mysql://" + host + ":" + port + "/" + db;
        String connection = String.format(
            "jdbc:mysql://%s:%s/%s", host, port, db
        );
        
        Connection c = DriverManager.getConnection(connection, user, password);
        return c;
    }
    
}
