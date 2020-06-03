package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class LevelElementId implements Serializable {

    private String name;

    private int level;

    public LevelElementId(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
