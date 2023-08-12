package org.example.dao;

import java.util.*;

public class Tippreihe {
    private HashSet<Integer> unglückszahlen;
    private HashSet<Integer> tippreihe;
    private int superzahl;
    private LottoTyp lottoTyp;

    private List<Integer> sortierteReihe;

    public Tippreihe() {
        tippreihe = new HashSet<Integer>();
        setUnglückszahlen(new HashSet<Integer>());
        setSuperzahl((int) (Math.random() * 10));
        setLottoTyp(LottoTyp.LOTTO6AUS49);
        setTippreihe();
        setSortierteReihe();
    }
    public Tippreihe(HashSet<Integer> unglückszahlen) {
        tippreihe = new HashSet<Integer>();
        setUnglückszahlen(unglückszahlen == null ? new HashSet<>() : unglückszahlen);
        setLottoTyp(LottoTyp.LOTTO6AUS49);
        setSuperzahl((int) (Math.random() * 10));
        setTippreihe();
        setSortierteReihe();
    }
    public Tippreihe(HashSet<Integer> unglückszahlen, LottoTyp lottoTyp) {
        tippreihe = new HashSet<Integer>();
        setUnglückszahlen(unglückszahlen == null ? new HashSet<>() : unglückszahlen);
        setLottoTyp(lottoTyp);
        setSuperzahl((int) (Math.random() * 10));
        setTippreihe();
        setSortierteReihe();
    }
    public HashSet<Integer> getUnglückszahlen() {
        return unglückszahlen;
    }
    public void setUnglückszahlen(HashSet<Integer> unglückszahlen) {
        this.unglückszahlen = unglückszahlen;
    }
    public HashSet<Integer> getTippreihe() {
        return tippreihe;
    }
    public void setTippreihe() {
        int obereGrenze = 0;
        switch (lottoTyp) {
            case LOTTO6AUS49 -> obereGrenze = 50;
            case EUROJACKPOT -> obereGrenze = 51;
        }

        int randomInt;
        if (lottoTyp == LottoTyp.EUROJACKPOT) {
            while (tippreihe.size() < 5) {
                randomInt = (int) (Math.random() * obereGrenze);
                if (!tippreihe.contains(randomInt) && !unglückszahlen.contains(randomInt)&&randomInt!=0) {
                    tippreihe.add(randomInt);
                }
            }
        } else {
            while (tippreihe.size() < 6) {
                randomInt = (int) (Math.random() * obereGrenze);
                if (!tippreihe.contains(randomInt) && !unglückszahlen.contains(randomInt)&&randomInt!=0) {
                    tippreihe.add(randomInt);
                }
            }
        }


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

    public List<Integer> getSortierteReihe() {
        return sortierteReihe;
    }

    public void setSortierteReihe() {
        sortierteReihe=new ArrayList<>(tippreihe);
        Collections.sort(sortierteReihe);
    }
}
