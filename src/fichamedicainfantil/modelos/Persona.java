package fichamedicainfantil.modelos;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import fichamedicainfantil.consts.FichaMedicaConsts;

/**
 * Created by tano on 09/11/15.
 */
public abstract class Persona {

    @DatabaseField(id = true)
    private int cedula;
    @DatabaseField
    private String nombre;
    @DatabaseField
    private String apellido;
    @DatabaseField(dataType = DataType.ENUM_STRING)
    private FichaMedicaConsts.GeneroEnum genero;
    @DatabaseField(canBeNull = false)
    private long fechaNacimiento;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public FichaMedicaConsts.GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(FichaMedicaConsts.GeneroEnum genero) {
        this.genero = genero;
    }

    public long getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(long fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getCedula() == ((Persona)obj).getCedula();
    }
}
