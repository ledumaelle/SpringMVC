package fr.maelle.filmotheque.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("P")
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "NOM", length = 50, nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 50, nullable = false)
    private String prenom;

}
