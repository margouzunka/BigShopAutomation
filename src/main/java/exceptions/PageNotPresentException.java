package exceptions;

public class PageNotPresentException extends Exception {
    public PageNotPresentException(String message) {
        super(message);
    }
}
