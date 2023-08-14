
# Lottery Service Dokumentation

Die vorliegende Dokumentation beschreibt die Struktur und Funktionalität des Lottery Service-Programms. Dieses Programm ermöglicht es Benutzern, Lottozahlen zu generieren, Unglückszahlen zu verwalten und Informationen über das Programm anzuzeigen.

## Inhaltsverzeichnis

- [Klassenübersicht](#klassenübersicht)
- [Funktionsweise](#funktionsweise)
- [Nutzung](#nutzung)
- [Logging](#logging)

## Klassenübersicht

1. `InformationService`: Zeigt Menüs und Informationen für den Benutzer an.
2. `LogService`: Verwaltet das Protokollieren von Nachrichten für das Programm.
3. `TippreiheService`: Generiert Lottozahlen für verschiedene Lotterietypen.
4. `UnglücksZahlenService`: Verwaltet Unglückszahlen für verschiedene Lotterietypen.
5. `LottoService`: Die Hauptklasse, die die Benutzerinteraktion koordiniert.

## Funktionsweise

Das Programm bietet dem Benutzer verschiedene Optionen:

- Generieren von Lottozahlen für "6aus49" und "Eurojackpot".
- Verwalten von Unglückszahlen für verschiedene Lotterietypen.
- Anzeigen von Informationen über das Programm.
- Beenden des Programms.

## Nutzung

1. Starten Sie das Programm, indem Sie die `LottoService` Instanz in main aufrufen.
2. Wählen Sie aus den angezeigten Menüoptionen:
  - "6aus49 Reihe": Generieren von Lottozahlen für 6aus49.
  - "Eurojackpot Reihe": Generieren von Lottozahlen für Eurojackpot. (5aus50 und 2aus10)
  - "Unglückszahlen bearbeiten": Verwalten von Unglückszahlen.
  - "Information": Anzeigen von Programminformationen.
  - "Programm abschließen": Beenden des Programms.

## Logging

Das Programm verwendet das `LogService`-Modul, um Protokollnachrichten zu erstellen. Es werden 2 Protokollwährungsstufen verwendet:

- `info`: Allgemeine Informationen über den Programmablauf.
- `error`: Fehlermeldungen und Ausnahmen.

Die Protokolldatei wird unter `reiheErsteller/resources/logs/LottoLogs.txt` gespeichert.

---

Made by @SETA1609 - Sebastian Tamayo
