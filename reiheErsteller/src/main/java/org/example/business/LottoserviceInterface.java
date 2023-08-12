package org.example.business;

import org.example.exeptions.InvalidInputExeption;

public interface LottoserviceInterface {
    public void lotto6Aus49Erstellen();
    public void eurojackpotErstellen();
    public void abschließen();
    public void starten() throws InvalidInputExeption;

}
