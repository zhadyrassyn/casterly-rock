package kz.zhadyrassyn.casterly.rock.api.controller;

import kz.zhadyrassyn.casterly.rock.api.exception.UserAlreadyExistsException;
import kz.zhadyrassyn.casterly.rock.api.payload.SigninRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.SignupRequest;
import kz.zhadyrassyn.casterly.rock.api.payload.TokenResponse;
import kz.zhadyrassyn.casterly.rock.api.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public TokenResponse signin(@RequestBody SigninRequest requestBody) {
        return authService.signin(requestBody);
    }


    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody SignupRequest requestBody) throws UserAlreadyExistsException { return authService.signup(requestBody); }
}
