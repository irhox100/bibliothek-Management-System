package de.bibliothek.phase4.service;


public interface NutzerService {

    void createBibliothekar(String email, String geburtsdatum,String nachname, String vorname, String passwort, String telefonnummer);

    void createKunde(String email, String geburtsdatum, String vorname, String nachname, String passwort,Double guthaben, Boolean beitragsbefreit,
                     String stadt, String strasse, Integer plz, Integer hausnummer);
}
