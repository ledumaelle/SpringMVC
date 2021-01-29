package fr.maelle.bean;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotBlank
    private String titre;

    private int annee;

    @NotNull
    @ManyToOne
    private Style style;

    @OneToOne(cascade = CascadeType.ALL)
    private Realisateur realisateur;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Acteur> acteurs;

    private int duree;

    @NotNull
    private Boolean vu;

    private String synopsis;


    public Film() {
    }

    public Film(int id, @NotBlank String titre, int annee, @NotNull Style style, Realisateur realisateur, List<Acteur> acteurs, int duree, @NotNull Boolean vu, String synopsis) {
        this.id = id;
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
