package ispit;

public class IllegalMusicalAlphabetException extends Exception{

    private static final long serialVersionUID = 1L;

    public IllegalMusicalAlphabetException(String message) {
        super(message);
    }
}