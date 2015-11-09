package fichamedicainfantil.test.modelos;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.controladores.OrmHelper;
import fichamedicainfantil.modelos.Chico;
import fichamedicainfantil.modelos.PadreTutor;
import fichamedicainfantil.modelos.PadreTutorChico;
import org.h2.table.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tano on 09/11/15.
 */
public class ChicoTest {

    private Chico chicoTest;
    private PadreTutor padreTutor;
    private PadreTutor madreTutor;

    @Before
    public void setUp() throws Exception {
        chicoTest = new Chico();
        chicoTest.setCedula(41136332);
        chicoTest.setNombre("Goffredo");
        chicoTest.setApellido("Papein");
        chicoTest.setGrupoSanguino("NH21");
        chicoTest.setAnomalias("Vegetaciones");
        chicoTest.setPatologia("Colon irritable");
        chicoTest.setPerimetroEncefalico(20);
        chicoTest.setPeso(4);
        chicoTest.setGenero(FichaMedicaConsts.GeneroEnum.MASCULINO);
        chicoTest.setTalla(60);

        OrmHelper.InitOrmHelper(FichaMedicaConsts.Enviroment.TEST_ENVIROMENT);
        OrmHelper.agregarHijo(chicoTest);

        padreTutor = new PadreTutor();
        padreTutor.setCedula(35557662);
        padreTutor.setNombre("PadreGoffredo");
        padreTutor.setApellido("Papein");
        padreTutor.setGenero(FichaMedicaConsts.GeneroEnum.MASCULINO);

        madreTutor = new PadreTutor();
        madreTutor.setCedula(41132446);
        madreTutor.setNombre("MadreGoffredo");
        madreTutor.setApellido("Palindroma");
        madreTutor.setGenero(FichaMedicaConsts.GeneroEnum.FEMENINO);

        OrmHelper.agregarPadre(padreTutor);
        OrmHelper.agregarPadre(madreTutor);
        OrmHelper.agregarRelacionPadreTutorChico(padreTutor, chicoTest);
        OrmHelper.agregarRelacionPadreTutorChico(madreTutor, chicoTest);
    }

    @After
    public void tearDown() throws Exception {
        TableUtils.dropTable(OrmHelper.getConnectionSource(), Chico.class, false);
        TableUtils.dropTable(OrmHelper.getConnectionSource(), PadreTutor.class, false);
        TableUtils.dropTable(OrmHelper.getConnectionSource(), PadreTutorChico.class, false);
        DaoManager.clearDaoCache();
        OrmHelper.getConnectionSource().close();
    }

    @Test
    public void testGetNombre() throws Exception {
        assertNotNull(chicoTest.getNombre());
        assertEquals(chicoTest.getNombre(), "Goffredo");
    }

    @Test
    public void testSetNombre() throws Exception {
        Chico chico = new Chico();
        chico.setNombre("Babun");

        assertNotNull(chico.getNombre());
        assertEquals(chico.getNombre(), "Babun");
    }

    @Test
    public void testGetApellido() throws Exception {
        assertNotNull(chicoTest.getApellido());
        assertEquals(chicoTest.getApellido(), "Papein");
    }

    @Test
    public void testSetApellido() throws Exception {
        Chico chico = new Chico();
        chico.setApellido("Babun");

        assertNotNull(chico.getApellido());
        assertEquals(chico.getApellido(), "Babun");
    }

    @Test
    public void testGetPeso() throws Exception {
        assertTrue(chicoTest.getPeso() > 0);
        assertTrue(chicoTest.getPeso() == 4);
    }

    @Test
    public void testSetPeso() throws Exception {
        Chico chico = new Chico();

        chico.setPeso(5);

        assertTrue(chico.getPeso() == 5);
    }

    @Test
    public void testGetTalla() throws Exception {
        assertTrue(chicoTest.getTalla() == 60);
    }

    @Test
    public void testSetTalla() throws Exception {
        Chico chico = new Chico();

        chico.setTalla(5);

        assertTrue(chico.getTalla() == 5);
    }

    @Test
    public void testGetPerimetroEncefalico() throws Exception {
        assertTrue(chicoTest.getPerimetroEncefalico() == 20);
    }

    @Test
    public void testSetPerimetroEncefalico() throws Exception {
        Chico chico = new Chico();

        chico.setPerimetroEncefalico(20);

        assertTrue(chico.getPerimetroEncefalico() == 20);
    }

    @Test
    public void testGetGrupoSanguino() throws Exception {
        assertEquals(chicoTest.getGrupoSanguino(), "NH21");
    }

    @Test
    public void testSetGrupoSanguino() throws Exception {
        Chico chico = new Chico();

        chico.setGrupoSanguino("NH21");
        assertEquals(chico.getGrupoSanguino(), "NH21");
    }

    @Test
    public void testGetAnomalias() throws Exception {
        assertEquals(chicoTest.getAnomalias(), "Vegetaciones");
    }

    @Test
    public void testSetAnomalias() throws Exception {
        Chico chico = new Chico();

        chico.setAnomalias("Anomialia Test");
        assertEquals(chico.getAnomalias(), "Anomialia Test");
    }

    @Test
    public void testGetPatologia() throws Exception {
        assertEquals(chicoTest.getPatologia(), "Colon irritable");
    }

    @Test
    public void testSetPatologia() throws Exception {
        Chico chico = new Chico();

        chico.setPatologia("Alergia al polen");
        assertEquals(chico.getPatologia(), "Alergia al polen");
    }

    @Test
    public void testGetListaConsultas() throws Exception {

    }

    @Test
    public void testGetListaVacunas() throws Exception {

    }

    @Test
    public void testGetListaPadres() throws Exception {
        assertTrue(chicoTest.getListaPadres().size() == 2);
        assertTrue(chicoTest.getListaPadres().get(0).equals(padreTutor));
        assertEquals(chicoTest.getListaPadres().get(1), madreTutor);
    }
}