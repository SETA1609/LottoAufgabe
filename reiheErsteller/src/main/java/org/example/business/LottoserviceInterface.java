package org.example.business;

import org.example.exeptions.InvalidInputExeption;

public interface LottoserviceInterface {
    public void abschließen();
    public void starten() throws InvalidInputExeption;

}
