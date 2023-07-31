package org.example.dao;

import java.util.*;

public class Eurojackpot extends Tippreihe {
    private HashSet<Integer> zweiAusZehn;
    public Eurojackpot() {
        setTippreihe(new HashSet<Integer>());
        setZweiAusZehn(new HashSet<Integer>());
        setSuperzahl(0);
        setUnglückszahlen(new HashSet<Integer>());
    }
    public Eurojackpot(HashSet<Integer> unglückszahlen, HashSet<Integer> tippreihe, int superzahl, HashSet<Integer> zweiAusZehn) {
        super(unglückszahlen, tippreihe, superzahl, LottoTyp.EUROJACKPOT);
        this.zweiAusZehn = zweiAusZehn;
    }

    public HashSet<Integer> getZweiAusZehn() {
        return zweiAusZehn;
    }

    public void setZweiAusZehn(HashSet<Integer> zweiAusZehn) {
        this.zweiAusZehn = zweiAusZehn;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
