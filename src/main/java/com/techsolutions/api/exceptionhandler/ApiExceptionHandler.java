package com.techsolutions.api.exceptionhandler;

import com.techsolutions.domain.exception.EntidadeNaoEncontradaException;
import com.techsolutions.domain.exception.NegocioException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<Problema.Campo> campos = new ArrayList<>();

        for(ObjectError error: ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();
            campos.add(new Problema.Campo(nome, mensagem));

        }

        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo("Um ou mais campos inválidos. Refaça o preenchimento.");
        problema.setCampos(campos);
        return handleExceptionInternal(ex,problema, headers, status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;

        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex,problema,new HttpHeaders(),status,request);

    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException ex, WebRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex,problema,new HttpHeaders(),status,request);

    }
}
