package org.example.business;

import org.example.exeptions.InvalidInputExeption;

public interface LottoserviceInterface {
    public void lotto6Aus49Erstellen();
    public void eurojackpotErstellen();
    public void unglückszahlenBearbeiten() throws InvalidInputExeption;
    public void unglückszahlenErstellen() throws InvalidInputExeption;
    public void addUnglückszahl();
    public void deleteUnglückszahl();
    public void abschließen();
    public void starten() throws InvalidInputExeption;

}
