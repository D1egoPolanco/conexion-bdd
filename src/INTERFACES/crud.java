/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFACES;

import java.util.ArrayList;

/**
 *
 * @author Diego Polanco
 */
public interface crud <Generica> {
    
    boolean create(Generica g);
    Generica read(Object key);
    boolean update(Generica g);
    boolean delete(Object key);
    ArrayList<Generica> readAll();
    
}
