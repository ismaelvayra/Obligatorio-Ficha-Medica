package fichamedicainfantil.modelos.clasesAbstractas;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by tano on 10/11/15.
 */
public abstract class EntidadMedica {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String titulo;
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private String notas;
    @DatabaseField(canBeNull = false)
    private Long fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((EntidadMedica)obj).getId();
    }
}
