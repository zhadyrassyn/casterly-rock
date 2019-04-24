package kz.alfabank.partner.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerError(Exception ex) {
        log.error(ex.getMessage(), ex);

        String errorMessage = HttpStatus.INTERNAL_SERVER_ERROR.toString();
        ApiError jsonError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, ex);
        return buildResponseEntity(jsonError);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
        log.error(ex.getMessage(), ex);

        ApiError jsonError = new ApiError(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex);
        return buildResponseEntity(jsonError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
