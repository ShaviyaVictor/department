package com.shavic.department.controller;

import org.springframework.web.bind.annotation.*;

//  @Component --> is a stereotype annotation that defines SpringBoot classes as Components so that whenever the app runs the classes are added to the Spring container
//  Controllers however are not just any class, they are an app resource given they are the Presentational layer of the app container having the app's CRUD operations defined here in
//  @Controller --> a stereotype annotation that clearly defines a class as both a Controller given it has the @Component annotation in it and the Controller as the name suggests
//  @RestController --> defines a class as a Component since it contains the @Controller annotation within it which has @Component within it thus also defining the class as a Controller;
//                      and also has the @ResponseBody annotation within it, an annotation that allows the class to return Response Body objects in either JSON or XML formats
//  @RequestMapping --> maps requests from the client to the method annotated and can have params, such as,
//                      value - that assigns the endpoint url path and,
//                      method - defines the CRUD operation request from the client
//                  To avoid being verbose; @RequestMapping has some other more specific annotations:
//                  @GetMapping - for GET method and then you just define the endpoint path
//                  @PostMapping - for POST method
//                  @DeleteMapping - for DELETE method



@RestController
public class HelloWorld {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World Java!";
    }

}



//    Web Development architectural structure:
//    1. The Front End technologies will consume the API's to communicate with the DB
//    2. Then the Back End responsible for providing the API's
//         Spring Boot's REST API architecture:
//             1. Controller Layer      ===> this is the Presentational layer
//                                      ===> it basically handles the client requests and gives back responses through the CRUD; POST, GET, UPDATE, DELETE operations
//                                      ===> this is a Class
//             2. Service Layer     ===> this is the Business logic layer
//                                  ===> it contains the logic for our API's
//                                  ===> it basically implements the Repository/DAO layer to provide logic for how and what to do with the Data contained in the DataBase
//                                  ===> this is a Class
//             3. Data Access Object(DAO)       ===> this is the Repository layer or the Repository layer
//                                              ===> it is the Data Access Layer of our API since it is the layer that interacts with the DataBase
//                                              ===> this interface and allows us to work with the Spring Data JPA to work on our Entity
//             4. DataBase      ===> whwre our Data is stored
//                              ===> Spring Boot offers H2 in-memory DB which can later be switched to a real DB such as PostgreSQL or mySQL or MSSQL
//                              ===> Spring Boot provides us with a browser-based console that helps us interact with our H2 in-memory DB

