Feedback zu Übung 5
===================

Allgemeine Bemerkungen
----------------------

Gut gemacht! Code Style ist auch schön!

Aufgabe 1: Testen mit JUnit
---------------------------

Sehr gut gemacht!

Aufgabe 2: Wörter raten
-----------------------

Dein Programm macht nicht ganz das, was auf dem Aufgabenblatt stand. Der Benutzer sollte einen String eingeben und das Programm sollte dann dem Benutzer sagen, ob der eingegebene String am Anfang, Ende, am Anfang und am Ende oder irgendwo in der Mitte ist (oder auch nicht im Wort enthalten ist). Guck dir die Musterlösung an, um zu sehen, wie sie es dort gemacht haben.

Sonst noch zur Hauptschleife des Spiels: es wäre vielleicht sinnvoller, eine `do-while`-Schleife zu benutzen, da diese semantisch klar macht, dass der Benutzer mindestens einmal einen String eingeben muss. Auch musst du dann nicht explizit einmal `"Gib dein Tipp ein: "` auszugeben und musst `tipp` auch nicht vor der Schleife mit einem dummy-Wert initialisieren. 

Aufgabe 3: Datenanalyse
-----------------------

Gut gemacht! Bei der einfachen Analyse fehlt nur die Berechnung des Durchschnitts.

Bei der Erstellung des Histogramms wäre es vielleicht sinnvoller, einmal über die Grössen zu iterieren und für jede einzelne Grösse zu entscheiden, in welcher Klasse sie gehört, statt für jede Klasse über alle Grössen zu iterieren.

Sonst wäre es auch noch ganz einfach gewesen, das Histogramm in der Konsole auszugeben: du musst einfach über den Histogramm-Array iterieren und für jeden Wert in diesem Array genau soviele "|"s ausgeben (siehe Musterlösung).

Aufgabe 5: Analoge Uhr
----------------------

Gut gemacht! Schön, dass du mit `SIZE` parametrisiert hast!