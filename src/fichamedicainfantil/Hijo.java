/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author tano
 */
@DatabaseTable(tableName = "hijos")
public class Hijo {
    
    @DatabaseField(id = true)
    private int idHijo;
    @DatabaseField
    private String nombreHijo;
    @DatabaseField
    private String apellidoHijo;
    @DatabaseField
    private float peso;
    @DatabaseField
    private int talla;
    @DatabaseField
    private int perimetroEncefalico;
    @DatabaseField
    private String grupoSanguino;
    @DatabaseField
    private String anomalias;
    @DatabaseField
    private String patologia;
    @DatabaseField
    private Padre padre;

    public Hijo() {
    }
    

    public String getNombre() {
        return nombreHijo;
    }

    public void setNombre(String nombre) {
        this.nombreHijo = nombre;
    }

    public String getApellido() {
        return apellidoHijo;
    }

    public void setApellido(String apellido) {
        this.apellidoHijo = apellido;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getPerimetroEncefalico() {
        return perimetroEncefalico;
    }

    public void setPerimetroEncefalico(int perimetroEncefalico) {
        this.perimetroEncefalico = perimetroEncefalico;
    }

    public String getGrupoSanguino() {
        return grupoSanguino;
    }

    public void setGrupoSanguino(String grupoSanguino) {
        this.grupoSanguino = grupoSanguino;
    }

    public String getAnomalias() {
        return anomalias;
    }

    public void setAnomalias(String anomalias) {
        this.anomalias = anomalias;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }
}
