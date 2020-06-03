package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class LevelElementId implements Serializable {

    private String name;

    private int level;

    public LevelElementId(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
