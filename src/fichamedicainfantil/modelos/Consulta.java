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
@DatabaseTable(tableName = "consultas")
public class Consulta {

    @DatabaseField(generatedId = true)
    private int idCounsulta;
    @DatabaseField
    private String titulo;
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private String notas;
    @DatabaseField(canBeNull = false)
    private Long fecha;
    @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true, columnName = "chico_id")
    private Chico chico;
    @DatabaseField(canBeNull = false)
    private boolean recordatorio;
    @DatabaseField(foreign = true)
    private Vacuna vacuna;


    public Consulta() {
    }

    public int getIdCounsulta() {
        return idCounsulta;
    }

    public void setIdCounsulta(int idCounsulta) {
        this.idCounsulta = idCounsulta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    public Chico getChico() {
        return chico;
    }

    public void setChico(Chico chico) {
        this.chico = chico;
    }

    public boolean getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(boolean recordatorio) {
        this.recordatorio = recordatorio;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }
}
