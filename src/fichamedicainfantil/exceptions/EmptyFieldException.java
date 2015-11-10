package fichamedicainfantil.exceptions;

/**
 * Created by tano on 10/11/15.
 */
public class EmptyFieldException extends DataErrorException {
    public EmptyFieldException(String field) {
        super("El field " + field + " esta vacio.");
    }
}
