package kz.zhadyrassyn.casterly.rock.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
