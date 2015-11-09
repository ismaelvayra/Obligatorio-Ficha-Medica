/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil.modelos;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import fichamedicainfantil.controladores.OrmHelper;

import java.util.ArrayList;

/**
 * @author tano
 */
@DatabaseTable(tableName = "hijos")
public class Chico extends Persona {

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

    public Chico() {
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

    public ArrayList<PadreTutor> getListaPadres() {
        try {
            return OrmHelper.getListaPadresPorHijo(this);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getNombre().equals(((Chico)obj).getNombre())&&this.getApellido().equals(((Chico)obj).getApellido()));
    }
}
