package Excepciones;

public class DatoInvalidoException extends RuntimeException {
    public DatoInvalidoException(String message) {

        super(message);
    }
}