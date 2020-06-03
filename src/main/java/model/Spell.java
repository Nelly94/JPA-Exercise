package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SPELL")
@Getter
@Setter
public class Spell extends LevelElement {

    @Column(name="cost")
    private int cost;

    @Column(name="damage")
    private int damage;

    public Spell(LevelElementId levelElementId) {
        super(levelElementId);
    }
}
