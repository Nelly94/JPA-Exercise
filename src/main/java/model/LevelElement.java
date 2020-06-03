package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class LevelElement {

    @EmbeddedId
    private LevelElementId id;

    public LevelElement(String name, int level){
        this.id = new LevelElementId(name, level);
    }

    public LevelElement(){

    }

}
