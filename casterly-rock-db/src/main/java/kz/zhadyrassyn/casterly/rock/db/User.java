package kz.zhadyrassyn.casterly.rock.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Set<Role> roles;
}
