package kz.zhadyrassyn.casterly.rock.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.nio.file.AccessDeniedException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthRepository {

    private JdbcTemplate jdbcTemplate;


    public AuthRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<User> signin(String email) {
        String sql = "SELECT * FROM USERS WHERE email=?";
        User retrievedUser = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setPassword(rs.getString("password"));
            return user;
        }, email);

        if (retrievedUser == null) {
            return Optional.empty();
        }

        String roleSql = "SELECT r.id, r.name FROM USERS_ROLE as ur INNER JOIN ROLE as r ON ur.role_id=r.id WHERE users_id=?";
        List<Role> userRoles = jdbcTemplate.query(roleSql, (rs, rowNum) -> {
            Role role = new Role();
            role.setId(rs.getLong("id"));
            role.setName(rs.getString("name"));
            return role;
        }, retrievedUser.getId());

        retrievedUser.setRoles(new HashSet<>(userRoles));

        return Optional.of(retrievedUser);
    }
}
