package de.bibliothek.phase4.persistence;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtikelRepository extends CrudRepository<Artikel, String> {

    @Override
    @Query("SELECT * FROM Artikel")
    List<Artikel> findAll();


    @Query("SELECT count(e.ISBNNummer) FROM Exemplar e, Artikel a WHERE e.ISBNNUMMER = a.ISBNNUMMER AND a.ISBNNUMMER = :isbn")
    Integer getExemplareCountForArtikel(@Param("isbn") String isbnnummer);

    @Query("SELECT g.Genre FROM Artikel a, GehoertZu g WHERE a.ISBNNummer = g.ISBNNummer AND a.ISBNNUMMER = :isbn")
    List<String> getGenresByArtikel(@Param("isbn") String isbnnummer);

}
