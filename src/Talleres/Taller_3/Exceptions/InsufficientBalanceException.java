package Talleres.Taller_3.Exceptions;

public class InsufficientBalanceException extends InsufficientException {
    public InsufficientBalanceException() {
        super();
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
