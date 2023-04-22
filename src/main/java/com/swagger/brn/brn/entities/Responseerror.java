package com.swagger.brn.brn.entities;

import java.util.Date;

//Classe responsavel por prover a estrutura de como os erros criados serão enviados para o usuario
public class Responseerror {
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }

    private String status;
    private int statusCode;
    private String error;

    public Responseerror() {
    }

    public Responseerror(String status, int statusCode, String error) {
        this.status = status;
        this.statusCode = statusCode;
        this.error = error;
    }
}
