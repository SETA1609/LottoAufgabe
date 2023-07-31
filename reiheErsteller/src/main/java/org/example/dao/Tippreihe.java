package org.example.dao;

import java.util.*;

public class Tippreihe {
    private HashSet<Integer> unglückszahlen;
    private HashSet<Integer> tippreihe;
    private int superzahl;
    private LottoTyp lottoTyp;

    public Tippreihe() {
        setUnglückszahlen(new HashSet<Integer>());
        setTippreihe(new HashSet<Integer>());
        setSuperzahl(0);
        setLottoTyp(LottoTyp.LOTTO6AUS49);
    }

    public Tippreihe(HashSet<Integer> unglückszahlen, HashSet<Integer> tippreihe, int superzahl, LottoTyp lottoTyp) {
        this.unglückszahlen = unglückszahlen;
        this.tippreihe = tippreihe;
        this.superzahl = superzahl;
        this.lottoTyp = lottoTyp;
    }

    public  HashSet<Integer> getUnglückszahlen() {
        return unglückszahlen;
    }

    public void setUnglückszahlen(HashSet<Integer> unglückszahlen) {
        this.unglückszahlen = unglückszahlen;
    }

    public HashSet<Integer> getTippreihe() {
        return tippreihe;
    }

    public void setTippreihe(HashSet<Integer> tippreihe) {
        this.tippreihe = tippreihe;
    }

    public int getSuperzahl() {
        return superzahl;
    }

    public void setSuperzahl(int superzahl) {
        this.superzahl = superzahl;
    }

    public LottoTyp getLottoTyp() {
        return lottoTyp;
    }

    public void setLottoTyp(LottoTyp lottoTyp) {
        this.lottoTyp = lottoTyp;
    }
}
