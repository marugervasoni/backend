package com.clinica.integrador2;

import org.apache.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> todosErrores(Exception ex, WebRequest req){

        //si se prod error que lo loggee, y lo imprima devolviendo status http
        logger.error(ex.getMessage());
        return new ResponseEntity("Error "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
