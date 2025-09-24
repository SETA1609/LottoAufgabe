package org.example.business.unglueckszahlen;

import org.example.exceptions.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UngluecksZahlenServiceTest {

    private UnglueckszahlenServiceInterface ungluecksZahlenService;
    private InputStream originalIn;

    @BeforeEach
    void setUp() throws IOException {
        originalIn = System.in;
        ungluecksZahlenService = new UngluecksZahlenService();
    }

    @Test
    void unglueckszahlenErstellen() throws InvalidInputException {
        String input = "6aus49\n1 2 3 4 5 6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ungluecksZahlenService.unglueckszahlenErstellen();

        Set<Integer> expectedUnglueckszahlen = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            expectedUnglueckszahlen.add(i);
        }

        assertEquals(expectedUnglueckszahlen, ungluecksZahlenService.getUnglueckszahlen());
    }

    @Test
    void addUnglueckszahl() {
        int newUnglueckszahl = 7;
        ungluecksZahlenService.setUnglueckszahlen(new HashSet<>());
        System.setIn(new ByteArrayInputStream((newUnglueckszahl + "\n").getBytes()));

        ungluecksZahlenService.addUnglueckszahl();

        assertTrue(ungluecksZahlenService.getUnglueckszahlen().contains(newUnglueckszahl));
    }

    @Test
    void deleteEinzelzahl() {
        int existingUnglueckszahl = 2;
        Set<Integer> unglueckszahlen = new HashSet<>();
        unglueckszahlen.add(existingUnglueckszahl);
        ungluecksZahlenService.setUnglueckszahlen(unglueckszahlen);
        System.setIn(new ByteArrayInputStream((existingUnglueckszahl + "\n").getBytes()));

        ungluecksZahlenService.deleteEinzelzahl();

        assertFalse(ungluecksZahlenService.getUnglueckszahlen().contains(existingUnglueckszahl));
    }

    @AfterEach
    void restoreInput() {
        System.setIn(originalIn);
    }
}
