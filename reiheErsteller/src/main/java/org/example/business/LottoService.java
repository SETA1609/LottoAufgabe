package org.example.business;

import org.example.business.information.*;
import org.example.business.tippreihe.*;
import org.example.business.unglückszahlen.*;
import org.example.exeptions.*;

import java.util.*;

public class LottoService implements LottoserviceInterface {

    private boolean isRunning;
    private final InformationServiceInterface informationCodex;
    private final UnglückszahlenServiceInterface unglückszahlenService;
    private final TippreiheServiceInterface tippreiheService;

    public LottoService() {
        setRunning(true);
        informationCodex = new InformationService();
        unglückszahlenService = new UnglücksZahlenService();
        tippreiheService= new TippreiheService();
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void abschließen() {

        System.out.println("Danke für die Verwendung von Glücksspiel 3000");
        setRunning(false);

    }

    @Override
    public void starten() throws InvalidInputExeption {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen in Glücksspiel 3000");

        while (isRunning) {
            System.out.println("Bitte wählt einer unsere optionen");
            System.out.println("1. 6aus49 Reihe.");
            System.out.println("2. Eurojackpot Reihe.");
            System.out.println("3. Unglückszahlen bearbeiten.");
            System.out.println("4. Information");
            System.out.println("5. Program abschließen.");
            System.out.println("Gib bitte deine Auswahl ein:");

            String input = scanner.nextLine();

            switch (input) {
                case "1", "6aus49" -> tippreiheService.lotto6Aus49Erstellen(unglückszahlenService.getUnglückszahlen());
                case "2", "eurojackpot" -> tippreiheService.eurojackpotErstellen(unglückszahlenService.getUnglückszahlen());
                case "3", "unglückszahlen" -> unglückszahlenService.unglückszahlenBearbeiten();
                case "4", "information"-> informationCodex.information();
                case "5", "abschließen" -> abschließen();
                default -> {
                    System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
                    informationCodex.information();                }
            }
        }

    }

}
