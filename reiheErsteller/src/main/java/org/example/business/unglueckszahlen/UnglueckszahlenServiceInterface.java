package org.example.business.unglueckszahlen;

import org.example.exceptions.InvalidInputException;

import java.util.Set;

public interface UnglueckszahlenServiceInterface {
    /**
     * Reads unlucky numbers from the console and stores them.
     */
    void unglueckszahlenErstellen() throws InvalidInputException;

    /**
     * Adds a single unlucky number entered by the user.
     */
    void addUnglueckszahl();

    /**
     * Removes unlucky numbers according to the user's selection.
     */
    void deleteUnglueckszahl();

    /**
     * Removes a single unlucky number.
     */
    void deleteEinzelzahl();

    /**
     * Returns the stored unlucky numbers.
     */
    Set<Integer> getUnglueckszahlen();

    /**
     * Replaces the current unlucky numbers with the provided set.
     */
    void setUnglueckszahlen(Set<Integer> unglueckszahlen);

    /**
     * Starts the interactive unlucky numbers menu.
     */
    void unglueckszahlenBearbeiten() throws InvalidInputException;
}
