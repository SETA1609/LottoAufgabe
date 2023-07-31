package org.example.business;

import org.example.dao.Eurojackpot;
import org.example.dao.Lotto6Aus49;

public class LottoService implements LottoserviceInterface{
    @Override
    public Lotto6Aus49 lotto6Aus49Erstellen() {
        return null;
    }

    @Override
    public Eurojackpot eurojackpotErstellen() {
        return null;
    }

    @Override
    public int[] unglückszahlenErstellen() {
        return new int[0];
    }

    @Override
    public int[] addUnglückszahl(int i) {
        return new int[0];
    }

    @Override
    public int[] deleteUnglückszahl(int i) {
        return new int[0];
    }
}
