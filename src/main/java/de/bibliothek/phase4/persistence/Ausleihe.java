package de.bibliothek.phase4.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("Ausleihe")
public class Ausleihe {

    @Id
    private Long id;
    @Column("Beginn")
    private String beginn;
    @Column("Ende")
    private String ende;
    @Column("Zurueckgabe")
    private Boolean zurueckgabe;
    @Column("KundeEMail")
    private String kundeEMail;
    @Column("ExemplarID")
    private Long exemplarId;

    public Ausleihe(String beginn, String ende, Boolean zurueckgabe, String kundeEMail, Long exemplarId) {
        this.beginn = beginn;
        this.ende = ende;
        this.zurueckgabe = zurueckgabe;
        this.kundeEMail = kundeEMail;
        this.exemplarId = exemplarId;
    }
}
