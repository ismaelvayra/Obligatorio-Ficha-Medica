/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil;

import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.controladores.OrmHelper;

import java.sql.SQLException;

/**
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
        OrmHelper.InitOrmHelper(FichaMedicaConsts.Enviroment.PRODUCCION_ENVIROMENT);
    }

}
