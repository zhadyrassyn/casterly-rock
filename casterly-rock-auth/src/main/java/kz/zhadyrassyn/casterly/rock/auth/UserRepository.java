package kz.zhadyrassyn.casterly.rock.auth;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepository {
    public Optional<User> findByEmail(String email) {
        User user = new User();
        user.setEmail("daniyar@test.com");
        user.setPassword("123");
        user.setFirstName("Daniyar");
        user.setLastName("Testbergen");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER"));

        user.setRoles(roles);
        return Optional.of(new User());
    }
}
