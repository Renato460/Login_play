package Model;


import java.util.*;
import javax.persistence.*;
import io.ebean.*;

import play.data.format.*;
import play.data.validation.*;


@Entity
public class Aranceles extends Model {

    private String tipoInstitucion;
    private String nombreInst;
    private String nombreSede;
    private String nombreCarrera;
    private String jornada;
    private Integer version;
    private Integer arancelAnual;
    private Integer arancelRef;

    public Aranceles(){}

    public Aranceles(String tipoInstitucion, String nombreInst, String nombreSede, String nombreCarrera, String jornada,
                     Integer version, Integer arancelAnual, Integer arancelRef){
        this.tipoInstitucion=tipoInstitucion;
        this.nombreInst=nombreInst;
        this.nombreSede=nombreSede;
        this.nombreCarrera=nombreCarrera;
        this.jornada=jornada;
        this.version=version;
        this.arancelAnual=arancelAnual;
        this.arancelRef=arancelRef;
    }

    public static Finder<String,Aranceles> find = new Finder<>(Aranceles.class);

    public static List<Aranceles> matchAll (){
        List<Aranceles> aranceles = Aranceles.find.all();
        return aranceles;
    }


    public String getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(String tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public String getNombreInst() {
        return nombreInst;
    }

    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getArancelAnual() {
        return arancelAnual;
    }

    public void setArancelAnual(Integer arancelAnual) {
        this.arancelAnual = arancelAnual;
    }

    public Integer getArancelRef() {
        return arancelRef;
    }

    public void setArancelRef(Integer arancelRef) {
        this.arancelRef = arancelRef;
    }
}
