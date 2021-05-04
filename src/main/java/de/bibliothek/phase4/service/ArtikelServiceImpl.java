package de.bibliothek.phase4.service;

import de.bibliothek.phase4.persistence.Artikel;
import de.bibliothek.phase4.persistence.ArtikelRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ArtikelServiceImpl implements ArtikelService{

    final ArtikelRepository artikelRepository;

    public ArtikelServiceImpl(ArtikelRepository artikelRepository){
        this.artikelRepository = artikelRepository;
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

}
