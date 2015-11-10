/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil.modelos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import fichamedicainfantil.modelos.clasesAbstractas.EntidadMedica;

import java.util.Calendar;

/**
 * @author tano
 */
@DatabaseTable(tableName = "vacunas")
public class Vacuna extends EntidadMedica {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Chico chico;
    @DatabaseField
    private int diasLuegoDeNacimiento;

    public Vacuna() {
    }

    public Chico getChico() {
        return chico;
    }

    public void setChico(Chico chico) {
        this.chico = chico;
    }

    public int getDiasLuegoDeNacimiento() {
        return diasLuegoDeNacimiento;
    }

    public void setDiasLuegoDeNacimiento(int diasLuegoDeNacimiento) {
        this.diasLuegoDeNacimiento = diasLuegoDeNacimiento;
        Long fechaNacimiento = this.getChico().getFechaNacimiento();

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(fechaNacimiento);
        c.add(Calendar.DATE, this.diasLuegoDeNacimiento);
        setFecha(c.getTimeInMillis());
    }
}
