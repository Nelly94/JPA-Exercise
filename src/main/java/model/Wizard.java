package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="WIZARD")
@NoArgsConstructor
@Getter
@Setter
public class Wizard extends Character {

    @Column(name="magic")
    private String magic;

    public Wizard(String name, int health, int strength, int level) {
        super(name, health, strength, level);
    }
}
