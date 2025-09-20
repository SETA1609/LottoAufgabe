package org.example.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Represents a lottery tip row that respects a configurable set of unlucky numbers.
 */
public class Tippreihe {

    static final int LOTTO6AUS49_ZIEHUNGEN = 6;
    static final int EUROJACKPOT_ZIEHUNGEN = 5;
    static final int SUPERZAHL_RANGE = 10;
    static final int EUROJACKPOT_RANGE = 50;
    static final int LOTTO_RANGE = 49;

    private final Set<Integer> unglueckszahlen;
    private final Set<Integer> tippreihe;
    private final LottoTyp lottoTyp;
    private final Random random;
    private final int superzahl;
    private List<Integer> sortierteReihe;

    /**
     * Creates a tip row for 6aus49 without unlucky numbers.
     */
    public Tippreihe() {
        this(new Random(), new HashSet<>(), LottoTyp.LOTTO6AUS49);
    }

    /**
     * Creates a tip row for 6aus49 excluding the provided unlucky numbers.
     */
    public Tippreihe(Set<Integer> unglueckszahlen) {
        this(new Random(), unglueckszahlen, LottoTyp.LOTTO6AUS49);
    }

    /**
     * Creates a tip row for the given lottery type.
     */
    public Tippreihe(Set<Integer> unglueckszahlen, LottoTyp lottoTyp) {
        this(new Random(), unglueckszahlen, lottoTyp);
    }

    /**
     * Visible for testing to inject a deterministic random number generator.
     */
    Tippreihe(Random random, Set<Integer> unglueckszahlen, LottoTyp lottoTyp) {
        this.random = Objects.requireNonNull(random, "random must not be null");
        this.unglueckszahlen = new HashSet<>(Objects.requireNonNullElseGet(unglueckszahlen, HashSet::new));
        this.lottoTyp = Objects.requireNonNull(lottoTyp, "lottoTyp must not be null");
        this.tippreihe = new HashSet<>();
        this.superzahl = this.random.nextInt(SUPERZAHL_RANGE);
        generateTippreihe();
        sortiereReihe();
    }

    public Set<Integer> getUnglueckszahlen() {
        return Collections.unmodifiableSet(unglueckszahlen);
    }

    public Set<Integer> getTippreihe() {
        return Collections.unmodifiableSet(tippreihe);
    }

    public int getSuperzahl() {
        return superzahl;
    }

    public LottoTyp getLottoTyp() {
        return lottoTyp;
    }

    public List<Integer> getSortierteReihe() {
        return Collections.unmodifiableList(sortierteReihe);
    }

    protected Random getRandom() {
        return random;
    }

    private void generateTippreihe() {
        int numbersToDraw = lottoTyp == LottoTyp.EUROJACKPOT ? EUROJACKPOT_ZIEHUNGEN : LOTTO6AUS49_ZIEHUNGEN;
        int range = lottoTyp == LottoTyp.EUROJACKPOT ? EUROJACKPOT_RANGE : LOTTO_RANGE;
        while (tippreihe.size() < numbersToDraw) {
            int randomValue = random.nextInt(range) + 1;
            if (!tippreihe.contains(randomValue) && !unglueckszahlen.contains(randomValue)) {
                tippreihe.add(randomValue);
            }
        }
    }

    private void sortiereReihe() {
        sortierteReihe = new ArrayList<>(tippreihe);
        Collections.sort(sortierteReihe);
    }
}
