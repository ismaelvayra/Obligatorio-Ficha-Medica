package Testing.Package;

import fichamedicainfantil.modelos.Consulta;
import fichamedicainfantil.modelos.Chico;
import fichamedicainfantil.modelos.Vacuna;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Calendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;

/**
 * Created by tano on 05/11/15.
 */
public class ConsultaTest {

    private Consulta creaConsulta() {
        Consulta con = new Consulta();
        con.setId(1);
        con.setDescripcion("Esta es una consulta");
        con.setFecha(Calendar.getInstance().getTimeInMillis());
        con.setNotas("Duele mucho.");
        con.setRecordatorio(true);
        con.setTitulo("Vacuna del Dengue.");
        con.setChico(new Chico());
        con.setVacuna(new Vacuna());

        return con;
    }

    @Test
    public void testGetIdCounsulta() throws Exception {
        Consulta con = creaConsulta();

        assertNotNull(con.getId());
        assertEquals(con.getId(), 1);
    }

    @Test
    public void testGetTitulo() throws Exception {
        Consulta con = creaConsulta();

        assertEquals(con.getTitulo(), "Vacuna del Dengue.");
    }

    @Test
    public void testSetTitulo() throws Exception {
        Consulta cons = new Consulta();

        cons.setTitulo("Titulo");

        assertNotNull(cons.getTitulo());
        assertTrue(cons.getTitulo() instanceof String);
        assertEquals(cons.getTitulo(), "Titulo");
    }

    @Test
    public void testGetDescripcion() throws Exception {
        Consulta con = creaConsulta();

        assertEquals(con.getDescripcion(), "Esta es una consulta");
    }

    @Test
    public void testSetDescripcion() throws Exception {
        Consulta con = new Consulta();

        con.setDescripcion("Consulta test");

        assertEquals(con.getDescripcion(), "Consulta test");
    }

    @Test
    public void testGetNotas() throws Exception {
        Consulta consulta = creaConsulta();

        assertEquals(consulta.getNotas(), "Duele mucho.");
    }

    @Test
    public void testSetNotas() throws Exception {
        Consulta con = new Consulta();

        con.setNotas("No duele");

        assertEquals(con.getNotas(), "No duele");
    }

    @Test
    public void testGetFecha() throws Exception {
        Consulta con = creaConsulta();

        assertNotNull(con.getFecha() );
        assertTrue(con.getFecha() instanceof Long);
    }

    @Test
    public void testSetFecha() throws Exception {

        Calendar cal = Calendar.getInstance();
        Consulta con = new Consulta();
        con.setFecha(cal.getTimeInMillis());

        assertNotNull(con.getFecha());
        assertTrue(con.getFecha() instanceof Long);
        assertEquals((long)con.getFecha(), cal.getTimeInMillis());
    }

    @Test
    public void testGetHijo() throws Exception {
        Consulta con = creaConsulta();

        assertNotNull(con.getChico());
        assertTrue(con.getChico() instanceof Chico);
    }

    @Test
    public void testSetHijo() throws Exception {
        Consulta con = new Consulta();

        Chico chico = new Chico();

        chico.setNombre("Goffredo");
        chico.setApellido("Chupete");

        con.setChico(chico);

        assertNotNull(con.getChico());
        assertTrue(con.getChico() instanceof Chico);
        assertEquals(con.getChico(), chico);
    }

    @Test
    public void testGetRecordatorio() throws Exception {
        Consulta con = creaConsulta();

        assertNotNull(con.getRecordatorio());
        assertTrue(con.getRecordatorio());
    }

    @Test
    public void testSetRecordatorio() throws Exception {
        Consulta con = new Consulta();

        con.setRecordatorio(false);
        assertNotNull(con.getRecordatorio());
        assertFalse(con.getRecordatorio());

        con.setRecordatorio(true);
        assertNotNull(con.getRecordatorio());
        assertTrue(con.getRecordatorio());
    }

    @Test
    public void testSetVacuna() throws Exception {
        Consulta con = new Consulta();
        con.setVacuna(null);
        assertNull(con.getVacuna());

        Vacuna vac = new Vacuna();
        vac.setChico(new Chico());
        vac.setFecha(Calendar.getInstance().getTimeInMillis());
        vac.setTitulo("Test Vacuna");
        vac.setNotas("Te testea la vacuna");
        con.setVacuna(vac);
        assertNotNull(con.getVacuna());
        assertTrue(con.getVacuna() instanceof Vacuna);
        assertEquals(con.getVacuna(), vac);

    }

    @Test
    public void testGetVacuna() throws Exception {
        Consulta con = creaConsulta();

        assertNotNull(con.getVacuna());
        assertTrue(con.getVacuna() instanceof Vacuna);

        con = new Consulta();
        assertNull(con.getVacuna());
    }
}