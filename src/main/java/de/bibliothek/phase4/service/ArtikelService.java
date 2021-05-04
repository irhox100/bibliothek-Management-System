package de.bibliothek.phase4.service;

import de.bibliothek.phase4.persistence.Artikel;

import java.util.List;


public interface ArtikelService {

    List<Artikel> findAll();

    List<Integer> getExemplareCountForArtikel();

    List<List<String>> getGenresByArtikel();

}
