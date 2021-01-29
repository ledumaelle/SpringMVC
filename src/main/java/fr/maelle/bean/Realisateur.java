package fr.maelle.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue("R")
public class Realisateur extends Personne implements Serializable {

    public Realisateur() {
        super();
    }
}
