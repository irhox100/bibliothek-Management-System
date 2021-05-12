package de.bibliothek.phase4.service;

import de.bibliothek.phase4.persistence.Ausleihe;

import java.util.List;

public interface BibliothekarService {

    List<Ausleihe> findAll();
}
