package kz.zhadyrassyn.casterly.rock.api.service.impl;

import kz.zhadyrassyn.casterly.rock.api.payload.SigninRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.TokenResponse;
import kz.zhadyrassyn.casterly.rock.api.service.AuthService;
import kz.zhadyrassyn.casterly.rock.auth.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationService authenticationService;

    public AuthServiceImpl(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public TokenResponse signin(SigninRequest signinRequest) {
        String jwtToken = authenticationService.authenticate(
                signinRequest.getEmail(),
                signinRequest.getPassword()
        );

        return new TokenResponse(jwtToken);
    }
}
