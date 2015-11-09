package fichamedicainfantil.test.controladores;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.controladores.OrmHelper;
import fichamedicainfantil.modelos.Consulta;
import fichamedicainfantil.modelos.Chico;
import fichamedicainfantil.modelos.PadreTutor;
import fichamedicainfantil.modelos.Vacuna;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by tano on 06/11/15.
 */
public class OrmHelperTest {

    @BeforeClass
    public static void testInitOrmHelper() throws Exception {
        OrmHelper.InitOrmHelper(FichaMedicaConsts.Enviroment.TEST_ENVIROMENT);

        assertNotNull(DaoManager.lookupDao(OrmHelper.getConnectionSource(), Consulta.class));
        assertNotNull(DaoManager.lookupDao(OrmHelper.getConnectionSource(), Chico.class));
        assertNotNull(DaoManager.lookupDao(OrmHelper.getConnectionSource(), PadreTutor.class));
        assertNotNull(DaoManager.lookupDao(OrmHelper.getConnectionSource(), Vacuna.class));
    }

    @AfterClass
    public static void endDbTest() throws IOException {
        try {

            TableUtils.dropTable(OrmHelper.getConnectionSource(), Consulta.class, false);
            TableUtils.dropTable(OrmHelper.getConnectionSource(), Chico.class, false);
            TableUtils.dropTable(OrmHelper.getConnectionSource(), PadreTutor.class, false);
            TableUtils.dropTable(OrmHelper.getConnectionSource(), Vacuna.class, false);

            DaoManager.clearDaoCache();

            assertNull(DaoManager.lookupDao(OrmHelper.getConnectionSource(), Consulta.class));
            assertNull(DaoManager.lookupDao(OrmHelper.getConnectionSource(), Chico.class));
            assertNull(DaoManager.lookupDao(OrmHelper.getConnectionSource(), PadreTutor.class));
            assertNull(DaoManager.lookupDao(OrmHelper.getConnectionSource(), Vacuna.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        OrmHelper.getConnectionSource().close();
        assertFalse(OrmHelper.getConnectionSource().isOpen());
    }

    @Test
    public void testAgregarPadre() throws Exception {

    }

    @Test
    public void testAgregarHijo() throws Exception {

    }

    @Test
    public void testAgregarConsulta() throws Exception {

    }

    @Test
    public void testAgregarVacuna() throws Exception {

    }

    @Test
    public void testGetListaPadres() throws Exception {

    }

    @Test
    public void testGetListaHijos() throws Exception {

    }

    @Test
    public void testGetListaConsultas() throws Exception {

    }

    @Test
    public void testGetListaVacunas() throws Exception {

    }
}