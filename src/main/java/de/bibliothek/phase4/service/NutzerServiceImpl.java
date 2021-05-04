package de.bibliothek.phase4.service;

import de.bibliothek.phase4.persistence.NutzerRepository;


public class NutzerServiceImpl implements NutzerService {
    final NutzerRepository nutzerRepository;

    public NutzerServiceImpl(NutzerRepository nutzerRepository) {
        this.nutzerRepository = nutzerRepository;
    }

    @Override
    public void createBibliothekar(String email, String geburtsdatum, String vorname, String nachname, String passwort, String telefonnummer) {
        nutzerRepository.createNutzer(email, geburtsdatum, vorname, nachname, passwort);
        nutzerRepository.createBibliothekar(email, telefonnummer);
    }
}
