package org.example.dao;

import java.util.HashSet;

public class Lotto6Aus49 extends Tippreihe{
    public Lotto6Aus49() {
    }

    public Lotto6Aus49(HashSet<Integer> unglückszahlen, HashSet<Integer> tippreihe, int superzahl) {
        super(unglückszahlen, tippreihe, superzahl, LottoTyp.LOTTO6AUS49);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
