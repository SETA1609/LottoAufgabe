package org.example.business;

import org.example.exeptions.InvalidInputException;

public interface LottoserviceInterface {
    public void abschließen();
    public void starten() throws InvalidInputException;

}
