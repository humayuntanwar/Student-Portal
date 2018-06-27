/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Kashif
 */
public class Con_db {
     Connection c = null;
    Con_db() {
       try {
           
            String driver = "oracle.jdbc.OracleDriver";
            Class.forName(driver);
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "humayun";
            String pasword = "ciit";
            c = DriverManager.getConnection(url, username, pasword);
            System.out.println("Connected to database");
            
        } catch (SQLException e) {
            System.out.println(" not connected");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        }

    }
    }
    

