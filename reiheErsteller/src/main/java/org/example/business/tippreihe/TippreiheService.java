package org.example.business.tippreihe;

import org.example.business.LottoService;
import org.example.business.logging.LogService;
import org.example.business.logging.LogServiceInterface;
import org.example.dao.*;

import java.io.IOException;
import java.util.HashSet;

public class TippreiheService implements TippreiheServiceInterface {
    private LogServiceInterface lgrTipp;

    public TippreiheService() throws IOException {
        lgrTipp = new LogService(LottoService.class);
    }

    @Override
    public void lotto6Aus49Erstellen(HashSet<Integer> unglückszahlen) {
        lgrTipp.info("neue Reihe für Lotto 6aus49 würde erstellt");
        Lotto6Aus49 neueReihe6aus49 = new Lotto6Aus49(unglückszahlen);
        System.out.println("Hier ist deine Empfehlung: " + neueReihe6aus49.getSortierteReihe());
    }

    @Override
    public void eurojackpotErstellen(HashSet<Integer> unglückszahlen) {
        lgrTipp.info("neue Reihe für Lotto Eurojackpot würde erstellt");
        Eurojackpot eurojackpot = new Eurojackpot(unglückszahlen);
        System.out.println("Hier ist deine Empfehlung für 5aus50: " + eurojackpot.getSortierteReihe());
        System.out.println("Hier ist deine Empfehlung für 2aus10: " + eurojackpot.getSortedZweiAusZehn());
    }


}
