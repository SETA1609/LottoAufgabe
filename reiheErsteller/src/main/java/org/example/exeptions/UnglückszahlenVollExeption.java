package org.example.exeptions;

public class UnglückszahlenVollExeption extends Exception {

    public UnglückszahlenVollExeption() {
    }

    public UnglückszahlenVollExeption(String message) {
        super(message);
    }

    public UnglückszahlenVollExeption(Throwable cause) {
        super(cause);
    }

    public UnglückszahlenVollExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
