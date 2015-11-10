package Testing.Package;

import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.controladores.OrmHelper;
import fichamedicainfantil.controladores.PersonaParserHelper;
import fichamedicainfantil.exceptions.EmptyFieldException;
import fichamedicainfantil.exceptions.InvalidValueException;
import fichamedicainfantil.modelos.Chico;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tano on 10/11/15.
 */
public class PersonaParserHelperTest {

    public Chico chicoGenerator() {
        Chico chico = new Chico();
        chico.setCedula(41136332);
        chico.setNombre("Goffredo");
        chico.setApellido("Papein");
        chico.setGrupoSanguino("NH21");
        chico.setAnomalias("Vegetaciones");
        chico.setPatologia("Colon irritable");
        chico.setPerimetroEncefalico(20);
        chico.setPeso(4);
        chico.setGenero(FichaMedicaConsts.GeneroEnum.MASCULINO);
        chico.setTalla(60);

        return chico;
    }

    //********************* TESTS POSITIVOS **************************\\

    @Test
    public void testPersonaOk() throws Throwable {
        new PersonaParserHelper(chicoGenerator());
    }

    //********************* TESTS NEGATIVOS **************************\\

    @Test(expected = EmptyFieldException.class)
    public void testDataErroneaCedulaVacia() throws Throwable {
        Chico chico = new Chico();
        new PersonaParserHelper(chico);
    }

    @Test(expected = InvalidValueException.class)
    public void testDataErroneaCedulaInvalidaMenor() throws Throwable {
        Chico chico = new Chico();
        chico.setCedula(3);
        new PersonaParserHelper(chico);
    }

    @Test(expected = InvalidValueException.class)
    public void testDataErroneaCedulaInvalidaMayor() throws Throwable {
        Chico chico = new Chico();
        chico.setCedula(999999999);
        new PersonaParserHelper(chico);
    }

    @Test(expected = InvalidValueException.class)
    public void testDataErroneaNombreInvalido()throws Throwable {
        Chico chico = chicoGenerator();
        chico.setNombre("Ism7el");
        new PersonaParserHelper(chico);
    }

    @Test(expected = InvalidValueException.class)
    public void testDataErroneaApellidoInvalido()throws Throwable {
        Chico chico = chicoGenerator();
        chico.setApellido("V4yra");
        new PersonaParserHelper(chico);
    }

}