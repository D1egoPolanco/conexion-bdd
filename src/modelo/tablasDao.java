/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import INTERFACES.crud;
import Persona.Persona;
//import com.sun.istack.internal.logging.Logger;
import data.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Diego Polanco
 */
//COMPLETANDOSE AUN 
public class tablasDao implements crud<Persona> {

    private static final String SQL_INSERT = "INSERT INTO tablas(nombre apellido) VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE ";
    private static final String SQL_DELETE = "";
    private static final String READALL="";
    private static final String READ="";

    private static final Conexion con = Conexion.getInstance();
    
    
    @Override

    public boolean create(Persona g) {

        PreparedStatement ps;
        boolean flag = false;
        try {
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, g.getNombre());
            ps.setString(2, g.getApellido());
            ps.setString(3, g.getObjeto4());
            ps.setString(4, g.getTelefono());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            flag = true;
            //Logger.getLogger(tablasDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            con.cerrar();
        }
         return flag;
    }

    @Override
    public Persona read(Object key) {
Persona p = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.getCnx().prepareStatement(READ);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                p = new Persona(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4) );
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(tablasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return p;
    }

    @Override
    public boolean update(Persona g) {
    PreparedStatement ps;
        try {
            System.out.println(g.getNombre());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setString(1, g.getApellido());
            ps.setString(2, g.getNombre());
            ps.setString(3, g.getObjeto4());
                      if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(tablasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           // Logger.getLogger(tablasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrar();
        }
        return false;
    }

    @Override
    public ArrayList<Persona> readAll() {
   ArrayList<Persona> all =new ArrayList<>();
        Statement s;
        ResultSet rs;
        try{
            s=con.getCnx().createStatement();
            rs = s.executeQuery(READALL);
            while(rs.next())
            {
                all.add(new Persona(rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"),rs.getString("telefono")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(tablasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    }


