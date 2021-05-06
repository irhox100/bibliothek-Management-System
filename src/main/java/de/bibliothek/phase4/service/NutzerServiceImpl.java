package de.bibliothek.phase4.service;

import de.bibliothek.phase4.persistence.NutzerRepository;


public class NutzerServiceImpl implements NutzerService {
    final NutzerRepository nutzerRepository;

    public NutzerServiceImpl(NutzerRepository nutzerRepository) {
        this.nutzerRepository = nutzerRepository;
    }

    @Override
    public void createBibliothekar(String email, String geburtsdatum, String vorname, String nachname, String passwort, String telefonnummer) {
        nutzerRepository.createNutzer(email, geburtsdatum, nachname, vorname, passwort);
        nutzerRepository.createBibliothekar(email, telefonnummer);
    }

    @Override
    public void createKunde(String email, String geburtsdatum, String vorname, String nachname, String passwort,
                            Double guthaben, Boolean beitragsbefreit, String stadt, String strasse, Integer plz, Integer hausnummer) {

        nutzerRepository.createAdresse(stadt, plz, strasse, hausnummer);
        nutzerRepository.createNutzer(email, geburtsdatum, nachname, vorname, passwort);
        nutzerRepository.createKunde(email, guthaben, beitragsbefreit, stadt, plz, strasse, hausnummer);
    }
}
