package pe.edu.upc.DocSeekerTP.Exceptions;

public class IncompleteDataException extends RuntimeException{

    public IncompleteDataException() { super(); }
    public IncompleteDataException(String message) { super(message); }
}
