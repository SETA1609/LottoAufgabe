package org.example.dao;

import java.util.*;

public class Eurojackpot extends Tippreihe {
    private HashSet<Integer> zweiAusZehn;
    public Eurojackpot() {
        super();
        setZweiAusZehn();
    }
    public Eurojackpot(HashSet<Integer> unglückszahlen) {
        super(unglückszahlen, LottoTyp.EUROJACKPOT);

    }

    public HashSet<Integer> getZweiAusZehn() {
        return zweiAusZehn;
    }

    public void setZweiAusZehn() {

        int randomInt;
        while (zweiAusZehn.size()<=2){
            randomInt= (int) (Math.random()*11);
            if (!zweiAusZehn.contains(randomInt) && !super.getUnglückszahlen().contains(randomInt)){
                zweiAusZehn.add(randomInt);
            }
        }

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
