package fichamedicainfantil.Utils;

import java.util.regex.Pattern;

/**
 * Created by tano on 10/11/15.
 */
public class Utils {

    public static boolean tieneSoloLetrasString(String texto) {
        return !tieneNumerosString(texto);
    }

    public static boolean tieneNumerosString(String texto) {
        return Pattern.matches(".*\\d+.*", texto);
    }

}
