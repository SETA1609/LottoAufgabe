# Lottery Service

Ein Java-Konsolenprogramm, das Tippempfehlungen für Lotto 6aus49 und Eurojackpot generiert und dabei vom Benutzer gepflegte Unglückszahlen berücksichtigt. Das Projekt wurde umfassend überarbeitet, um eine saubere Architektur, Tests, Linting und eine automatisierte CI-Pipeline bereitzustellen.

## Inhalt

- [Architekturüberblick](#architekturüberblick)
- [Voraussetzungen](#voraussetzungen)
- [Projekt bauen und testen](#projekt-bauen-und-testen)
- [Anwendung starten](#anwendung-starten)
- [Code-Qualität und Linting](#code-qualität-und-linting)
- [Logging](#logging)
- [GitHub Actions](#github-actions)

## Architekturüberblick

Der Quellcode befindet sich im Modul [`reiheErsteller`](reiheErsteller/). Die wichtigsten Pakete sind:

| Paket | Beschreibung |
|-------|--------------|
| `org.example.business` | Enthält den `LottoService`, der die Konsoleninteraktion koordiniert. |
| `org.example.business.information` | Gibt Hilfetexte für Benutzeraktionen aus. |
| `org.example.business.tippreihe` | Erzeugt Lotteriereihen und kapselt das Logging. |
| `org.example.business.unglueckszahlen` | Verwaltet Unglückszahlen inklusive Eingabe-Workflow. |
| `org.example.business.logging` | Stellt eine dünne Logging-Abstraktion bereit und konfiguriert `java.util.logging`. |
| `org.example.dao` | Domänenobjekte wie `Tippreihe`, `Lotto6Aus49` und `Eurojackpot`. |
| `org.example.exceptions` | Definiert domänenspezifische Ausnahmen. |

Unit-Tests befinden sich spiegelbildlich unter `src/test/java` und decken zentrale Geschäftslogik (Unglückszahlen, Tippgeneratoren und Services) ab.

## Voraussetzungen

- Java 17 oder neuer
- Maven 3.9 oder neuer

## Projekt bauen und testen

Führe die folgenden Befehle im Repository-Hauptverzeichnis aus:

```bash
mvn -f reiheErsteller/pom.xml -B verify
```

Der Befehl kompiliert den Code, führt alle Unit-Tests aus und startet anschließend Checkstyle zur statischen Codeanalyse. In Umgebungen ohne Internetzugang können die Maven-Downloads fehlschlagen; wiederhole den Befehl in diesem Fall später oder verwende eine Umgebung mit Netzwerkzugriff.

## Anwendung starten

Das Programm lässt sich nach erfolgreichem Build mit folgendem Befehl starten:

```bash
java -cp reiheErsteller/target/classes org.example.Main
```

Anschließend führt dich ein Konsolenmenü durch die Erstellung von Tipp­reihen, die Pflege deiner Unglückszahlen sowie den Abruf von Informationsseiten.

## Code-Qualität und Linting

- **Checkstyle** überprüft Einrückungen, Leerzeichen, Javadoc-Dokumentation sowie Import-Richtlinien (`mvn ... verify`).
- **Strukturierte Services** und **Interface-Abstraktionen** erleichtern das Testen und Logging.
- **Unit-Tests** für Tippgeneratoren und Unglückszahlen validieren Randfälle (z. B. Ausschluss von Unglückszahlen und deterministische Zufallszahlen in Tests).

## Logging

Alle Services verwenden `LogService`, der Konsolen- und Datei-Logging (`reiheErsteller/resources/logs/LottoLogs.txt`) konfiguriert. Beim ersten Start wird der Log-Ordner automatisch angelegt.

## GitHub Actions

Die Workflow-Datei [.github/workflows/ci.yml](.github/workflows/ci.yml) führt bei Pull Requests sowie bei Pushes auf den `main`-Branch automatisch `mvn -f reiheErsteller/pom.xml verify` aus. Dadurch werden Build, Tests und Checkstyle-Analyse kontinuierlich überwacht.

---

Viel Erfolg und viel Spaß beim Generieren deiner nächsten Tipp­reihen!
