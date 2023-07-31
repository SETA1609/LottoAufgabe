# LottoAufgabe

Ausgangssituation:
Herr Keller (57) spielt regelmäßig Lotto (6aus49) und ab und an auch Eurojackpot. Herr Keller geht mit
der Zeit. Natürlich spielt er online. Er spielt auf der Webseite seiner Landeslotterie Gesellschaft
(westlotto.de) mit seinem Laptop. Allerdings bieten die dort angebotenen Quicktipp-Generatoren
nicht die eine Funktionalität, die er gerne hätte. Herr Keller möchte bei der Generierung sicherstellen,
dass seine Unglückszahlen nicht Teil der zufälligen Tippreihe werden. Er ärgert sich, jedes Mal ein
wenig, wenn die generierte Quicktipp-Tippreihe eine seiner drei Unglückszahlen enthält.
Jeden Monat ändern sich auch noch seine Unglückszahlen, die er aus dem Horoskop seines
Lieblingsmagazins entnimmt. Herr Keller hat uns gebeten ihm eine kleine Java-Applikation zur
Verfügung zu stellen, die er auf seinem Laptop laufen lassen kann, um darüber seine Tippreihe für die
nächste Spielteilnahme zu generieren. Wir haben uns gedacht, das ist doch eine einfache Aufgabe.
Und weil Herr Keller so nett ist, wollen wir ihm gerne behilflich sein. Bitte hilf uns, Herrn Keller zu
helfen.
Aus einem weiteren Gespräch mit Herrn Keller haben wir folgende Anforderungen in Form von
UserStories abgeleitet:
- Als Lottospieler möchte ich über eine kleine Java-Applikation Tippreihen generieren.
Akzeptanz Kriterium: Als Aufruf und Präsentationsmittel soll die Kommando-Zeile bzw.
Terminalzeile verwendet werden
- Als Lottospieler möchte ich bestimmen, ob eine spezielle Tippreihe für Lotto 6aus49 oder eine
für Eurojackpot (5aus50 plus 2aus10) generiert wird.
Akzeptanz-Kriterien:
  o Die Auswahl des Spiels, für das die Tippreihe generiert werden soll, wird über feste
Namensparameter ausgewählt
  o Wird dieser Parameter nicht definiert, soll eine Tippreihe für Lotto 6aus49 gewählt
werden
  o Sollte ein ungültiger Parameter angegeben werden, wird eine Fehlermeldung
ausgegeben. Die Fehlermeldung beinhaltet die gültigen Namensparameter.
- Als Lottospieler möchte ich bis zu sechs Unglückszahlen eingeben, die bei der Generierung der
Tippreihe ausgeschlossen werden.
Akzeptanz-Kriterien:
  o Die Übergabe der Unglückszahlen erfolgt als Aufrufparameter
  o Die eingegeben Unglückszahlen werden geprüft, ob sie innerhalb der Grenzen des
gültigen Zahlenraums liegen.
  o Sollte eine ungültige Unglückszahl angegeben werden, erfolgt die Ausgabe einer
Fehlermeldung. Diese Fehlermeldung soll den gültigen Zahlenraum angeben.
  o Die Unglückszahlen werden gespeichert, so dass diese auch bei der nächsten
Verwendung (nach schließen der Applikation) berücksichtigt werden können.
  o Die Unglückszahlen werden unabhängig von der Lotterie berücksichtigt
- Als Lottospieler möchte ich neue Unglückszahlen festlegen können.
- Als Lottospieler möchte ich die Unglückszahlen löschen können.
- Als Lottospieler möchte ich, dass die zufällig ermittelte Tippreihe so ausgegeben wird, dass ich diese einfach übertragen kann.
  Akzeptanz-Kriterium: Sortierte, aufsteigende Reihenfolge der Zahlen der Tippreihe,
  Erkennbare Trennung für die Eurojackpot-Tippreihe erst 5aus50 dann 2aus10.-
  Optionale Anforderung:
  o Als Lottospieler möchte ich noch weitere Tippreihen generieren können, bis ich das System stoppe.
Zusätzlich zu den oben genannten funktionalen Anforderungen, möchten wir Dich bitten, bei der
Umsetzung der Aufgabe folgendes zu beachten.
- Setze Vererbung ein
- Bitte verwende ein Interface, dass die allgemeinen Funktionen zur Generierung von Tippreihen aufweist.
- Beachte Exceptions-Handling
- Schreibe Logfiles, die im Fehlerfall analysiert werden können.
- Nutze Unittests um die Funktionsweise zu prüfen
- Setze Github zur konsequenten Versionierung des Fortschrittes ein
- Dokumentiere die Lösung kurz, sowohl für den Anwender als auch für einen anderen Programmierer.
