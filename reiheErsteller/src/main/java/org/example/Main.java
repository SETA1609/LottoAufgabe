package org.example;

import org.example.business.LottoService;
import org.example.business.LottoserviceInterface;
import org.example.exeptions.InvalidInputException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidInputException, IOException {

        LottoserviceInterface lottoserviceInterface= new LottoService();
        lottoserviceInterface.starten();

    }
}