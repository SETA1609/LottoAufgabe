package org.example.dao;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TippreiheTest {

    @Test
    void generatesLottoNumbersWithoutUnluckyNumbers() {
        Tippreihe tippreihe = new Tippreihe(new Random(42), Set.of(1, 2, 3), LottoTyp.LOTTO6AUS49);

        assertEquals(Tippreihe.LOTTO6AUS49_ZIEHUNGEN, tippreihe.getTippreihe().size());
        assertTrue(tippreihe.getTippreihe().stream().allMatch(number -> number >= 1 && number <= Tippreihe.LOTTO_RANGE));
        assertFalse(tippreihe.getTippreihe().stream().anyMatch(Set.of(1, 2, 3)::contains));
        assertEquals(sortedCopy(tippreihe.getSortierteReihe()), tippreihe.getSortierteReihe());
        assertTrue(tippreihe.getSuperzahl() >= 0 && tippreihe.getSuperzahl() < Tippreihe.SUPERZAHL_RANGE);
    }

    @Test
    void generatesEurojackpotNumbers() {
        Tippreihe tippreihe = new Tippreihe(new Random(7), Set.of(4, 5), LottoTyp.EUROJACKPOT);

        assertEquals(Tippreihe.EUROJACKPOT_ZIEHUNGEN, tippreihe.getTippreihe().size());
        assertTrue(tippreihe.getTippreihe().stream().allMatch(number -> number >= 1 && number <= Tippreihe.EUROJACKPOT_RANGE));
        assertFalse(tippreihe.getTippreihe().stream().anyMatch(Set.of(4, 5)::contains));
    }

    private List<Integer> sortedCopy(List<Integer> original) {
        List<Integer> copy = new ArrayList<>(original);
        Collections.sort(copy);
        return copy;
    }
}
