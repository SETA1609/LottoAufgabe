package org.example.dao;

import java.util.*;

public class Eurojackpot extends Tippreihe {
    private HashSet<Integer> zweiAusZehn;
    private List<Integer>sortedZweiAusZehn;
    public Eurojackpot() {
        super();
        zweiAusZehn=new HashSet<>();
        setZweiAusZehn();
        setSortedZweiAusZehn();
    }
    public Eurojackpot(HashSet<Integer> unglückszahlen) {
        super(unglückszahlen, LottoTyp.EUROJACKPOT);
        zweiAusZehn=new HashSet<>();
        setZweiAusZehn();
        setSortedZweiAusZehn();
    }

    public HashSet<Integer> getZweiAusZehn() {
        return zweiAusZehn;
    }

    public void setZweiAusZehn() {

        int randomInt;
        while (zweiAusZehn.size()<=1){
            try {
                randomInt = (int) (Math.random() * 11);
                if (!zweiAusZehn.contains(randomInt) && !super.getUnglückszahlen().contains(randomInt) && randomInt != 0) {
                    zweiAusZehn.add(randomInt);
                }
            } catch (Exception e) {
                // logging the exception
            }
        }

    }

    public List<Integer> getSortedZweiAusZehn() {
        return sortedZweiAusZehn;
    }

    public void setSortedZweiAusZehn() {
        sortedZweiAusZehn=new ArrayList<>(zweiAusZehn);
        Collections.sort(sortedZweiAusZehn);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
