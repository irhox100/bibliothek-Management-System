package de.bibliothek.phase4.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Kunde")
@Getter
@Setter
public class Kunde {

    @Id
    private String email;
    @Column("Guthaben")
    private Double guthaben;
    @Column("Jahresbeitrag")
    private Boolean jahresbeitrag;
    @Column("AdresseID")
    private Integer adresseid;
}
