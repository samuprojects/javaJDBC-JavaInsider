package jdbc.dao.core;

@SuppressWarnings("ALL")
public class DAOException extends RuntimeException { // herdar de RuntimeException a torna em uma Unchecked Exception


    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
