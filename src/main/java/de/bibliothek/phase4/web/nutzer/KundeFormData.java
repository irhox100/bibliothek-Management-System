package de.bibliothek.phase4.web.nutzer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KundeFormData {
    String email;
    String geburtsdatum;
    String nachname;
    String vorname;
    String passwort;
    Double guthaben;
    Boolean beitragsbefreit;
    String stadt;
    String strasse;
    Integer plz;
    Integer hausnummer;

}
