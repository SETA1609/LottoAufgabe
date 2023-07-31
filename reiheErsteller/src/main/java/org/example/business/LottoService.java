package org.example.business;

import org.example.dao.*;
import org.example.exeptions.InvalidInputExeption;
import org.example.exeptions.UnglückszahlenVollExeption;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class LottoService implements LottoserviceInterface {

    private Eurojackpot eurojackpot = new Eurojackpot();
    private Lotto6Aus49 lotto6Aus49 = new Lotto6Aus49();

    @Override
    public Lotto6Aus49 lotto6Aus49Erstellen() {
        return null;
    }

    @Override
    public Eurojackpot eurojackpotErstellen() {
        return null;
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
                default -> max = 49;
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
    public void starten() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen in Glücksspiel 3000");

        String input = scanner.nextLine();

        //switch ()

    }


}
