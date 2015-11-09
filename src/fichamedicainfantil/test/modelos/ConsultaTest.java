package fichamedicainfantil.test.modelos;

import fichamedicainfantil.modelos.Consulta;
import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;

/**
 * Created by tano on 05/11/15.
 */
public class ConsultaTest {

    private Consulta creaConsulta() {
        Consulta con = new Consulta();
        con.setIdCounsulta(1);
        con.setDescripcion("Esta es una consulta");
        con.setFecha(Calendar.getInstance().getTimeInMillis());
        con.setNotas("Duele mucho.");
        con.setRecordatorio(true);
        con.setTitulo("Vacuna del Dengue.");

        return con;
    }

    @Test
    public void testGetIdCounsulta() throws Exception {
        Consulta con = creaConsulta();

        Class<?> c = Class.forName("fichamedicainfantil.modelos.Consulta");
        Method m = c.getDeclaredMethod("getIdCounsulta");
        String tipo = m.getReturnType().toString();

        assertNotNull(con.getIdCounsulta());
        assertEquals(tipo, "int");
        assertEquals(con.getIdCounsulta(), 1);
    }

    @Test
    public void testGetTitulo() throws Exception {
        Consulta con = creaConsulta();

        assertTrue(con.getTitulo() instanceof String);
        assertEquals(con.getTitulo(), "Vacuna del Dengue.");
    }

    @Test
    public void testSetTitulo() throws Exception {
        Consulta cons = new Consulta();

        cons.setTitulo("Titulo");

        assertNotNull(cons.getTitulo());
        assertTrue(cons.getTitulo() instanceof String);
        assertEquals(cons.getTitulo(), "Vacuna del Dengue.");
    }

    @Test
    public void testGetDescripcion() throws Exception {
        Consulta con = creaConsulta();

        assertTrue(con.getDescripcion() instanceof String);
        assertEquals(con.getDescripcion(), "Vacuna del Dengue.");
    }

    @Test
    public void testSetDescripcion() throws Exception {

    }

    @Test
    public void testGetNotas() throws Exception {

    }

    @Test
    public void testSetNotas() throws Exception {

    }

    @Test
    public void testGetFecha() throws Exception {

    }

    @Test
    public void testSetFecha() throws Exception {

    }

    @Test
    public void testGetHijo() throws Exception {

    }

    @Test
    public void testSetHijo() throws Exception {

    }

    @Test
    public void testGetRecordatorio() throws Exception {

    }

    @Test
    public void testSetRecordatorio() throws Exception {

    }
}