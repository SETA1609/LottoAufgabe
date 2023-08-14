# LottoAufgabe

## Ausgangssituation

Herr Keller (57) spielt regelmäßig Lotto (6aus49) und ab und an auch Eurojackpot. Er verwendet die Webseite seiner Landeslotterie Gesellschaft (westlotto.de) auf seinem Laptop. Die vorhandenen Quicktipp-Generatoren erfüllen jedoch nicht seine Anforderungen. Herr Keller möchte sicherstellen, dass seine Unglückszahlen nicht in den generierten Tippreihen enthalten sind. Er möchte vermeiden, dass seine Unglückszahlen in den generierten Quicktipp-Tippreihen auftauchen.

Jeden Monat ändert Herr Keller auch seine Unglückszahlen, die er aus dem Horoskop seines Lieblingsmagazins erhält. Um ihm zu helfen, benötigen wir eine kleine Java-Applikation, die auf seinem Laptop ausgeführt werden kann, um Tippreihen für die nächste Lottoziehung zu generieren. Diese Aufgabe erscheint relativ einfach, und wir möchten Herrn Keller gerne unterstützen. Hierbei benötigen wir deine Hilfe, um Herrn Keller zu helfen.

## Anforderungen (User Stories)

### 1. Tippreihen generieren

- Als Lottospieler möchte ich über eine Java-Applikation Tippreihen generieren können.
- Akzeptanzkriterium: Die Generierung erfolgt über die Kommandozeile bzw. das Terminal.

### 2. Auswahl des Lotterietyps

- Als Lottospieler möchte ich zwischen Lotto 6aus49 und Eurojackpot (5aus50 plus 2aus10) wählen können.
- Akzeptanzkriterien:
    - Die Auswahl des Lotterietyps erfolgt durch Namensparameter.
    - Ohne definierten Parameter wird standardmäßig Lotto 6aus49 gewählt.
    - Bei ungültigen Parametern wird eine Fehlermeldung mit den gültigen Optionen angezeigt.

### 3. Ausschluss von Unglückszahlen

- Als Lottospieler möchte ich bis zu sechs Unglückszahlen festlegen können, die in den generierten Tippreihen nicht enthalten sein sollen.
- Akzeptanzkriterien:
    - Die Übergabe der Unglückszahlen erfolgt als Aufrufparameter.
    - Eingegebene Unglückszahlen werden auf Gültigkeit überprüft.
    - Bei ungültigen Unglückszahlen wird eine Fehlermeldung mit dem gültigen Zahlenbereich angezeigt.
    - Unglückszahlen werden gespeichert und bei späteren Verwendungen berücksichtigt.
    - Die Unglückszahlen gelten unabhängig vom Lotterietyp.

### 4. Verwaltung der Unglückszahlen

- Als Lottospieler möchte ich neue Unglückszahlen festlegen und bestehende Unglückszahlen löschen können.

### 5. Ausgabe der Tippreihen

- Als Lottospieler möchte ich die zufällig generierte Tippreihe in aufsteigender Reihenfolge angezeigt bekommen.
- Akzeptanzkriterium: Die Eurojackpot-Tippreihe wird in zwei Teilen dargestellt (5aus50 und 2aus10).

### Optionale Anforderung

- Als Lottospieler möchte ich beliebig viele Tippreihen generieren können, bis das Programm beendet wird.

## Hinweise zur Umsetzung

- Verwende Vererbung.
- Nutze ein Interface für die allgemeinen Funktionen zur Generierung von Tippreihen.
- Implementiere ein sorgfältiges Exceptions-Handling.
- Erstelle Logdateien für Fehleranalysen.
- Führe Unittests durch, um die Funktionalität zu überprüfen.
- Verwende Github zur Versionierung des Codes.
- Dokumentiere die Lösung für Anwender und andere Programmierer.

--- 