package fichamedicainfantil.exceptions;

/**
 * Created by tano on 10/11/15.
 */
public class InvalidValueException extends DataErrorException {
    public InvalidValueException(String field, String errorMessage) {
        super("El field " + field + " es invalido. " + errorMessage);
    }
}
