package org.example.business.logging;

/**
 * Simple abstraction over logging facilities to simplify testing and dependency injection.
 */
public interface LogServiceInterface {

    /**
     * Logs an informational message.
     */
    void info(String message);

    /**
     * Logs an error message.
     */
    void error(String message);
}
