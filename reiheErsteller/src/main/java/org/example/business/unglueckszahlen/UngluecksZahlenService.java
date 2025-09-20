package org.example.business.unglueckszahlen;

import org.example.business.LottoService;
import org.example.business.information.InformationService;
import org.example.business.information.InformationServiceInterface;
import org.example.business.logging.LogService;
import org.example.business.logging.LogServiceInterface;
import org.example.dao.LottoTyp;
import org.example.exceptions.InvalidInputException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Service that encapsulates all interactions around the unlucky numbers feature set.
 */
public class UngluecksZahlenService implements UnglueckszahlenServiceInterface {

    private static final int MAX_UNGLUECKSZAHLEN = 6;

    private final LogServiceInterface logger;
    private final InformationServiceInterface informationService;
    private final Set<Integer> unglueckszahlen;

    /**
     * Creates a new service using the default logging and information services.
     *
     * @throws IOException when the log service cannot be initialised
     */
    public UngluecksZahlenService() throws IOException {
        this(new LogService(LottoService.class), new InformationService());
    }

    UngluecksZahlenService(LogServiceInterface logger, InformationServiceInterface informationService) {
        this.logger = logger;
        this.informationService = informationService;
        this.unglueckszahlen = new HashSet<>();
    }

    /**
     * Returns a defensive copy of the currently stored unlucky numbers.
     */
    @Override
    public Set<Integer> getUnglueckszahlen() {
        return new HashSet<>(unglueckszahlen);
    }

    /**
     * Replaces the stored unlucky numbers with a new set.
     *
     * @param unglueckszahlen the numbers that should be treated as unlucky
     */
    @Override
    public void setUnglueckszahlen(Set<Integer> unglueckszahlen) {
        this.unglueckszahlen.clear();
        if (unglueckszahlen != null) {
            this.unglueckszahlen.addAll(unglueckszahlen);
        }
    }

    /**
     * Reads a space or dash separated list of unlucky numbers from the console and validates the input.
     *
     * @throws InvalidInputException when the lottery type cannot be determined or the format is invalid
     */
    @Override
    public void unglueckszahlenErstellen() throws InvalidInputException {
        logger.info("unglueckszahlenErstellen() wurde aufgerufen");
        Scanner scanner = new Scanner(System.in);
        unglueckszahlen.clear();

        LottoTyp lottoTyp = leseLottoTyp(scanner);
        System.out.println("Gib bitte deine Reihe:");
        String reihe = scanner.nextLine();
        int max = lottoTyp == LottoTyp.LOTTO6AUS49 ? 49 : 50;

        for (String token : splitInput(reihe)) {
            try {
                int value = Integer.parseInt(token);
                if (value > 0 && value <= max) {
                    if (unglueckszahlen.size() < MAX_UNGLUECKSZAHLEN) {
                        unglueckszahlen.add(value);
                    }
                } else {
                    System.out.printf("Diese Zahl: %s ist außerhalb des Lottotyps%n", token);
                }
            } catch (NumberFormatException e) {
                logger.info("Hier wurde ein falsches input eingegeben: " + token);
            }
        }
    }

    private LottoTyp leseLottoTyp(Scanner scanner) throws InvalidInputException {
        System.out.println("Wähl ein Lotto: 6aus49 oder Eurojackpot");
        String input = scanner.nextLine().toLowerCase();
        return switch (input) {
            case "6aus49" -> LottoTyp.LOTTO6AUS49;
            case "eurojackpot" -> LottoTyp.EUROJACKPOT;
            default -> throw new InvalidInputException("Ungültige Auswahl. Bitte versuche es erneut.");
        };
    }

    private String[] splitInput(String input) throws InvalidInputException {
        if (input.contains(" ")) {
            return Arrays.stream(input.split(" "))
                    .filter(token -> !token.isBlank())
                    .toArray(String[]::new);
        }
        if (input.contains("-")) {
            return Arrays.stream(input.split("-"))
                    .filter(token -> !token.isBlank())
                    .toArray(String[]::new);
        }
        throw new InvalidInputException("Ungültiges Eingabeformat. Erwarte Leerzeichen oder Bindestrich.");
    }

    /**
     * Adds a single unlucky number that is read from the console input.
     */
    @Override
    public void addUnglueckszahl() {
        logger.info("addUnglueckszahl() wurde aufgerufen");
        if (unglueckszahlen.size() >= MAX_UNGLUECKSZAHLEN) {
            logger.info("Es sind bereits sechs Unglückszahlen gespeichert");
            System.out.println("Du hast schon 6 Unglückszahlen eingetragen. Bitte lösche eine, um neue einzutragen");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib die Zahl, die hinzugefügt wird");
        String scannerInput = scanner.nextLine();
        try {
            Integer input = Integer.parseInt(scannerInput);
            if (unglueckszahlen.add(input)) {
                return;
            }
            logger.info("Unglückszahl war bereits vorhanden: " + input);
            System.out.println("Du hast eine Unglückszahl eingegeben, die schon gespeichert wurde oder ein falsches input");
        } catch (NumberFormatException e) {
            logger.info("Hier wurde ein falsches input eingegeben: " + scannerInput);
            System.out.println(scannerInput + " ist not a valid input");
        }
    }

    /**
     * Allows the user to remove either all or a single unlucky number.
     */
    @Override
    public void deleteUnglueckszahl() {
        logger.info("deleteUnglueckszahl() wurde aufgerufen");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hier kann man einzelne oder alle Unglückszahlen");
            System.out.println();
            System.out.println("1. Alle Zahlen löschen.");
            System.out.println("2. Nur eine einzelne Zahl löschen.");
            System.out.println("3. Zurück.");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "1", "alle" -> unglueckszahlen.clear();
                case "2", "einzeln" -> deleteEinzelzahl();
                case "3", "zurück", "zurueck" -> {
                    logger.info("zurück in mainUnglueckszahlenMenu");
                    return;
                }
                default -> {
                    logger.info("Ungültige Auswahl. Bitte versuche es erneut.");
                    System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
                }
            }
        }
    }

    /**
     * Removes a single unlucky number provided through console input.
     */
    @Override
    public void deleteEinzelzahl() {
        logger.info("deleteEinzelzahl() wurde aufgerufen");
        System.out.println("Gib bitte eine einzelne Zahl");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            Integer value = Integer.parseInt(input);
            if (!unglueckszahlen.remove(value)) {
                System.out.println("Diese Zahl ist nicht in deinen Unglückszahlen");
                logger.info("Diese Zahl ist nicht in deinen Unglückszahlen: " + value);
            }
        } catch (NumberFormatException e) {
            logger.info("Hier wurde ein falsches input eingegeben: " + input);
            System.out.println(input + " ist not a valid input");
        }
    }

    /**
     * Entry point for the unlucky numbers sub menu.
     */
    @Override
    public void unglueckszahlenBearbeiten() throws InvalidInputException {
        logger.info("unglueckszahlenBearbeiten() wurde aufgerufen");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Du hast Unglückszahlenbearbeitung gewählt");
        while (true) {
            System.out.println("Nimm bitte eine Auswahl");
            System.out.println("1. Unglückszahlen eingeben (Reihe).");
            System.out.println("2. Unglückszahlen löschen");
            System.out.println("3. Unglückszahlen eingeben (Einzeln).");
            System.out.println("4. Information");
            System.out.println("5. Zurück.");
            System.out.println();
            System.out.println("Hier sind deine aktuellen Unglückszahlen: " + unglueckszahlen);
            String input = scanner.nextLine().toLowerCase();
            System.out.println();
            try {
                switch (input) {
                    case "1", "reihe" -> unglueckszahlenErstellen();
                    case "2", "löschen", "loeschen" -> deleteUnglueckszahl();
                    case "3", "einzeln" -> addUnglueckszahl();
                    case "4", "information" -> informationService.informationUnglueckszahlen();
                    case "5", "zurück", "zurueck" -> {
                        logger.info("Zurück zum Hauptmenü");
                        return;
                    }
                    default -> {
                        logger.info("Ungültige Auswahl. Bitte versuche es erneut.");
                        System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
                        informationService.informationUnglueckszahlen();
                    }
                }
            } catch (InvalidInputException e) {
                logger.info("Fehler bei der Eingabe: " + e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
