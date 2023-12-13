# Notendurchschnittsberechnungsaufgabe

Hier findet man die einfache Umsetzung einer Notendurchschnittsberechnung in Springboot.
Das ist die zweite (und simplere) Version einer REST-Anwendung, in der man Faecher erstellen kann, um
danach den Durchschnitt berechnen zu können. Updates und Verbesserung folgen noch...

![screen-swagger](https://github.com/nawazUAS/NotendurchschnittsberechnungEINFACH/assets/152324471/790240cb-9ba3-4d5a-b746-851d001e74fc)


- <b>PUT</b>	/fach/{id}/note => Die Note eines Fachs aendern
- <b>PUT</b>	/fach/{id} => Das Fach an sich aendern
- <b>DELETE</b>	/fach/{id} => Das Fach löschen
- <b>POST</b>	/fach => Ein neues Fach erstellen
- <b>GET</b>	/faecher => Alle Faecher anzeigen lassen
- <b>GET</b>	/faecher/durchschnitt => Den Notendurchschnitt anzeigen lassen
