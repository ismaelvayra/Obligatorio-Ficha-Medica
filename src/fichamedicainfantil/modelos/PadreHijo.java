package fichamedicainfantil.modelos;

import com.j256.ormlite.field.DatabaseField;
import fichamedicainfantil.consts.FichaMedicaConsts;

/**
 * Created by tano on 09/11/15.
 */
public class PadreHijo {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, columnName = FichaMedicaConsts.HIJO_ID_FIELD)
    private Padre padre;

    @DatabaseField(foreign = true, columnName = FichaMedicaConsts.PADRE_ID_FIELD)
    private Hijo hijo;

    PadreHijo() {}

    public PadreHijo(Padre padre, Hijo hijo) {
        this.padre = padre;
        this.hijo = hijo;
    }

}
