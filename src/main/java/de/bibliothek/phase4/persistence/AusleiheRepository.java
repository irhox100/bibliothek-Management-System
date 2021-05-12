package de.bibliothek.phase4.persistence;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AusleiheRepository extends CrudRepository<Ausleihe, Long> {

    @Override
    @Query("SELECT * FROM Ausleihe")
    List<Ausleihe> findAll();
}
