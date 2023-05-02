package com.shavic.department.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//  @Component --> is a stereotype annotation that defines SpringBoot classes as Components so that whenever the app runs the classes are added to the Spring container
//  Controllers however are not just any class, they are an app resource given they are the Presentational layer of the app container the apps CRUD operations defined here in
//  @Controller --> a stereotype annotation that clearly defines a class as both a Controller hence has the @Component annotation in it and also defines a class as a Controller
//  @RestController --> defines a class as a Component since it contains the @Controller annotation within it which has @Component within it thus in turn also defining the class as a Controller;
//                      and also has the @ResponseBody annotation within it, an annotation that allows the class to return Response Body objects in either JSOn or XML formats
//  @RequestMapping --> maps requests from the client to the method annotated and can have params, such as,
//                      value - that assigns the endpoint url path and,
//                      method - defines the CRUD operation request from the client

@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World Java!";
    }

}
