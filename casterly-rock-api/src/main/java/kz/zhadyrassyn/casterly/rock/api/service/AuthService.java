package kz.zhadyrassyn.casterly.rock.api.service;

import kz.zhadyrassyn.casterly.rock.api.payload.SigninRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.SignupRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.TokenResponse;

public interface AuthService {
    TokenResponse signin(SigninRequest signinRequest);

    TokenResponse signup(SignupRequest signupRequest);
}
