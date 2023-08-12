package org.example.business;

import org.example.business.information.InformationService;
import org.example.business.information.InformationServiceInterface;
import org.example.dao.*;
import org.example.exeptions.*;

import java.util.*;

public class LottoService implements LottoserviceInterface {

    private boolean isRunning;
    private Eurojackpot eurojackpot;
    private Lotto6Aus49 lotto6Aus49;
    private HashSet<Integer> unglückszahlen;
    private final InformationServiceInterface informationCodex;

    public LottoService() {
        setRunning(true);
        unglückszahlen = new HashSet<>();
        informationCodex = new InformationService();
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
    public void unglückszahlenErstellen() throws InvalidInputExeption {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> unglückszahlen = new HashSet<>();
        int max;
        String[] splitInput;
        System.out.println("Wähl ein Lotto: 6aus49 oder Eurojackpot");
        String input= scanner.nextLine();
        LottoTyp typ;
        switch (input){
            case "6aus49"->typ=LottoTyp.LOTTO6AUS49;
            case "eurojackpot","Eurojackpot"->typ=LottoTyp.EUROJACKPOT;
            default -> {
                System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
                unglückszahlenErstellen();
            }
        }
        System.out.println("Gib bitte deine Reihe:");
        String reihe = scanner.nextLine();



        try {
            splitInput = reihe.split(" ");

            if (splitInput.length > 6) {
                //throw new UnglückszahlenVollExeption("Du hast mehr als 6 Zahlen eingegeben");
                starten();
            }

        } catch (Exception e) {
            throw new InvalidInputExeption("Gibt deine Unglückszahlen mit eine leerzeichen. zB: 15 4 8 2. Max 6 Zahlen");
        }



        for (String unglückszahl : splitInput) {
            try {
                unglückszahlen.add(Integer.parseInt(unglückszahl));
            } catch (Exception e) {

            }

        }
    }

    @Override
    public void addUnglückszahl() {

        if (unglückszahlen.size()<6){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Gib die Zahl, die hinzugefügt wird");
            String scannerInput = scanner.nextLine();

            Integer input= Integer.parseInt(scannerInput);
            if (!unglückszahlen.contains(input)){
                unglückszahlen.add(input);
            }else {
                System.out.println("Du hast eine Unglückszahl eingegeben, die schon eingegeben würde oder ein falsches input");
            }
        }else {
            System.out.println("Du hast schon 6 Unglückszahlen eingetragen. Bitte löscht deine Unglückszahlen, um neuen einzutragen");
        }

    }

    @Override
    public void deleteUnglückszahl() {

        while (true){
            System.out.println("Hier kann man einzelne oder alle Unglückszahlen");
            System.out.println();
            System.out.println("1. Alle Zahlen löschen.");
            System.out.println("2. Nur ein einzeln Zahl löschen.");
            System.out.println("3. Zurück.");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input){
                    case "1","alle"->unglückszahlen.clear();
                    case "2","einzeln"->{

                    }
                    case "3","zurück"->{
                        return;
                    }
                    default -> {
                        System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");

                    }
            }
        }

    }
    //Als Lottospieler möchte ich bis zu sechs Unglückszahlen eingeben, die bei der Generierung der Tippreihe ausgeschlossen werden. Akzeptanz-Kriterien:
    // o Die Übergabe der Unglückszahlen erfolgt als Aufrufparameter
    // o Die eingegeben Unglückszahlen werden geprüft, ob sie innerhalb der Grenzen des gültigen Zahlenraums liegen.
    // o Sollte eine ungültige Unglückszahl angegeben werden, erfolgt die Ausgabe einer Fehlermeldung. Diese Fehlermeldung soll den gültigen Zahlenraum angeben.
    // o Die Unglückszahlen werden gespeichert, so dass diese auch bei der nächsten Verwendung (nach schließen der Applikation) berücksichtigt werden können.
    // o Die Unglückszahlen werden unabhängig von der Lotterie berücksichtigt
    @Override
    public void unglückszahlenBearbeiten() throws InvalidInputExeption {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Du hast Unglückszahlenbearbeitung gewählt");
        while (true){
            System.out.println("Nimm bitte eine Auswahl");
            System.out.println("1. unglückszahlen eingeben(Reihe).");
            System.out.println("2. Unglückszahlen löschen");
            System.out.println("3. unglückszahlen eingeben(Einzeln).");
            System.out.println("4. Information");
            System.out.println("5. Zurück.");
            String input = scanner.nextLine();
            System.out.println();
            switch (input){
                case "1", "reihe" -> unglückszahlenErstellen();
                case "2", "löschen" -> deleteUnglückszahl();
                case "3", "einzeln" -> addUnglückszahl();
                case "4", "information"-> informationCodex.informationUnglückszahlen();
                case "5", "zurück" -> {
                    return;
                }
                default -> {
                    System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
                    informationCodex.informationUnglückszahlen();                }
            }

        }



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
                case "3", "unglückszahlen" -> unglückszahlenBearbeiten();
                case "4", "information"-> informationCodex.information();
                case "5", "abschließen" -> abschließen();
                default -> {
                    System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
                    informationCodex.information();                }
            }
        }

    }

}
