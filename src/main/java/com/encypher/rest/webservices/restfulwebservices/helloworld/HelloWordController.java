package com.encypher.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



//REST API
@RestController
public class HelloWordController {

    //  -> /hello-world
    @GetMapping( path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping( path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World") ;
    }

    @GetMapping( path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorlPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World " + name) ;
    }




}

