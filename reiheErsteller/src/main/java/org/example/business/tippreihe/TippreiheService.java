package org.example.business.tippreihe;

import org.example.business.LottoService;
import org.example.business.logging.LogService;
import org.example.business.logging.LogServiceInterface;
import org.example.dao.Eurojackpot;
import org.example.dao.Lotto6Aus49;

import java.io.IOException;
import java.util.Set;

/**
 * Generates lottery tip rows while logging the performed actions.
 */
public class TippreiheService implements TippreiheServiceInterface {

    private final LogServiceInterface logger;

    public TippreiheService() throws IOException {
        logger = new LogService(LottoService.class);
    }

    /**
     * Generates a recommendation for Lotto 6aus49 and prints it to the console.
     */
    @Override
    public void lotto6Aus49Erstellen(Set<Integer> unglueckszahlen) {
        logger.info("Neue Reihe für Lotto 6aus49 wurde erstellt");
        Lotto6Aus49 neueReihe6aus49 = new Lotto6Aus49(unglueckszahlen);
        System.out.println("Hier ist deine Empfehlung: " + neueReihe6aus49.getSortierteReihe());
    }

    /**
     * Generates a recommendation for Eurojackpot and prints both number ranges to the console.
     */
    @Override
    public void eurojackpotErstellen(Set<Integer> unglueckszahlen) {
        logger.info("Neue Reihe für Lotto Eurojackpot wurde erstellt");
        Eurojackpot eurojackpot = new Eurojackpot(unglueckszahlen);
        System.out.println("Hier ist deine Empfehlung für 5aus50: " + eurojackpot.getSortierteReihe());
        System.out.println("Hier ist deine Empfehlung für 2aus10: " + eurojackpot.getSortedZweiAusZehn());
    }
}
