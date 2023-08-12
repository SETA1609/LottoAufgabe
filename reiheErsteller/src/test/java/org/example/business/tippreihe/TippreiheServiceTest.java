package org.example.business.tippreihe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class TippreiheServiceTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testLotto6Aus49Erstellen() {
        TippreiheService tippreiheService = new TippreiheService();

        tippreiheService.lotto6Aus49Erstellen(new HashSet<>());

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Hier ist deine Empfehlung:"));
    }

    @Test
    void testEurojackpotErstellen() {
        TippreiheService tippreiheService = new TippreiheService();

        tippreiheService.eurojackpotErstellen(new HashSet<>());

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Hier ist deine Empfehlung für 5aus50:"));
        assertTrue(output.contains("Hier ist deine Empfehlung für 2aus10:"));
    }
    @AfterEach
    void restoreStreams() {
        System.setOut(originalSystemOut);
    }
}