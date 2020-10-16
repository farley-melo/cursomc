package com.farleydeftones.cursomc.endPoints.exceptions;


import com.farleydeftones.cursomc.services.exceptions.ObjectNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNaoEncontradoException.class)
    public ResponseEntity<StandardError>categoriaNaoEncotradaHandler(ObjectNaoEncontradoException e, HttpServletRequest s){
        StandardError standardError=new StandardError(e.getMessage(),HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}
