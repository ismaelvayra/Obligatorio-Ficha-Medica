package fichamedicainfantil.consts;

/**
 * Created by tano on 04/11/15.
 */
public class FichaMedicaConsts {

    public final static String DATABASE_URL = "jdbc:h2:mem:fichamedica";
    public final static String DATABASE_TEST_URL = "jdbc:h2:mem:testfichamedica";

    public enum Enviroment {
        TEST_ENVIROMENT,
        PRODUCCION_ENVIROMENT
    }
    public enum GeneroEnum {
        HOMBRE,
        MUJER
    }

    public final static String HIJO_ID_FIELD = "hijo_id";
    public final static String PADRE_ID_FIELD = "padre_id";

}
