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

    @Modifying
    @Query("INSERT INTO Kunde(EMail, Guthaben, Jahresbeitrag, AdresseID) VALUES(:email, :guthaben, :beitrag, " +
            "SELECT ID FROM Adresse WHERE Stadt = :stadt AND Postleitzahl = :plz AND Strasse = :strasse AND Hausnummer = :hausnummer) ")
    void createKunde(@Param("email") String email, @Param("guthaben") Double guthaben, @Param("beitrag") Boolean beitragsbefreit,
                     @Param("stadt") String stadt, @Param("plz") Integer plz, @Param("strasse") String strasse, @Param("hausnummer") Integer hausnummer);

    @Modifying
    @Query("INSERT INTO Adresse(Stadt, Postleitzahl, Strasse, Hausnummer) VALUES(:stadt, :plz, :strasse, :hausnummer)")
    void createAdresse(@Param("stadt") String stadt, @Param("plz") Integer plz, @Param("strasse") String strasse,
                       @Param("hausnummer") Integer hausnummer);

    @Query("SELECT CASE WHEN count(*) > 0 THEN true ELSE false END FROM Nutzer n, Kunde k WHERE n.EMAIL = :email AND n.EMAIL = k.EMAIL")
    Boolean isNutzerKunde(@Param("email") String email);

    @Query("SELECT CASE WHEN count(*) > 0 THEN true ELSE false END FROM Nutzer n, Bibliothekar b WHERE n.EMAIL = :email AND n.EMAIL = b.EMAIL")
    Boolean isNutzerBibliothekar(@Param("email") String email);

}
