/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil.modelos;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.table.DatabaseTable;
import fichamedicainfantil.controladores.OrmHelper;

import java.util.ArrayList;

/**
 * @author tano
 */
@DatabaseTable(tableName = "hijos")
public class Hijo {

    @DatabaseField(generatedId = true)
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
    @ForeignCollectionField
    private ForeignCollection<Consulta> listaConsultas;
    @ForeignCollectionField
    private ForeignCollection<Vacuna> listaVacunas;
    @DatabaseField(canBeNull = false)
    private long fechaNacimiento;

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

    public ForeignCollection<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public ForeignCollection<Vacuna> getListaVacunas() {
        return listaVacunas;
    }

    public ArrayList<Padre> getListaPadres() {
        try {
            return OrmHelper.getListaPadresPorHijo(this);
        } catch (Exception e) {
            return null;
        }
    }

    public long getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(long fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getNombre().equals(((Hijo)obj).getNombre())&&this.getApellido().equals(((Hijo)obj).getApellido()));
    }
}
