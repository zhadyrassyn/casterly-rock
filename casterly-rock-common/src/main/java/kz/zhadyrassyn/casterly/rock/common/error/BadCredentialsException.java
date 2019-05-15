package kz.zhadyrassyn.casterly.rock.common.error;

public class BadCredentialsException extends Exception {
    public BadCredentialsException(String errorMessage) {
        super(errorMessage);
    }
}