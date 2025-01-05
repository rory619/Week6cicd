package ie.atu.week6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDetails>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        System.out.println("Validation error occurred: " + ex.getMessage());
        List<ErrorDetails> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {

            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.add(new ErrorDetails(fieldName, errorMessage));
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

