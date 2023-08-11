package org.example.business;

import org.example.dao.*;
import org.example.exeptions.*;

import java.util.*;

public class LottoService implements LottoserviceInterface {


    private boolean isRunning;
    private Eurojackpot eurojackpot;
    private Lotto6Aus49 lotto6Aus49;

    public LottoService() {
        setRunning(true);
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
    public Lotto6Aus49 lotto6Aus49Erstellen() {
        return null;
    }

    @Override
    public Eurojackpot eurojackpotErstellen() {
        return null;
    }

    @Override
    public void unglückszahlenBearbeiten() {

    }

    @Override
    public HashSet<Integer> unglückszahlenErstellen(LottoTyp lottoTyp, String input) throws InvalidInputExeption {
        HashSet<Integer> unglückszahlen = new HashSet<>();
        int max;
        String[] splitInput;


        try {
            splitInput = input.split(" ");

            if (splitInput.length > 6) {
                //throw new UnglückszahlenVollExeption("Du hast mehr als 6 Zahlen eingegeben");
                starten();
            }

        } catch (Exception e) {
            throw new InvalidInputExeption("Gibt deine Unglückszahlen mit eine leerzeichen. zB: 15 4 8 2. Max 6 Zahlen");
        }

        try {
            switch (lottoTyp) {
                case LOTTO6AUS49 -> max = 49;
                case EUROJACKPOT -> max = 50;
            }
        } catch (Exception e) {

        }

        for (String unglückszahl : splitInput) {
            try {
                unglückszahlen.add(Integer.parseInt(unglückszahl));
            } catch (Exception e) {

            }

        }
        return unglückszahlen;
    }

    @Override
    public HashSet<Integer> addUnglückszahl(int i, HashSet<Integer> unglückszahlen) {
        try {
            unglückszahlen.add(i);
            return unglückszahlen;
        } catch (Exception e) {

        }
        return new HashSet<>();
    }

    @Override
    public HashSet<Integer> deleteUnglückszahl(int i, HashSet<Integer> unglückszahlen) {

        try {
            unglückszahlen.remove(i);
            return unglückszahlen;
        } catch (Exception e) {

        }
        return new HashSet<>();
    }

    @Override
    public void abschließen() {

        System.out.println("Danke für die Verwendung von Glücksspiel 3000");
        setRunning(false);

    }

    @Override
    public void starten() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen in Glücksspiel 3000");

        while (isRunning) {
            System.out.println("Bitte wählt einer unsere optionen");
            System.out.println("1. 6aus49 Reihe.");
            System.out.println("2. Eurojackpot Reihe.");
            System.out.println("3. Unglückszahlen bearbeiten.");
            System.out.println("4. Program abschließen.");
            System.out.println("Gib bitte deine Auswahl ein:");

            String input = scanner.nextLine();

            switch (input) {
                case "1", "6aus49" -> lotto6Aus49Erstellen();
                case "2", "Eurojackpot" -> eurojackpotErstellen();
                case "3", "Unglückszahlen" -> unglückszahlenBearbeiten();
                case "4", "Abschließen" -> abschließen();
                default -> System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
            }
        }

    }


}
