Feedback zu Übung 4
===================

Allgemeine Bemerkungen
----------------------

Gut gelöst!

Aufgabe 1: Sieb des Eratosthenes
--------------------------------

Gut gemacht! Ein paar Tipps:

1. in Z. 29 siehst du ein Beispiel des Fencepost-Problems: das Programm gibt ein Komma zu viel aus. Man muss die erste oder die letzte Zahl bei der Ausgabe also besonders behandeln.
2. Deine `while`-Schleife von Z. 31 bis 37 kann man semantisch gesehen am besten als `for`-Schleife schreiben:

```java
int k = 1;
int j = i;
while (j < limit) {
	array[j] = false;
	k++;
	j = i * k;
}
```

wird zu:

```java
for (int j = i; j < limit; j += i) {
	array[j] = false;
}
```

Man sollte eine `for`-Schleife benutzen, wenn man einen Index benutzt, den man irgendwie verändert und falls man die Schleife abbricht, falls eine bestimmte Bedingung am Index wahr/falsch ist.

Du solltest ausserdem noch schauen, dass der Benutzer eine positive Zahl eingibt.

Aufgabe 2: Newton-Raphson
-------------------------

Sehr gut gemacht, und schön dass du eine rekursive und iterative Lösung geschrieben hast! Es gibt nur einen Bug: falls der Benutzer eine negative Zahl eingibt, gibt es bei der rekursiven Version ein StackOverflowError und bei der iterativen läuft die Schleife unendlich.

Aufgabe 4: Chaos game
---------------------

Gut gemacht! Es wäre vom Code Style her aber vielleicht schöner, wenn du die einzelnen Punkte in einem Array {x, y} speicherst und zusätzlich noch die Eckpunkte in einem Array speicherst. Dann brauchst du den `switch` nicht und kannst direkt via dem Index `randomNumber3` auf den richtigen Eckpunkt zugreifen. 

