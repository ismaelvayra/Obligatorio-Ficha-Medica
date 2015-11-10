package fichamedicainfantil.controladores;

import fichamedicainfantil.Utils.Utils;
import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.exceptions.DataErrorException;
import fichamedicainfantil.exceptions.EmptyFieldException;
import fichamedicainfantil.exceptions.InvalidValueException;
import fichamedicainfantil.modelos.Chico;

/**
 * Created by tano on 10/11/15.
 */
public class ChicoParserHelper {

    private Chico chico;

    public ChicoParserHelper(Chico chico) throws DataErrorException{
        this.chico = chico;
        iniciarControl();
    }

    private void iniciarControl() throws DataErrorException{
        controlCedula();
        controlNombre();
        controlApellido();
        controlPeso();
        controlPerimetroEncefalico();
        controlTalla();
        controlGrupoSanquino();
        controlAnomalias();
        controlPatologia();
    }

    private void controlCedula() throws DataErrorException {
        if(chico.getCedula() == 0) {
            throw new EmptyFieldException(FichaMedicaConsts.DATA_CEDULA);
        }

        int numMin = 10000000;
        int numMax = 99999999;
        if(chico.getCedula() < numMin || chico.getCedula() > numMax) {
            throw new InvalidValueException(FichaMedicaConsts.DATA_CEDULA, "El valor de la cedula tiene que ser mayor a " + numMin + " y menor a " + numMax + ".");
        }
    }

    private void controlNombre() throws DataErrorException {
        if (!Utils.tieneSoloLetrasString(chico.getNombre())) {
            throw new InvalidValueException(FichaMedicaConsts.DATA_NOMBRE, "En nombre solo puede contener letras.");
        }
    }

    private void controlApellido() throws DataErrorException {
        if (!Utils.tieneSoloLetrasString(chico.getApellido())) {
            throw new InvalidValueException(FichaMedicaConsts.DATA_APELLIDO, "En apellido solo puede contener letras.");
        }
    }

    private void controlPeso() {

    }

    private void controlPerimetroEncefalico() {

    }

    private void controlTalla() {

    }

    private void controlGrupoSanquino() {

    }

    private void controlAnomalias() {

    }

    private void controlPatologia() {

    }
}
