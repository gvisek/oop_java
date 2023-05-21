package lab3;

public class InvalidPANLengthException extends Exception{
    public InvalidPANLengthException() {
        super();
    }

    public InvalidPANLengthException(String message) {
        super(message);
    }
}
