package com.encypher.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



//REST API
@RestController
public class HelloWordController {

    //  -> /hello-world
    @GetMapping( path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }



}

