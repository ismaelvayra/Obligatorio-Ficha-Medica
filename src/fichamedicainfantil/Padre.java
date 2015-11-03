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
@DatabaseTable(tableName = "padres")
public class Padre {
    
    @DatabaseField(id = true)
    private int idPadre;
    @DatabaseField
    private String nombre;
    @DatabaseField
    private String apellido;
    @DatabaseField
    private String genero;
    @DatabaseField
    private Hijo hijo;

    public Padre() {}

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }
}
