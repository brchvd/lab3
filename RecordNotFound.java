package Exceptions;

public class RecordNotFound extends RuntimeException {
    public RecordNotFound(String exc){
        super(exc);
    }
}
