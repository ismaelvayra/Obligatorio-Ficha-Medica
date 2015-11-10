package fichamedicainfantil.controladores;

import fichamedicainfantil.Utils.Utils;
import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.exceptions.DataErrorException;
import fichamedicainfantil.exceptions.EmptyFieldException;
import fichamedicainfantil.exceptions.InvalidValueException;
import fichamedicainfantil.modelos.clasesAbstractas.Persona;

/**
 * Created by tano on 10/11/15.
 */
public class PersonaParserHelper {

    private Persona persona;

    public PersonaParserHelper(Persona persona) throws DataErrorException{
        this.persona = persona;
        iniciarControl();
    }

    private void iniciarControl() throws DataErrorException{
        controlCedula();
        controlNombre();
        controlApellido();
    }

    private void controlCedula() throws DataErrorException {
        if(persona.getCedula() == 0) {
            throw new EmptyFieldException(FichaMedicaConsts.DATA_CEDULA);
        }

        int numMin = 10000000;
        int numMax = 99999999;
        if(persona.getCedula() < numMin || persona.getCedula() > numMax) {
            throw new InvalidValueException(FichaMedicaConsts.DATA_CEDULA, "El valor de la cedula tiene que ser mayor a " + numMin + " y menor a " + numMax + ".");
        }
    }

    private void controlNombre() throws DataErrorException {
        if (!Utils.tieneSoloLetrasString(persona.getNombre())) {
            throw new InvalidValueException(FichaMedicaConsts.DATA_NOMBRE, "En nombre solo puede contener letras.");
        }
    }

    private void controlApellido() throws DataErrorException {
        if (!Utils.tieneSoloLetrasString(persona.getApellido())) {
            throw new InvalidValueException(FichaMedicaConsts.DATA_APELLIDO, "En apellido solo puede contener letras.");
        }
    }
}
