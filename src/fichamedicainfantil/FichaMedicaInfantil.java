/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

/**
 *
 * @author tano
 */
public class FichaMedicaInfantil {
    
    private final static String DATABASE_URL = "jdbc:h2:mem:fichamedica";
    
    private Dao<Consulta, Integer> consultaDao;
    private Dao<Vacuna, Integer> vacunaDao;
    private Dao<Hijo, Integer> hijoDao;
    private Dao<Padre, Integer> padreDao;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        try {
            new FichaMedicaInfantil().iniciar();
        } catch (Exception e) {
            System.out.println("Error al inicializar la aplicacion");
        }
    }
    
    private void iniciar() throws SQLException {
        ConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);
    }
    
    private void setupDatabase(ConnectionSource connectionSource) throws Exception {

            consultaDao = DaoManager.createDao(connectionSource, Consulta.class);
            vacunaDao = DaoManager.createDao(connectionSource, Vacuna.class);
            padreDao = DaoManager.createDao(connectionSource, Padre.class);
            hijoDao = DaoManager.createDao(connectionSource, Hijo.class);

            // if you need to create the table
            TableUtils.createTable(connectionSource, Consulta.class);
            TableUtils.createTable(connectionSource, Vacuna.class);
            TableUtils.createTable(connectionSource, Padre.class);
            TableUtils.createTable(connectionSource, Hijo.class);
    }
    
}
