package org.example.business;

import org.example.business.information.InformationService;
import org.example.business.information.InformationServiceInterface;
import org.example.business.unglückszahlen.UnglücksZahlenService;
import org.example.business.unglückszahlen.UnglückszahlenServiceInterface;
import org.example.dao.*;
import org.example.exeptions.*;

import java.util.*;

public class LottoService implements LottoserviceInterface {

    private boolean isRunning;
    private Eurojackpot eurojackpot;
    private Lotto6Aus49 lotto6Aus49;
    private HashSet<Integer> unglückszahlen;
    private final InformationServiceInterface informationCodex;
    private UnglückszahlenServiceInterface unglückszahlenService;

    public LottoService() {
        setRunning(true);
        unglückszahlen = new HashSet<>();
        informationCodex = new InformationService();
        unglückszahlenService = new UnglücksZahlenService();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Eurojackpot getEurojackpot() {
        return eurojackpot;
    }

    public void setEurojackpot(Eurojackpot eurojackpot) {
        this.eurojackpot = eurojackpot;
    }

    public Lotto6Aus49 getLotto6Aus49() {
        return lotto6Aus49;
    }

    public void setLotto6Aus49(Lotto6Aus49 lotto6Aus49) {
        this.lotto6Aus49 = lotto6Aus49;
    }

    @Override
    public void lotto6Aus49Erstellen() {
         ;
    }

    @Override
    public void eurojackpotErstellen() {
         ;
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
                case "1", "6aus49" -> lotto6Aus49Erstellen();
                case "2", "eurojackpot" -> eurojackpotErstellen();
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
