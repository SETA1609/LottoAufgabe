package org.example.business.tippreihe;

import java.util.Set;

/**
 * Common functionality for generating lottery rows.
 */
public interface TippreiheServiceInterface {

    /**
     * Creates a recommendation for the classic 6aus49 draw.
     *
     * @param unglueckszahlen numbers that should not appear in the recommendation
     */
    void lotto6Aus49Erstellen(Set<Integer> unglueckszahlen);

    /**
     * Creates a recommendation for the Eurojackpot draw.
     *
     * @param unglueckszahlen numbers that should not appear in the recommendation
     */
    void eurojackpotErstellen(Set<Integer> unglueckszahlen);
}
