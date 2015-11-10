/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil.modelos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import fichamedicainfantil.modelos.clasesAbstractas.EntidadMedica;

/**
 * @author tano
 */
@DatabaseTable(tableName = "consultas")
public class Consulta extends EntidadMedica{
    @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true, columnName = "chico_id")
    private Chico chico;
    @DatabaseField(canBeNull = false)
    private boolean recordatorio;
    @DatabaseField(foreign = true)
    private Vacuna vacuna;

    public Consulta() {
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
