package org.example.business;

import org.example.dao.Eurojackpot;
import org.example.dao.Lotto6Aus49;
import org.example.dao.LottoTyp;
import org.example.dao.Tippreihe;
import org.example.exeptions.InvalidInputExeption;

import java.util.HashSet;

public interface LottoserviceInterface {
    public void lotto6Aus49Erstellen();
    public void eurojackpotErstellen();
    public void unglückszahlenBearbeiten();
    public HashSet<Integer> unglückszahlenErstellen(LottoTyp lottoTyp, String input) throws InvalidInputExeption;
    public  HashSet<Integer> addUnglückszahl(int i, HashSet<Integer> unglückszahlen);
    public HashSet<Integer> deleteUnglückszahl(int i, HashSet<Integer> unglückszahlen);
    public void information();
    public void abschließen();
    public void starten();

}
