package kz.zhadyrassyn.casterly.rock.db;

import lombok.Data;

@Data
public class Role {

    private Long id;

    private String name;

    public Role() {}

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }
}
