package org.example.business.unglückszahlen;

import org.example.exeptions.InvalidInputExeption;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;


import static org.junit.jupiter.api.Assertions.*;

class UnglücksZahlenServiceTest {

    private UnglücksZahlenService unglücksZahlenService;

    @BeforeEach
    void setUp() {
        unglücksZahlenService = new UnglücksZahlenService();
        unglücksZahlenService.setUnglückszahlen(new HashSet<>());
    }

    @Test
    void testUnglückszahlenErstellen_ValidInput() throws InvalidInputExeption {
        setInput("6aus49\n1 2 3 4 5 6");
        unglücksZahlenService.unglückszahlenErstellen();
        assertEquals(6, unglücksZahlenService.getUnglückszahlen().size());
    }

    @Test
    void testUnglückszahlenErstellen_InvalidInput() {
        setInput("invalid\ninvalid");
        assertThrows(InvalidInputExeption.class, () -> unglücksZahlenService.unglückszahlenErstellen());
    }

    @Test
    void testAddUnglückszahl_ValidInput() {
        setInput("7");
        unglücksZahlenService.addUnglückszahl();
        assertTrue(unglücksZahlenService.getUnglückszahlen().contains(7));
    }

    @Test
    void testAddUnglückszahl_InvalidInput() {
        setInput("invalid");
        unglücksZahlenService.addUnglückszahl();
        assertFalse(unglücksZahlenService.getUnglückszahlen().contains("invalid"));
    }

    @Test
    void testDeleteEinzelzahl_ValidInput() {
        HashSet<Integer> unglückszahlen = new HashSet<>();
        unglückszahlen.add(5);
        unglücksZahlenService.setUnglückszahlen(unglückszahlen);

        setInput("5");
        unglücksZahlenService.deleteEinzelzahl();

        assertFalse(unglücksZahlenService.getUnglückszahlen().contains(5));
    }

    @Test
    void testDeleteEinzelzahl_InvalidInput() {
        HashSet<Integer> unglückszahlen = new HashSet<>();
        unglückszahlen.add(5);
        unglücksZahlenService.setUnglückszahlen(unglückszahlen);

        setInput("invalid");
        unglücksZahlenService.deleteEinzelzahl();

        assertTrue(unglücksZahlenService.getUnglückszahlen().contains(5));
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}