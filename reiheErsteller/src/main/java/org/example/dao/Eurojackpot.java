package org.example.dao;

import java.util.*;

public class Eurojackpot extends Tippreihe {
    private int[] zweiAusZehn;
    public Eurojackpot() {
        setTippreihe(new int[5]);
        setZweiAusZehn(new int[2]);
        setSuperzahl(0);
        setUnglückszahlen(new int[6]);
    }
    public Eurojackpot(int[] unglückszahlen, int[] tippreihe, int superzahl, int[] zweiAusZehn) {
        super(unglückszahlen, tippreihe, superzahl);
        this.zweiAusZehn = zweiAusZehn;
    }
    public int[] getZweiAusZehn() {
        return zweiAusZehn;
    }
    public void setZweiAusZehn(int[] zweiAusZehn) {
        this.zweiAusZehn = zweiAusZehn;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
