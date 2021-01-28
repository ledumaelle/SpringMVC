package fr.maelle.bean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotBlank
    @Column(name="TITRE",length = 50, nullable = false)
    private String titre;

    @Column(name="ANNEE")
    private int annee;

    @NotNull
    @ManyToOne
    private Style style;

    @Null
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER, orphanRemoval = true)
    private Realisateur realisateur;

    @Null
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "FILM_ID")
    private List<Acteur> acteurs;

    @Column(name="DUREE")
    private int duree;

    @NotNull
    @Column(name="VU")
    private Boolean vu;

    @Null
    @Column(name="SYNOPSIS")
    private String synopsis;
}
