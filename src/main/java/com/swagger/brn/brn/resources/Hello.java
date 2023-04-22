package com.swagger.brn.brn.resources;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hello {

    @Hidden //Diz ao swagger para nao mostrar este endpoint
    @GetMapping
    public ResponseEntity<String> helloWord(){
        return  ResponseEntity.ok().body("Voce esta na home Page");
    }

}
