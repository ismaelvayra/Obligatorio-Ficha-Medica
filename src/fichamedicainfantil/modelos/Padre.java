/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichamedicainfantil.modelos;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import fichamedicainfantil.consts.FichaMedicaConsts;
import fichamedicainfantil.controladores.OrmHelper;

import java.util.ArrayList;

/**
 * @author tano
 */
@DatabaseTable(tableName = "padres")
public class Padre extends Persona{

    public Padre() {
    }

    public ArrayList<Hijo> getListaHijos() {
        try {
            return OrmHelper.getListaHijosPorPadre(this);
        } catch (Exception e) {
            return null;
        }
    }
}
