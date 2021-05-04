package de.bibliothek.phase4.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Getter
@Setter
@Table("Artikel")
public class Artikel {
    @Id
    private String isbnnummer;
    @Column("Erscheinungsdatum")
    private Date erscheinungsdatum;
    @Column("Beschreibung")
    private String beschreibung;
    @Column("Coverbild")
    private byte[] coverbild;
    @Column("Bezeichnung")
    private String bezeichnung;
    @Column("Medium")
    private String medium;


    public Artikel(String isbnnummer, Date erscheinungsdatum, String beschreibung, String bezeichnung, String medium) {
        this.isbnnummer = isbnnummer;
        this.erscheinungsdatum = erscheinungsdatum;
        this.beschreibung = beschreibung;
        this.bezeichnung = bezeichnung;
        this.medium = medium;
    }

}
