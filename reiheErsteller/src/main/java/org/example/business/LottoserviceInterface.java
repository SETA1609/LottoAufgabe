package org.example.business;

import org.example.exceptions.InvalidInputException;

/**
 * Defines the console based flow of the lottery application.
 */
public interface LottoserviceInterface {

    /**
     * Stops the interactive session.
     */
    void abschliessen();

    /**
     * Starts the interactive session.
     *
     * @throws InvalidInputException when user input cannot be processed
     */
    void starten() throws InvalidInputException;
}
