package com.project.modulo4.config;


import com.project.modulo4.models.dao.ErrorDTO;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedList;
import java.util.List;

@RestControllerAdvice
public class ExceptionAdvice {

    //Se ejecuta cuando se detectan errores de validacion, EXCEPCIONES DE TIPO MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO validationErrors(MethodArgumentNotValidException exception) {
       List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
       List<String> errors = new LinkedList<>();
       for (FieldError fieldError : fieldErrors){
           errors.add(fieldError.getDefaultMessage());
       }
        return new ErrorDTO("007", "Hubo un error al validar los datos de entrada", errors);
    }

    @ExceptionHandler(Exception.class)
    public ErrorDTO unKonowError(Exception exception){
        //log.error(exception.getMessage());
        return new ErrorDTO("500","desconocido",null);
    }
}


