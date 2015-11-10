/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil.modelos;

import com.j256.ormlite.table.DatabaseTable;
import fichamedicainfantil.controladores.OrmHelper;
import fichamedicainfantil.modelos.clasesAbstractas.Persona;

import java.util.ArrayList;

/**
 * @author tano
 */
@DatabaseTable(tableName = "padres")
public class PadreTutor extends Persona {

    public PadreTutor() {
    }

    public ArrayList<Chico> getListaHijos() {
        try {
            return OrmHelper.getListaHijosPorPadre(this);
        } catch (Exception e) {
            return null;
        }
    }


}
