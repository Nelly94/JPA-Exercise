package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ORC")
@NoArgsConstructor
@Getter
@Setter
public class Orc extends Character {

    @Column(name="rage")
    private String rage;

    public Orc(String name, int health, int strength, int level) {
        super(name, health, strength, level);
    }
}
