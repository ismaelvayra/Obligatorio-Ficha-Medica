package fichamedicainfantil.controladores;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.exceptions.DataErrorException;
import fichamedicainfantil.modelos.*;
import fichamedicainfantil.modelos.clasesJoin.PadreTutorChico;

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
    private static Dao<Chico, Integer> chicoDao;
    private static Dao<PadreTutor, Integer> padreTutorDao;
    private static Dao<PadreTutorChico, Integer> padreTutorChicoDao;

    public static void InitOrmHelper(FichaMedicaConsts.Enviroment enviroment) throws SQLException {

        if (enviroment.equals(FichaMedicaConsts.Enviroment.PRODUCCION_ENVIROMENT)) {
            connectionSource = new JdbcConnectionSource(FichaMedicaConsts.DATABASE_URL);
        } else {
            connectionSource = new JdbcConnectionSource(FichaMedicaConsts.DATABASE_TEST_URL);
        }

        consultaDao = DaoManager.createDao(connectionSource, Consulta.class);
        vacunaDao = DaoManager.createDao(connectionSource, Vacuna.class);
        padreTutorDao = DaoManager.createDao(connectionSource, PadreTutor.class);
        chicoDao = DaoManager.createDao(connectionSource, Chico.class);
        padreTutorChicoDao = DaoManager.createDao(connectionSource, PadreTutorChico.class);

        TableUtils.createTableIfNotExists(connectionSource, Consulta.class);
        TableUtils.createTableIfNotExists(connectionSource, Vacuna.class);
        TableUtils.createTableIfNotExists(connectionSource, PadreTutor.class);
        TableUtils.createTableIfNotExists(connectionSource, Chico.class);
        TableUtils.createTableIfNotExists(connectionSource, PadreTutorChico.class);

    }

    public static void agregarPadreTutorChico(PadreTutor padreTutor, Chico chico) throws SQLException, DataErrorException {

        new PersonaParserHelper(chico);

        if (padreTutorDao.queryForId(padreTutor.getCedula()) == null) {
            padreTutorDao.create(padreTutor);
        }

        if (chicoDao.queryForId(chico.getCedula()) == null) {
            chicoDao.create(chico);
        }

        OrmHelper.agregarRelacionPadreTutorChico(padreTutor, chico);

    }

    public static void agregarConsulta(Consulta consulta) throws SQLException {
        consultaDao.create(consulta);
    }

    public static void agregarVacuna(Vacuna vacuna) throws SQLException {
        vacunaDao.create(vacuna);
    }

    public static ArrayList<PadreTutor> getListaPadres() throws SQLException {
        return (ArrayList<PadreTutor>) padreTutorDao.queryForAll();
    }

    public static ArrayList<Chico> getListaHijos() throws SQLException {
        return (ArrayList<Chico>) chicoDao.queryForAll();
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

    public static Dao<Chico, Integer> getChicoDao() {
        return chicoDao;
    }

    public static Dao<PadreTutor, Integer> getPadreTutorDao() {
        return padreTutorDao;
    }

    public static ArrayList<PadreTutor> getListaPadresPorHijo(Chico chico) throws SQLException {
        PreparedQuery<PadreTutor> prepQuery = queryPadrePorHijo();

        prepQuery.setArgumentHolderValue(0, chico);
        return (ArrayList<PadreTutor>) padreTutorDao.query(prepQuery);
    }

    public static ArrayList<Chico> getListaHijosPorPadre(PadreTutor padreTutor) throws SQLException {
        PreparedQuery<Chico> prepQuery = queryHijoPorPadre();

        prepQuery.setArgumentHolderValue(0, padreTutor);
        return (ArrayList<Chico>) chicoDao.query(prepQuery);
    }

    public static PreparedQuery<Chico> queryHijoPorPadre() throws SQLException {
        QueryBuilder<PadreTutorChico, Integer> padreHijoQ = padreTutorChicoDao.queryBuilder();

        padreHijoQ.selectColumns(FichaMedicaConsts.PADRE_TUTOR_ID_FIELD);
        SelectArg padreSelectArg = new SelectArg();

        padreHijoQ.where().eq(FichaMedicaConsts.CHICO_ID_FIELD, padreSelectArg);

        QueryBuilder<Chico, Integer> hijoQ = chicoDao.queryBuilder();

        hijoQ.where().in("cedula", padreHijoQ);

        return hijoQ.prepare();
    }

    public static PreparedQuery<PadreTutor> queryPadrePorHijo() throws SQLException {
        QueryBuilder<PadreTutorChico, Integer> padreHijoQ = padreTutorChicoDao.queryBuilder();

        padreHijoQ.selectColumns(FichaMedicaConsts.CHICO_ID_FIELD);
        SelectArg hijoSelectArg = new SelectArg();

        padreHijoQ.where().eq(FichaMedicaConsts.PADRE_TUTOR_ID_FIELD, hijoSelectArg);

        QueryBuilder<PadreTutor, Integer> padreQ = padreTutorDao.queryBuilder();

        padreQ.where().in("cedula", padreHijoQ);

        return padreQ.prepare();
    }

    private static void agregarRelacionPadreTutorChico(PadreTutor padreTutor, Chico chico) throws SQLException {
        PadreTutorChico padreTutorChico = new PadreTutorChico(padreTutor, chico);
        padreTutorChicoDao.create(padreTutorChico);
    }
}
