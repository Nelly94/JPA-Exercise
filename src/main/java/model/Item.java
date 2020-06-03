package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ITEM")
@Getter
@Setter
public class Item extends LevelElement{

    @Column(name="durability")
    private int durability;

    @Column(name="color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToMany(mappedBy = "items")
    private List<Character> characters = new ArrayList<>();

    public Item(String name, int level){
        super(name, level);
    }

    public Item(){

    }
}
