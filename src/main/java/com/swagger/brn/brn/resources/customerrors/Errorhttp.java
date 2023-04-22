package com.swagger.brn.brn.resources.customerrors;


import com.swagger.brn.brn.entities.Responseerror;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 *
 * Esta classe implementa ao spring um tratamento e resposta de erro http ao usuario
 * É disparada sempre que a app lança uma BussinesException
 * */

@ControllerAdvice
public class Errorhttp {

    @ExceptionHandler(BussinesException.class)
    public ResponseEntity<Responseerror> oops(BussinesException bussinesException, HttpServletRequest servletRequest){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Responseerror responseerror = new Responseerror(status.name(), status.value(), bussinesException.getMessage());
        return ResponseEntity.status(status).body(responseerror);

    }
}
