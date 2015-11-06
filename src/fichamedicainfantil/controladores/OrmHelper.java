package fichamedicainfantil.controladores;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.modelos.Consulta;
import fichamedicainfantil.modelos.Hijo;
import fichamedicainfantil.modelos.Padre;
import fichamedicainfantil.modelos.Vacuna;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tano on 04/11/15.
 */
public class OrmHelper {

    private static ConnectionSource connectionSource;

    private static Dao<Consulta, Integer> consultaDao;
    private static Dao<Vacuna, Integer> vacunaDao;
    private static Dao<Hijo, Integer> hijoDao;
    private static Dao<Padre, Integer> padreDao;

    public static void InitOrmHelper(FichaMedicaConsts.Enviroment enviroment) throws SQLException {

        if (enviroment.equals(FichaMedicaConsts.Enviroment.PRODUCCION_ENVIROMENT)) {
            connectionSource = new JdbcConnectionSource(FichaMedicaConsts.DATABASE_URL);
        } else {
            connectionSource = new JdbcConnectionSource(FichaMedicaConsts.DATABASE_TEST_URL);
        }

        consultaDao = DaoManager.createDao(connectionSource, Consulta.class);
        vacunaDao = DaoManager.createDao(connectionSource, Vacuna.class);
        padreDao = DaoManager.createDao(connectionSource, Padre.class);
        hijoDao = DaoManager.createDao(connectionSource, Hijo.class);

        TableUtils.createTableIfNotExists(connectionSource, Consulta.class);
        TableUtils.createTableIfNotExists(connectionSource, Vacuna.class);
        TableUtils.createTableIfNotExists(connectionSource, Padre.class);
        TableUtils.createTableIfNotExists(connectionSource, Hijo.class);

    }

    public static void agregarPadre(Padre padre) throws SQLException {
        padreDao.create(padre);
    }

    public static void agregarHijo(Hijo hijo) throws SQLException {
        hijoDao.create(hijo);
    }

    public static void agregarConsulta(Consulta consulta) throws SQLException {
        consultaDao.create(consulta);
    }

    public static void agregarVacuna(Vacuna vacuna) throws SQLException {
        vacunaDao.create(vacuna);
    }

    public static ArrayList<Padre> getListaPadres() throws SQLException {
        return (ArrayList<Padre>) padreDao.queryForAll();
    }

    public static ArrayList<Hijo> getListaHijos() throws SQLException {
        return (ArrayList<Hijo>) hijoDao.queryForAll();
    }

    public static ArrayList<Consulta> getListaConsultas(HashMap<String, Object> args) throws SQLException {
        if (args != null) {
            return (ArrayList<Consulta>) consultaDao.queryForFieldValues(args);
        }
        return (ArrayList<Consulta>) consultaDao.queryForAll();
    }

    public static ArrayList<Vacuna> getListaVacunas(HashMap<String, Object> args) throws SQLException {
        if (args != null) {
            return (ArrayList<Vacuna>) vacunaDao.queryForFieldValues(args);
        }
        return (ArrayList<Vacuna>) vacunaDao.queryForAll();
    }

    public static ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public static Dao<Consulta, Integer> getConsultaDao() {
        return consultaDao;
    }

    public static Dao<Vacuna, Integer> getVacunaDao() {
        return vacunaDao;
    }

    public static Dao<Hijo, Integer> getHijoDao() {
        return hijoDao;
    }

    public static Dao<Padre, Integer> getPadreDao() {
        return padreDao;
    }
}
