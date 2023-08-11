package org.example;

import org.example.business.LottoService;
import org.example.business.LottoserviceInterface;
import org.example.exeptions.InvalidInputExeption;

public class Main {
    public static void main(String[] args) throws InvalidInputExeption {

        LottoserviceInterface lottoserviceInterface= new LottoService();
        lottoserviceInterface.starten();

    }
}