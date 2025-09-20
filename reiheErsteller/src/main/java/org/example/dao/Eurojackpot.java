package org.example.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Represents the Eurojackpot lottery tip which consists of two separate draws.
 */
public class Eurojackpot extends Tippreihe {

    private final Set<Integer> zweiAusZehn;
    private List<Integer> sortedZweiAusZehn;

    /**
     * Creates a Eurojackpot tip without unlucky numbers.
     */
    public Eurojackpot() {
        this(new HashSet<>());
    }

    /**
     * Creates a Eurojackpot tip that excludes the provided unlucky numbers.
     */
    public Eurojackpot(Set<Integer> unglueckszahlen) {
        this(unglueckszahlen, new Random());
    }

    /**
     * Visible for testing to inject a deterministic random number generator.
     */
    Eurojackpot(Set<Integer> unglueckszahlen, Random random) {
        super(random, unglueckszahlen, LottoTyp.EUROJACKPOT);
        zweiAusZehn = new HashSet<>();
        generateZweiAusZehn();
        sortiereZweiAusZehn();
    }

    public Set<Integer> getZweiAusZehn() {
        return Collections.unmodifiableSet(zweiAusZehn);
    }

    public List<Integer> getSortedZweiAusZehn() {
        return Collections.unmodifiableList(sortedZweiAusZehn);
    }

    private void generateZweiAusZehn() {
        while (zweiAusZehn.size() < 2) {
            int randomValue = getRandom().nextInt(10) + 1;
            if (!zweiAusZehn.contains(randomValue) && !getUnglueckszahlen().contains(randomValue)) {
                zweiAusZehn.add(randomValue);
            }
        }
    }

    private void sortiereZweiAusZehn() {
        sortedZweiAusZehn = new ArrayList<>(zweiAusZehn);
        Collections.sort(sortedZweiAusZehn);
    }
}
