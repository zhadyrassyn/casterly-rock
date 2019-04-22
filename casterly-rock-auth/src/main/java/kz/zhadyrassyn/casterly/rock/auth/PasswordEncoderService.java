package kz.zhadyrassyn.casterly.rock.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PasswordEncoderService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encode(String text) {
        return passwordEncoder.encode(text);
    }
}
