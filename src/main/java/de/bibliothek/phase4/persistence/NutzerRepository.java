package de.bibliothek.phase4.persistence;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NutzerRepository extends CrudRepository<Nutzer, String> {

    @Modifying
    @Query("INSERT INTO NUTZER(EMail, Geburtsdatum, Nachname, Vorname, Passwort) VALUES(:email, :datum, :nachname, :vorname, :passwort);")
    void createNutzer(@Param("email") String email,@Param("datum") String geburtsdatum,
                      @Param("nachname") String nachname, @Param("vorname") String vorname, @Param("passwort") String passwort);

    @Modifying
    @Query("INSERT INTO BIBLIOTHEKAR(EMail,Telefonnummer) VALUES(:email, :tel);")
    void createBibliothekar(@Param("email") String email, @Param("tel") String telelfonnummer);
}
