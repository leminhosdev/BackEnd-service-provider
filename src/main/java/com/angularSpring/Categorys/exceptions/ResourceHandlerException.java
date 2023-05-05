package com.angularSpring.Categorys.exceptions;

import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceHandlerException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objNotFoundException(ObjectNotFoundException e, ServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandartError> integrityViolationException(DataIntegrityViolationException e, ServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErros> validationErros(MethodArgumentNotValidException e, ServletRequest request) {
        ValidationErros error = new ValidationErros(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação  dos campos");
        for(FieldError x : e.getBindingResult().getFieldErrors()){
                error.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
