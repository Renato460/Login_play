package Model;


import java.util.*;
import javax.persistence.*;
import io.ebean.*;

import play.data.format.*;
import play.data.validation.*;

@Entity
public class UserModel extends Model {

    private String nombre;
    @Id
    private String pass;
    private String apellidos;
    private String mail;
    private String fono;
    private String direccion;

    public UserModel(){}

    public UserModel(String nombre, String apellidos, String mail, String fono, String direccion, String pass){

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.fono = fono;
        this.direccion = direccion;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
