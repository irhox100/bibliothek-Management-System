package de.bibliothek.phase4.service;

import de.bibliothek.phase4.persistence.Ausleihe;
import de.bibliothek.phase4.persistence.AusleiheRepository;

import java.util.List;

public class BibliothekarServiceImpl implements BibliothekarService{

    final AusleiheRepository ausleiheRepository;

    public BibliothekarServiceImpl(AusleiheRepository ausleiheRepository) {
        this.ausleiheRepository = ausleiheRepository;
    }


    @Override
    public List<Ausleihe> findAll() {
        return ausleiheRepository.findAll();
    }
}
