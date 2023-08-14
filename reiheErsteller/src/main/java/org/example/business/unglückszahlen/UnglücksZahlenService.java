package org.example.business.unglückszahlen;

import org.example.business.LottoService;
import org.example.business.information.InformationService;
import org.example.business.information.InformationServiceInterface;
import org.example.business.logging.LogService;
import org.example.business.logging.LogServiceInterface;
import org.example.dao.LottoTyp;
import org.example.exeptions.InvalidInputException;

import java.io.IOException;
import java.util.*;

public class UnglücksZahlenService implements UnglückszahlenServiceInterface{
    private LogServiceInterface lgr;
    private HashSet<Integer> unglückszahlen;
private final InformationServiceInterface informationCodex;
    public UnglücksZahlenService() throws IOException {
        unglückszahlen=new HashSet<>();
        informationCodex=new InformationService();
        lgr= new LogService(UnglücksZahlenService.class);
    }

    public HashSet<Integer> getUnglückszahlen() {
        return unglückszahlen;
    }

    public void setUnglückszahlen(HashSet<Integer> unglückszahlen) {
        this.unglückszahlen = unglückszahlen;
    }

    public void unglückszahlenErstellen() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        unglückszahlen.clear();
        String[] splitInput = new String[6];
        System.out.println("Wähl ein Lotto: 6aus49 oder Eurojackpot");
        String input = scanner.nextLine();
        LottoTyp typ = LottoTyp.LOTTO6AUS49;
        switch (input) {
            case "6aus49" -> typ = LottoTyp.LOTTO6AUS49;
            case "eurojackpot", "Eurojackpot" -> typ = LottoTyp.EUROJACKPOT;
            default -> {
                System.out.println("Ungültige Auswahl. Bitte versuche es erneut.");
                unglückszahlenErstellen();
            }
        }
        System.out.println("Gib bitte deine Reihe:");
        String reihe = scanner.nextLine();
        int max = typ == LottoTyp.LOTTO6AUS49 ? 49 : 50;

        try {
            if (reihe.contains(" ")) {
                splitInput = reihe.split(" ");
            } else if (reihe.contains("-")) {
                splitInput = reihe.split("-");
            } else {
                throw new InvalidInputException("Ungültiges Eingabeformat. Erwarte Leerzeichen oder Bindestrich.");
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (String unglückszahl : splitInput) {
            try {
                int tmp = Integer.parseInt(unglückszahl);
                if (tmp <= max && tmp > 0) {
                    unglückszahlen.add(Integer.parseInt(unglückszahl));
                } else {
                    lgr.error("Diese Zahl: " + unglückszahl + " ist außerhalb des Lottotyps");
                }
            } catch (NumberFormatException e) {
                lgr.info("Ungültige Zahl: " + unglückszahl);
            }
        }
    }
    public void addUnglückszahl() {
        boolean anzahlIstVoll=unglückszahlen.size()<6;
        if(anzahlIstVoll){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Gib die Zahl, die hinzugefügt wird");
            String scannerInput = scanner.nextLine();

            Integer input= Integer.parseInt(scannerInput);
            if (!unglückszahlen.contains(input)){
                unglückszahlen.add(input);
            }else {
                lgr.error("Du hast eine Unglückszahl eingegeben, die schon eingegeben würde oder ein falsches input");
            }
        }else {
            lgr.error("Du hast schon 6 Unglückszahlen eingetragen. Bitte löscht deine Unglückszahlen, um neuen einzutragen");
        }

    }

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
                case "2","einzeln"-> deleteEinzelzahl();
                case "3","zurück"->{
                    return;
                }
                default -> {
                    lgr.error("Ungültige Auswahl. Bitte versuche es erneut.");
                }
            }
        }

    }

    public void deleteEinzelzahl() {
        System.out.println("Gib bitte eine einzel Zahl");
        Scanner scanner= new Scanner(System.in);
        Integer input= scanner.nextInt();
        if (!unglückszahlen.contains(input)){
            System.out.println("Diese Zahl ist nicht in deine Unglückszahlen");
        }else {
            unglückszahlen.remove(input);
        }
    }
    public void unglückszahlenBearbeiten() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Du hast Unglückszahlenbearbeitung gewählt");
        while (true){
            System.out.println("Nimm bitte eine Auswahl");
            System.out.println("1. unglückszahlen eingeben(Reihe).");
            System.out.println("2. Unglückszahlen löschen");
            System.out.println("3. unglückszahlen eingeben(Einzeln).");
            System.out.println("4. Information");
            System.out.println("5. Zurück.");
            System.out.println();
            System.out.println("Hier sind deine aktuelle Unglückszahlen:" + unglückszahlen.toString());
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
                    lgr.error("Ungültige Auswahl. Bitte versuche es erneut.");
                    informationCodex.informationUnglückszahlen();                }
            }

        }



    }
}
