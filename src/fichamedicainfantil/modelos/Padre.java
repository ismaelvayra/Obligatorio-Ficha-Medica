/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil.modelos;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import fichamedicainfantil.consts.FichaMedicaConsts;

/**
 *
 * @author tano
 */
@DatabaseTable(tableName = "padres")
public class Padre {
    
    @DatabaseField(generatedId = true)
    private int idPadre;
    @DatabaseField
    private String nombrePadre;
    @DatabaseField
    private String apellidoPadre;
    @DatabaseField(dataType = DataType.ENUM_STRING)
    private FichaMedicaConsts.GeneroEnum generoPadre;
    @DatabaseField(foreign = true)
    private Hijo hijo;

    public Padre() {}

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public String getNombre() {
        return nombrePadre;
    }

    public void setNombre(String nombre) {
        this.nombrePadre = nombre;
    }

    public String getApellido() {
        return apellidoPadre;
    }

    public void setApellido(String apellido) {
        this.apellidoPadre = apellido;
    }

    public FichaMedicaConsts.GeneroEnum getGenero() {
        return generoPadre;
    }

    public void setGenero(FichaMedicaConsts.GeneroEnum genero) {
        this.generoPadre = genero;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }
}
