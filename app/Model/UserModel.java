package Model;


import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.validation.*;

@Entity
public class UserModel extends Model {
    @Constraints.Required
    private String nombre;
    @Id
    private String pass;
    @Constraints.Required
    private String apellidos;
    @Constraints.Required
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

    public static Finder<String,UserModel> find = new Finder<>(UserModel.class);

    public static UserModel match (String pass, String name){
        List<UserModel> users = UserModel.find.all();
        for (UserModel user : users) {
            if (pass.equals(user.getPass()) && name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }


    public String getName() {
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
