Feedback zu Übung 8
===================

Allgemeine Bemerkungen
----------------------



Aufgabe 2: Doubly-linked List
-----------------------------

Die folgenden Methoden mussten verändert/implementiert werden:

- `addFirst`: Gut gemacht!
- `addLast`: Gut gemacht!
- `removeFirst`: Gut gemacht!
- `removeLast`: Gut gemacht!
- `removeNode`: Gut gemacht!

Tests:

Nicht abgegeben.

Aufgabe 3: Warteschlangen-Simulation
------------------------------------

Gut gemacht! Eine Erklärung des Outputs wäre aber schön :)

Aufgabe 4: Pong
---------------

Gut gemacht!

Ein paar Tipps zur Verbesserung:

- Es wäre vielleicht besser, die Kollisionen in einer separaten Methode zu untersuchen
- Um das Spiel etwas schneller laufen zu lassen, kannst du die Objekte um mehr als 1 Pixel pro Zeitschritt bewegen.
- Bei den Koordinatenvergleichen muss man dann aber < oder > benutzen statt == (z.B. bei den Kollisionen: statt `ball.positionX == 0`, `ball.positionX < 0`)
- Die Spieler können sich jetzt ausserhalb des Fensters befinden... :(

