package kz.zhadyrassyn.casterly.rock.api.service.impl;

import kz.zhadyrassyn.casterly.rock.api.payload.SigninRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.SignupRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.TokenResponse;
import kz.zhadyrassyn.casterly.rock.api.service.AuthService;
import kz.zhadyrassyn.casterly.rock.auth.AuthenticationService;
import kz.zhadyrassyn.casterly.rock.auth.PasswordEncoderService;
import kz.zhadyrassyn.casterly.rock.db.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationService authenticationService;

    private PasswordEncoderService passwordEncoderService;

    private UserRepository userRepository;

    public AuthServiceImpl(
            AuthenticationService authenticationService,
            PasswordEncoderService passwordEncoderService,
            UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.passwordEncoderService = passwordEncoderService;
        this.userRepository = userRepository;
    }

    @Override
    public TokenResponse signin(SigninRequest signinRequest) {
        String jwtToken = authenticationService.authenticate(
                signinRequest.getEmail(),
                signinRequest.getPassword()
        );

        return new TokenResponse(jwtToken);
    }

    @Override
    public TokenResponse signup(SignupRequest signupRequest) {
        String encryptedPassword = passwordEncoderService.encode(signupRequest.getPassword());
        userRepository.save(
                signupRequest.getEmail(),
                encryptedPassword,
                signupRequest.getFirstName(),
                signupRequest.getLastName()
        );

        String jwtToken = authenticationService.authenticate(
                signupRequest.getEmail(),
                encryptedPassword
        );

        return new TokenResponse(jwtToken);

    }
}
