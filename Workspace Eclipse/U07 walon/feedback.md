Feedback zu Übung 6
===================

Allgemeine Bemerkungen
----------------------

Gut gemacht!

Code Style: 5.5

- Ein paar Kommentare wären schön, vor allem bei `RandomWalks`.

Aufgabe 1: Linked List
----------------------

Dadurch, dass alle deine Methoden und Felder `static` sind, kann nur eine Instanz der Klasse zur gleichen Zeit existieren (`static` Variablen sind ja unter verschiedene Instanzen "geteilt").

- `IntNode` Klasse: Gut gemacht!
- `LinkedIntList` Klasse: Gut gemacht!
- `Echo` Klasse: Gut gemacht!

- `addLast`: Gut gemacht!
- `addFirst`: Falls die Liste leer, vergisst du `last` anzupassen.
- `removeFirst`: Falls die Liste nur ein Element hatte, setzt du `first` auf `null`, `last` zeigt aber noch auf das entfernte Element!
- `removeLast`: Beim Entfernen vergisst du `last` anzupassen (`last` zeigt noch auf das entferne Element)
- `clear`: Du vergisst, `last` auf `null` zu setzen. Ausserdem braucht diese Methode O(n), während es in O(1) einfach machbar ist (`first = null; last = null; size = 0`).
- `isEmpty`: Richtig. Du kannst es aber zu `return size == 0` vereinfachen.
- `get`: Richtig.
- `set`: Richtig.
- `toArray`: Gut gemacht!

Aufgabe 2: Unit-Tests für die Linked List
-----------------------------------------

Nicht abgegeben.

Aufgabe 4: Self-avoiding Random Walks
-------------------------------------

Sehr gut gemacht! Hier gibt es aber das gleiche Problem mit den `static` Variablen und Methoden.
