package kz.zhadyrassyn.casterly.rock.auth;

import lombok.Data;

@Data
public class Role {

    private Long id;

    private String name;

    public Role(String name) {
        this.name = name;
    }
}
