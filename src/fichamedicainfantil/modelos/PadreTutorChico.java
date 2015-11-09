package fichamedicainfantil.modelos;

import com.j256.ormlite.field.DatabaseField;
import fichamedicainfantil.consts.FichaMedicaConsts;

/**
 * Created by tano on 09/11/15.
 */
public class PadreTutorChico {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, columnName = FichaMedicaConsts.CHICO_ID_FIELD)
    private PadreTutor padreTutor;

    @DatabaseField(foreign = true, columnName = FichaMedicaConsts.PADRE_TUTOR_ID_FIELD)
    private Chico chico;

    PadreTutorChico() {}

    public PadreTutorChico(PadreTutor padreTutor, Chico chico) {
        this.padreTutor = padreTutor;
        this.chico = chico;
    }

}
