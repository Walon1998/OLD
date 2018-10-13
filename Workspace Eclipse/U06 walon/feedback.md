Feedback zu Übung 6
===================

Allgemeine Bemerkungen
----------------------

Sehr gut gelöst!

Code Style: 5.75

- Ein paar Kommentare wären schön

Aufgabe 2: Datenanalyse mit Personen
------------------------------------

a) Gut gemacht!
b) Das Ziel war, das konstruierte `array` zurückzugeben. Eine `static`-Variable funktioniert auch, wie in der Übungsstunde besprochen sind `static`-Variablen aber nicht für solche Zwecke geeignet. Sonst gut gemacht! :)
c) Gut gemacht!
d) Sehr gut!

Aufgabe 3: Black-Box Testing
----------------------------

Sehr gut, dass du den Corner Case des leeren Arrays testest! Der andere Corner Case wäre `values = null` :). Sonst wäre es auch vielleicht gut, den Code mit sehr grossen, zufälligen Arrays zu testen.

Aufgabe 4: EBNF Wiederholung
----------------------------

1. Es kann auch vorkommen, dass ein XY oder XZZZ nach einem anderen kommt, z.B. in XYXZZZ. Deswegen musst du eine Wiederholung statt eine Option für das Ganze benutzen.
2. Das Wort AXZB wird nicht akzeptiert in deiner Beschreibung, weil du nach dem XZ irgendein Symbol verlangst (hier nehmen wir B), aber dann muss laut der Beschreibung noch ein B kommen...

Aufgabe 5: Rekursion
--------------------

Das Problem, ist dass du `xEnd` und `yEnd` falsch ausrechnest und der deswegen schräg und ausserhalb des Fensters gezeichnet wird. Schau dir die Musterlösung an zur richtigen Berechnung von diesen Variablen.

Ausserdem brauchst du nicht `drawTree` in einer Schleife aufzurufen, du kannst es einmal aufrufen und danach `window.waitUntilClosed()` aufrufen.