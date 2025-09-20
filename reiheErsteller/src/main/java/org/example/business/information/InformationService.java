package org.example.business.information;

import org.example.business.LottoService;
import org.example.business.logging.LogService;
import org.example.business.logging.LogServiceInterface;

import java.io.IOException;

/**
 * Handles all informational output that guides the user through the console menus.
 */
public class InformationService implements InformationServiceInterface {

    private final LogServiceInterface logger;

    /**
     * Creates a new service configured for the {@link LottoService} context.
     *
     * @throws IOException when the logger cannot create a file handler
     */
    public InformationService() throws IOException {
        logger = new LogService(LottoService.class);
    }

    @Override
    public void information() {
        logger.info("information() wurde aufgerufen.");
        System.out.println("Hier gibts wichtige Informationen");
        System.out.println();
        System.out.println("Schreib bitte die Zahl der Auswahl wie: '1'");
        System.out.println("oder gib einfache Wörter wie: eurojackpot, abschließen, 6aus49 oder information.");
        System.out.println("1. 6aus49 Reihe: Gib eine Lottoreihe für 6aus49.");
        System.out.println("2. Eurojackpot Reihe: Gib eine Lottoreihe für Eurojackpot mit 5aus50 plus 2aus10.");
        System.out.println("3. Unglückszahlen bearbeiten: Hier kann man bis 6 Unglückszahlen eingeben und speichern.");
        System.out.println("4. Information: Man bekommt wichtige Informationen hier. Du befindest dich gerade in dieser Auswahl.");
        System.out.println("5. Programm abschließen: Hier kann man das Programm abschließen.");
        System.out.println();
    }

    @Override
    public void informationUnglueckszahlen() {
        logger.info("informationUnglueckszahlen() wurde aufgerufen.");
        System.out.println("Hier gibts wichtige Informationen");
        System.out.println();
        System.out.println("Schreib bitte die Zahl der Auswahl wie: '1'");
        System.out.println("oder gib einfache Wörter wie: reihe, löschen, einzeln oder information.");
        System.out.println();
        System.out.println("1. Unglückszahlen eingeben (Reihe): Hier kann man bis 6 Zahlen im folgenden Format eingeben.");
        System.out.println("Format: 1 5 8 9 4 16 oder 1-2-4-5-6-8");
        System.out.println("2. Unglückszahlen löschen: Hier kann man die aktuellen Unglückszahlen löschen.");
        System.out.println("3. Unglückszahlen eingeben (Einzeln): Hier kann man einzelne Unglückszahlen eingeben.");
        System.out.println("4. Information");
        System.out.println("5. Zurück.");
        System.out.println();
    }
}
