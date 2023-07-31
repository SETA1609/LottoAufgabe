package org.example.business;

import org.example.dao.Eurojackpot;
import org.example.dao.Lotto6Aus49;

public interface LottoserviceInterface {

    public Lotto6Aus49 lotto6Aus49Erstellen();
    public Eurojackpot eurojackpotErstellen();
    public int[] unglückszahlenErstellen();
    public  int[] addUnglückszahl(int i);
    public int[] deleteUnglückszahl(int i);

}
