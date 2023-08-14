package org.example.business.unglückszahlen;

import org.example.exeptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UnglücksZahlenServiceTest {

    private UnglückszahlenServiceInterface unglücksZahlenService;

    @BeforeEach
    void setUp() throws IOException {
        unglücksZahlenService = new UnglücksZahlenService();
    }

    @Test
    void unglückszahlenErstellen() throws InvalidInputException {
        String input = "6aus49\n1 2 3 4 5 6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        unglücksZahlenService.unglückszahlenErstellen();

        HashSet<Integer> expectedUnglückszahlen = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            expectedUnglückszahlen.add(i);
        }

        assertEquals(expectedUnglückszahlen, unglücksZahlenService.getUnglückszahlen());
    }

    @Test
    void addUnglückszahl() {
        int newUnglückszahl = 7;
        unglücksZahlenService.setUnglückszahlen(new HashSet<>());
        String input = Integer.toString(newUnglückszahl) + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        unglücksZahlenService.addUnglückszahl();

        assertTrue(unglücksZahlenService.getUnglückszahlen().contains(newUnglückszahl));
    }


    @Test
    void deleteEinzelzahl() {
        int existingUnglückszahl = 2;
        HashSet<Integer> unglückszahlen = new HashSet<>();
        unglückszahlen.add(existingUnglückszahl);
        unglücksZahlenService.setUnglückszahlen(unglückszahlen);
        String input = Integer.toString(existingUnglückszahl) + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        unglücksZahlenService.deleteEinzelzahl();

        assertFalse(unglücksZahlenService.getUnglückszahlen().contains(existingUnglückszahl));
    }
}