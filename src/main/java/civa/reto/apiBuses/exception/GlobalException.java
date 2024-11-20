package civa.reto.apiBuses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ErrorMessages> handleResourceNotFound(NotFound ex) {
        ErrorMessages errorMessages = new ErrorMessages(ex.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.NOT_FOUND);
    }
}
