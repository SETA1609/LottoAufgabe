package org.example.business.information;

/**
 * Abstraction for user-facing information screens that can be displayed in the console.
 */
public interface InformationServiceInterface {

    /**
     * Displays the main information text.
     */
    void information();

    /**
     * Displays instructions for the unlucky numbers module.
     */
    void informationUnglueckszahlen();
}
