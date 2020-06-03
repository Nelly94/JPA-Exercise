package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
@IdClass(LevelElementId.class)
public abstract class LevelElement {

    @Id
    private String name;

    @Id
    private int level;

    public LevelElement(LevelElementId levelElementId){
        this.name = levelElementId.getName();
        this.level = levelElementId.getLevel();
    }

    public LevelElement(){

    }

}
