package com.todos.rest.webservices.restfulwebservices.Controller;

import com.todos.rest.webservices.restfulwebservices.Entity.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String hellowWorld(){
        return "Hello-Wolrd";
    }


    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean hellowWorldBean(){
        throw new RuntimeException("Some Error Has Occured ! contact global support");
       // return new HelloWorldBean("Hello Wolrd");
    }


    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
       return new HelloWorldBean(String.format("Hello World , %s",name));
    }
}
