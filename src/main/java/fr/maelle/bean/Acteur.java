package fr.maelle.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("A")
@Data
public class Acteur extends Personne implements Serializable {

    public Acteur() {
        super();
    }
}
