package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="health")
    private int health;

    @Column(name="strength")
    private int strength;

    @Column(name="level")
    private int level;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable( name="CHARACTER_ITEMS",
            joinColumns = {@JoinColumn(name="item_name"),
                        @JoinColumn(name="item_level")},
            inverseJoinColumns = @JoinColumn(name="character_id"))
    private List<Item> items = new ArrayList<>();

    public Character(String name, int health, int strength, int level){
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.level = level;
    }
}
