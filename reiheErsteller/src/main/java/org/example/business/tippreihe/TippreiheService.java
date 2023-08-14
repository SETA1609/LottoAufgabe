package org.example.business.tippreihe;

import org.example.business.LottoService;
import org.example.business.logging.LogService;
import org.example.business.logging.LogServiceInterface;
import org.example.dao.*;

import java.io.IOException;
import java.util.HashSet;

public class TippreiheService implements TippreiheServiceInterface{
    private LogServiceInterface lgr;

    public TippreiheService() throws IOException {
        lgr= new LogService(TippreiheService.class);
    }

    @Override
    public void lotto6Aus49Erstellen(HashSet<Integer> unglückszahlen) {

        Lotto6Aus49 neueReihe6aus49 = new Lotto6Aus49(unglückszahlen);
        System.out.println("Hier ist deine Empfehlung: "+neueReihe6aus49.getSortierteReihe());
    }
    @Override
    public void eurojackpotErstellen(HashSet<Integer> unglückszahlen) {

        Eurojackpot eurojackpot = new Eurojackpot(unglückszahlen);
        System.out.println("Hier ist deine Empfehlung für 5aus50: "+eurojackpot.getSortierteReihe());
        System.out.println("Hier ist deine Empfehlung für 2aus10: "+eurojackpot.getSortedZweiAusZehn());
    }


}
