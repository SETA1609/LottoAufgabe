package org.example.dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the classic 6aus49 lottery tip.
 */
public class Lotto6Aus49 extends Tippreihe {

    /**
     * Creates a standard Lotto 6aus49 tip without unlucky numbers.
     */
    public Lotto6Aus49() {
        super(new HashSet<>(), LottoTyp.LOTTO6AUS49);
    }

    /**
     * Creates a Lotto 6aus49 tip excluding the provided unlucky numbers.
     */
    public Lotto6Aus49(Set<Integer> unglueckszahlen) {
        super(unglueckszahlen, LottoTyp.LOTTO6AUS49);
    }
}
