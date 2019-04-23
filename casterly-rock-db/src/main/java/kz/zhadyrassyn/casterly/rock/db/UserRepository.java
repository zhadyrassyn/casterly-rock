package kz.zhadyrassyn.casterly.rock.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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


    }

    //        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
////        Map<String, Object> map = new HashMap<>();
////        map.put("email", email);
////        map.put("password", password);
////        map.put("first_name", firstName);
////        map.put("last_name", lastName);
////        map.put("id", null);
//
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        String insertSQL = "INSERT INTO USERS(email, password, first_name, last_name) " +
//                "VALUES (?, ?, ?, ?)";
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection
//                    .prepareStatement(insertSQL);
//            ps.setString(1, email);
//            ps.setString(2, password);
//            ps.setString(3, firstName);
//            ps.setString(4, lastName);
//            return ps;
//        }, keyHolder);
//
//        Map<String, Object> keys = keyHolder.getKeys();
//
//        long insertedId = keyHolder;
//        String sql = "SELECT ID FROM ROLE WHERE NAME='USER'";
//        long roleId = jdbcTemplate.queryForObject(sql, Long.class);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("user_id", insertedId);
//        map.put("role_id", roleId);
//        simpleJdbcInsert
//                .withTableName("USERS_ROLE")
//                .execute(map);
}
