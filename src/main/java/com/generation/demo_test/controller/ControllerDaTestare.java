package com.generation.demo_test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ControllerDaTestare 
{


    @GetMapping("/calcolobiglietto/{age}")
    public ResponseEntity<?> getMethodName(@PathVariable Integer age) 
    {
        if(age<0)
            return new ResponseEntity<String>("età non valida",HttpStatus.BAD_REQUEST);
        
        if(age<10)
            return new ResponseEntity<String>("Paghi 0",HttpStatus.OK);

        if(age<19)
            return new ResponseEntity<String>("Paghi 5",HttpStatus.OK);

        if(age<65)
            return new ResponseEntity<String>("Paghi 10",HttpStatus.OK);

        if(age<120)
            return new ResponseEntity<String>("Paghi 3",HttpStatus.OK);

        return new ResponseEntity<String>("We Matusa, non ci siamo",HttpStatus.NOT_ACCEPTABLE);
    }
    
    // I          S.C.              Body
    //<0           400              età non valida
    //<10          200              Paghi 0
    //<19          200              Paghi 5
    //<65          200              Paghi 10
    //<120         200              Paghi 3
    //120+         406              We Matusa, non ci siamo

}
