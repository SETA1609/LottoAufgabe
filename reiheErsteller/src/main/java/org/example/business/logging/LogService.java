package org.example.business.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Wrapper around the JDK logger that configures console and file logging.
 */
public class LogService implements LogServiceInterface {

    private static final Path LOG_FILE = Path.of("reiheErsteller", "resources", "logs", "LottoLogs.txt");

    private final Logger logger;

    public LogService(Class<?> currentClass) throws IOException {
        this.logger = Logger.getLogger(currentClass.getName());
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        configureConsoleHandler();
        configureFileHandler();
    }

    private void configureConsoleHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        logger.addHandler(consoleHandler);
    }

    private void configureFileHandler() throws IOException {
        Files.createDirectories(LOG_FILE.getParent());
        try {
            FileHandler fileHandler = new FileHandler(LOG_FILE.toString(), true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            error("FileHandler funktioniert nicht! " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    @Override
    public void error(String message) {
        logger.log(Level.SEVERE, message);
    }
}
