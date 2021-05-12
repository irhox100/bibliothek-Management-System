package de.bibliothek.phase4.service;

import de.bibliothek.phase4.persistence.Artikel;
import de.bibliothek.phase4.persistence.ArtikelRepository;
import de.bibliothek.phase4.persistence.NutzerRepository;

import java.util.List;
import java.util.stream.Collectors;


public class NutzerServiceImpl implements NutzerService {
    final NutzerRepository nutzerRepository;
    final ArtikelRepository artikelRepository;


    public NutzerServiceImpl(NutzerRepository nutzerRepository, ArtikelRepository artikelRepository) {
        this.nutzerRepository = nutzerRepository;
        this.artikelRepository = artikelRepository;
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

    @Override
    public List<Artikel> findAll() {
        return artikelRepository.findAll();
    }

    @Override
    public List<Integer> getExemplareCountForArtikel(){
        return findAll().stream().map(a -> artikelRepository.getExemplareCountForArtikel(a.getIsbnnummer())).collect(Collectors.toList());
    }

    @Override
    public List<List<String>> getGenresByArtikel() {
        return findAll().stream().map(a -> artikelRepository.getGenresByArtikel(a.getIsbnnummer())).collect(Collectors.toList());
    }

    @Override
    public Boolean isNutzerKunde(String email) {
        return nutzerRepository.isNutzerKunde(email);
    }

    @Override
    public Boolean isNutzerBibliothekar(String email) {
        return nutzerRepository.isNutzerBibliothekar(email);
    }

    @Override
    public List<List<Integer>> getExemplareIDsForArtikel() {
        return findAll().stream().map(a -> artikelRepository.getExemplareIDsForArtikel(a.getIsbnnummer())).collect(Collectors.toList());
    }
}
