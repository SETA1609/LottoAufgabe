package org.example;

import org.example.business.LottoService;
import org.example.business.LottoserviceInterface;
import org.example.exceptions.InvalidInputException;

import java.io.IOException;

/**
 * Application entry point.
 */
public final class Main {

    private Main() {
        // Utility class
    }

    public static void main(String[] args) throws InvalidInputException, IOException {
        LottoserviceInterface lottoService = new LottoService();
        lottoService.starten();
    }
}
