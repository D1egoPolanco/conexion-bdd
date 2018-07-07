package Persona;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Persona {
    
    public SimpleStringProperty nombre = new SimpleStringProperty();
    public SimpleStringProperty apellido = new SimpleStringProperty();
    public SimpleIntegerProperty edad = new SimpleIntegerProperty();
    public SimpleStringProperty telefono = new SimpleStringProperty();
    public SimpleStringProperty objeto4 = new SimpleStringProperty();
    public SimpleStringProperty id = new SimpleStringProperty();

    public Persona (){}
    public Persona(String id,String nombre, String apellido, String telefono ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getNombre(){
        return nombre.get();
    }
    
    public String getApellido(){
        return apellido.get();
    }
    
    public Integer getEdad (){
        return edad.get();
    }
    
    public String getTelefono(){
        return telefono.get();
    }

    public String getObjeto4() {
        return objeto4.get();
    }

    public String getId() {
        return id.get();
    }
    
}