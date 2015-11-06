package fichamedicainfantil.test.testControladores;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import fichamedicainfantil.consts.FichaMedicaConsts;
import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.*;

/**
 * Created by tano on 05/11/15.
 */
public class OrmHelperTest extends DBTestCase {

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("dataset.xml"));
    }

    @Before
    public void setUp() throws SQLException{
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.hsqldb.jdbcDriver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, FichaMedicaConsts.DATABASE_URL );
    }

    @Test
    public void testInitOrmHelper() throws Exception {
        // Fetch database data after executing your code
//        IDataSet databaseDataSet = getConnection().createDataSet();
//        ITable actualTable = databaseDataSet.getTable("TABLE_NAME");
//
//        // Load expected data from an XML dataset
//        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("expectedDataSet.xml"));
//        ITable expectedTable = expectedDataSet.getTable("TABLE_NAME");
//
//        // Assert actual database table match expected table
//        Assertion.assertEquals(expectedTable, actualTable);
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