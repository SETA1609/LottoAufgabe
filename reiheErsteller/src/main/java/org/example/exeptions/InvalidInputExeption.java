package org.example.exeptions;

public class InvalidInputExeption extends Exception{

    public InvalidInputExeption() {
    }

    public InvalidInputExeption(String message) {
        super(message);
    }

    public InvalidInputExeption(Throwable cause) {
        super(cause);
    }

    public InvalidInputExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
