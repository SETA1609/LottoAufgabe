package org.example.dao;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EurojackpotTest {

    @Test
    void generatesEuroNumbersWithoutUnluckyNumbers() {
        Eurojackpot eurojackpot = new Eurojackpot(Set.of(1, 2, 3), new Random(11));

        assertEquals(2, eurojackpot.getZweiAusZehn().size());
        assertTrue(eurojackpot.getZweiAusZehn().stream().allMatch(number -> number >= 1 && number <= 10));
        assertTrue(Collections.disjoint(eurojackpot.getZweiAusZehn(), Set.of(1, 2, 3)));
        assertEquals(eurojackpot.getZweiAusZehn().stream().sorted().toList(), eurojackpot.getSortedZweiAusZehn());
        assertEquals(Tippreihe.EUROJACKPOT_ZIEHUNGEN, eurojackpot.getTippreihe().size());
    }
}
