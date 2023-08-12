package org.example.business.tippreihe;

import java.util.HashSet;

public interface TippreiheServiceInterface {
    public void lotto6Aus49Erstellen(HashSet<Integer> unglückszahlen);
    public void eurojackpotErstellen(HashSet<Integer> unglückszahlen);
}
