/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Polanco
 */
public class Conexion {
    private String user, pass, url, driver;
    public static Conexion conn;
    private Connection cnx;
    
    public static Conexion getInstance()
    {
        if(conn == null)
        {
            conn = new Conexion();
        }
        return conn;
    }
    
    
    private  Conexion()
    {
        Cargar();
        try {
            Class.forName(this.driver);
            cnx = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Cargar()
    {
        this.user = "root";
        this.pass="";
        this.url="jdbc:mysql://localhost:3306/prueba1?zeroDateTimeBehavior=convertToNull";
        this.driver="com.mysql.jdbc.Driver";
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public void cerrar()
    {
        conn = null;
    }
}
