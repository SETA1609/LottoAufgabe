package org.example.business.unglückszahlen;

import org.example.exeptions.InvalidInputException;

import java.util.HashSet;

public interface UnglückszahlenServiceInterface {
    public void unglückszahlenErstellen() throws InvalidInputException;
    public void addUnglückszahl();
    public void deleteUnglückszahl();
    public void deleteEinzelzahl();
    public HashSet<Integer> getUnglückszahlen();
    public void setUnglückszahlen(HashSet<Integer> unglückszahlen);
    public void unglückszahlenBearbeiten() throws InvalidInputException;
}
