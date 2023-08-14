package org.example.business.logging;

import java.io.IOException;
import java.util.logging.*;

public class LogService implements LogServiceInterface{
    private final Logger lgr;
    private ConsoleHandler ch;
    private FileHandler fh;

    public LogService(Class<?> currentClass) throws IOException {
        this.lgr = Logger.getLogger(currentClass.getName());
        ch= new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        lgr.addHandler(ch);
        try {
            fh = new FileHandler("reiheErsteller/resources/logs/LottoLog.log", true);
            fh.setFormatter(new SimpleFormatter());
            fh.setLevel(Level.ALL);
            lgr.addHandler(fh);
        }catch (IOException e){
            error("FileHandler funktioniert nicht!");
        }

    }

    @Override
    public void info(String message) {
        lgr.log(Level.INFO, message);
    }

    @Override
    public void warning(String message) {
        lgr.log(Level.WARNING, message);
    }

    @Override
    public void error(String message) {
        lgr.log(Level.SEVERE, message);
    }

}
