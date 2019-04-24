package kz.zhadyrassyn.casterly.rock.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(String email,
                     String password,
                     String firstName,
                     String lastName) {
        SimpleJdbcInsert usersJdbInsert = new SimpleJdbcInsert(jdbcTemplate);
        Map<String, Object> mapValues = new HashMap<>();
        mapValues.put("email", email);
        mapValues.put("password", password);
        mapValues.put("first_name", firstName);
        mapValues.put("last_name", lastName);

        Number generatedUserId = usersJdbInsert
                .withTableName("users")
                .usingColumns("email", "password", "first_name", "last_name")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(mapValues);

        if (generatedUserId == null) {
            throw new RuntimeException("generatedUserId returns null after insert");
        }

        String roleQuery = "SELECT ID FROM ROLE WHERE NAME='USER'";
        Long roleId = jdbcTemplate.queryForObject(roleQuery, Long.class);

        mapValues.clear();
        mapValues.put("users_id", generatedUserId.longValue());
        mapValues.put("role_id", roleId);

        SimpleJdbcInsert usersRoleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        usersRoleJdbcInsert
                .withTableName("users_role")
                .usingColumns("users_id", "role_id")
                .usingGeneratedKeyColumns("id")
                .execute(mapValues);

    }

    public boolean isExists(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email=?";
        Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class, email);

        return cnt != null && cnt > 0;
    }
}
