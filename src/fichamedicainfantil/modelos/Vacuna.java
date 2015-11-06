/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil.modelos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author tano
 */
@DatabaseTable(tableName = "vacunas")
public class Vacuna {

    @DatabaseField(generatedId = true)
    private int idVacuna;
    @DatabaseField
    private String nombreVacuna;
    @DatabaseField
    private String notasVacuna;
    @DatabaseField
    private Long fechaVacuna;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Hijo hijo;

    public Vacuna() {
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getNotasVacuna() {
        return notasVacuna;
    }

    public void setNotasVacuna(String notasVacuna) {
        this.notasVacuna = notasVacuna;
    }

    public Long getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(Long fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }
}
