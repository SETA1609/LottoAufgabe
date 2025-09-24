package org.example.business;

import org.example.business.information.InformationService;
import org.example.business.information.InformationServiceInterface;
import org.example.business.logging.LogService;
import org.example.business.logging.LogServiceInterface;
import org.example.business.tippreihe.TippreiheService;
import org.example.business.tippreihe.TippreiheServiceInterface;
import org.example.business.unglueckszahlen.UngluecksZahlenService;
import org.example.business.unglueckszahlen.UnglueckszahlenServiceInterface;
import org.example.exceptions.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

/**
 * Coordinates the interaction between the presentation layer and the domain services.
 */
public class LottoService implements LottoserviceInterface {

    private boolean running;
    private final InformationServiceInterface informationService;
    private final UnglueckszahlenServiceInterface unglueckszahlenService;
    private final TippreiheServiceInterface tippreiheService;
    private final LogServiceInterface logger;

    /**
     * Creates the service with the default implementations.
     *
     * @throws IOException when one of the dependencies cannot be initialised
     */
    public LottoService() throws IOException {
        this(new InformationService(), new UngluecksZahlenService(), new TippreiheService(), new LogService(LottoService.class));
    }

    LottoService(InformationServiceInterface informationService,
                 UnglueckszahlenServiceInterface unglueckszahlenService,
                 TippreiheServiceInterface tippreiheService,
                 LogServiceInterface logger) {
        this.informationService = informationService;
        this.unglueckszahlenService = unglueckszahlenService;
        this.tippreiheService = tippreiheService;
        this.logger = logger;
        this.running = true;
    }

    boolean isRunning() {
        return running;
    }

    void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Ends the console session and prints a farewell message.
     */
    @Override
    public void abschliessen() {
        System.out.println("Danke für die Verwendung von Glücksspiel 3000");
        logger.info("Programm wurde beendet");
        setRunning(false);
    }

    /**
     * Starts the main application loop and evaluates user input.
     *
     * @throws InvalidInputException when the unlucky numbers module raises an input issue
     */
    @Override
    public void starten() throws InvalidInputException {
        logger.info("Programm wurde gestartet");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen in Glücksspiel 3000");

        while (isRunning()) {
            System.out.println("Bitte wählt eine unserer Optionen");
            System.out.println("1. 6aus49 Reihe.");
            System.out.println("2. Eurojackpot Reihe.");
            System.out.println("3. Unglückszahlen bearbeiten.");
            System.out.println("4. Information");
            System.out.println("5. Programm abschließen.");
            System.out.println("Gib bitte deine Auswahl ein:");

            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "1", "6aus49" -> tippreiheService.lotto6Aus49Erstellen(unglueckszahlenService.getUnglueckszahlen());
                case "2", "eurojackpot" -> tippreiheService.eurojackpotErstellen(unglueckszahlenService.getUnglueckszahlen());
                case "3", "unglückszahlen", "unglueckszahlen" -> unglueckszahlenService.unglueckszahlenBearbeiten();
                case "4", "information" -> informationService.information();
                case "5", "abschließen", "abschliessen" -> abschliessen();
                default -> {
                    System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
                    logger.info("Ungültige Auswahl. Bitte versuche es erneut.");
                    informationService.information();
                }
            }
        }
    }
}
