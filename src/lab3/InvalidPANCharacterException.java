package lab3;

public class InvalidPANCharacterException extends Exception{
    public InvalidPANCharacterException() {
        super();
    }

    public InvalidPANCharacterException(String message) {
        super(message);
    }
}
