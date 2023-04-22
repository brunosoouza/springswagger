package com.swagger.brn.brn.resources.customerrors;


import org.springframework.http.HttpStatus;

/*
*  Classe extendendo RunimeException disparar erros e criar respostas http customizadas
*
* */
public class BussinesException extends RuntimeException{

    private HttpStatus status; //Recebe um status das classes resources para enviar como resposta ao usuario;

    public HttpStatus getStatus() {
        return status;
    }

    public BussinesException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
