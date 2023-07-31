package org.example.dao;

import java.util.*;

public class Tippreihe {
    private int[] unglückszahlen;
    private int[] tippreihe;
    private int superzahl;

    public Tippreihe() {
        setUnglückszahlen(new int[6]);
        setTippreihe(new int[0]);
        setSuperzahl(0);
    }

    public Tippreihe(int[] unglückszahlen, int[] tippreihe, int superzahl) {
        this.unglückszahlen = unglückszahlen;
        this.tippreihe = tippreihe;
        this.superzahl = superzahl;
    }

    public int[] getUnglückszahlen() {
        return unglückszahlen;
    }

    public void setUnglückszahlen(int[] unglückszahlen) {
        this.unglückszahlen = unglückszahlen;
    }

    public int[] getTippreihe() {
        return tippreihe;
    }

    public void setTippreihe(int[] tippreihe) {
        this.tippreihe = tippreihe;
    }

    public int getSuperzahl() {
        return superzahl;
    }

    public void setSuperzahl(int superzahl) {
        this.superzahl = superzahl;
    }
}
