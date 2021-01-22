package fr.maelle.filmotheque.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="TITRE",length = 50, nullable = false)
    private String titre;

    @Column(name="ANNEE")
    private int annee;

    @ManyToOne
    private Style style;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER, orphanRemoval = true)
    private Realisateur realisateur;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "FILM_ID")
    private List<Acteur> acteurs;

    @Column(name="DUREE")
    private int duree;

    @Column(name="VU")
    private Boolean vu;

    @Column(name="SYNOPSIS")
    private String synopsis;

    public Film() {
    }

    public Film(String titre, int annee, Style style, Realisateur realisateur, List<Acteur> acteurs, int duree,
                Boolean vu, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.style = style;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.duree = duree;
        this.vu = vu;
        this.synopsis = synopsis;
    }
}
