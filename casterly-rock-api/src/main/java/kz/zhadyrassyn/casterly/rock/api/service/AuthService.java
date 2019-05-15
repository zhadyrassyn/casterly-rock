package kz.zhadyrassyn.casterly.rock.api.service;

import kz.zhadyrassyn.casterly.rock.api.exception.UserAlreadyExistsException;
import kz.zhadyrassyn.casterly.rock.api.payload.SigninRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.SignupRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.TokenResponse;
import kz.zhadyrassyn.casterly.rock.common.error.BadCredentialsException;

public interface AuthService {
    TokenResponse signin(SigninRequest signinRequest) throws Exception;

    TokenResponse signup(SignupRequest signupRequest) throws UserAlreadyExistsException, BadCredentialsException;
}
