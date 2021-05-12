package de.bibliothek.phase4.service;


import de.bibliothek.phase4.persistence.Artikel;

import java.util.List;

public interface NutzerService {

    void createBibliothekar(String email, String geburtsdatum,String nachname, String vorname, String passwort, String telefonnummer);

    void createKunde(String email, String geburtsdatum, String vorname, String nachname, String passwort,Double guthaben, Boolean beitragsbefreit,
                     String stadt, String strasse, Integer plz, Integer hausnummer);

    List<Artikel> findAll();

    List<Integer> getExemplareCountForArtikel();

    List<List<String>> getGenresByArtikel();

    Boolean isNutzerKunde(String email);

    Boolean isNutzerBibliothekar(String email);

    List<List<Integer>> getExemplareIDsForArtikel();
}
