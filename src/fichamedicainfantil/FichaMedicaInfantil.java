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
import fichamedicainfantil.controladores.OrmHelper;
import fichamedicainfantil.modelos.Consulta;
import fichamedicainfantil.modelos.Hijo;
import fichamedicainfantil.modelos.Padre;
import fichamedicainfantil.modelos.Vacuna;

import java.sql.SQLException;

/**
 *
 * @author tano
 */
public class FichaMedicaInfantil {


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
        OrmHelper.InitOrmHelper();
    }
    
}
