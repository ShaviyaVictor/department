package com.shavic.department.controller;

import org.springframework.web.bind.annotation.*;

//    Controller
//  @Component --> is a generic stereotype annotation that defines SpringBoot classes as Components so that whenever the app runs the classes are added to the Spring container
//  @Controller, @Service and @Repository annotations are specializations of @Component annotation.
//  Check here:--> https://stackoverflow.com/questions/6827752/whats-the-difference-between-component-repository-service-annotations-in
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

//  @RequestBody --> annotation that tells Spring Boot to get whwtever JSON Data it is getting and convert it into the declared Object


//    Entity
//  @Entity --> is a persistence API interface that enables our Entity to interact with the DB
//  @Id --> annotation that indicates the member field below is the primary key of current entity, inherited from javax.persistence.Id，
//      --> placed on top of the property that is to be used as the Primary key
//  @GeneratedValue --> annotation that configures the way of increment of the specified column(field).
//                  --> contains a strategy as a parameter defining how the primary key should be generated


//    Service
//  @Service --> stereotype annotation for the Service/Business layer


//    Repository
//  @Repository --> stereotype annotation for the Persistence layer; the Data Access Object


//  @Autowired --> annotation that tells Spring Boot to Autowire the defined Object and create it and attach it to the particular reference created
//              hence allowing the use of Dependency Injection and Inversion Control of Spring's functionality feature



@RestController
public class HelloWorld {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World Java!";
    }

}



//    Web Development architectural structure:
//    1. The Front End technologies will consume the APIs to communicate with the DB
//    2. Then the Back End responsible for providing the APIs
//         Spring Boot's REST API architecture:
//             1. Controller Layer      ===> this is the Presentational layer
//                                      ===> it basically handles the client requests and gives back responses through the CRUD; POST, GET, UPDATE, DELETE operations
//                                      ===> this is a Class
//             2. Service Layer     ===> this is the Business logic layer
//                                  ===> it contains the logic for our APIs
//                                  ===> it basically implements the Repository/DAO layer to provide logic for how and what to do with the Data contained in the DataBase
//                                  ===> this is a Class
//             3. Data Access Object(DAO)       ===> this is the Repository layer or the Repository layer or the Persistence layer
//                                              ===> it is the Data Access Layer of our API since it is the layer that interacts with the DataBase
//                                              ===> this interface and allows us to work with the Spring Data JPA to work on our Entity
//             4. DataBase      ===> where our Data is stored
//                              ===> Spring Boot offers H2 in-memory DB which can later be switched to a real DB such as PostgreSQL or mySQL or MSSQL
//                              ===> Spring Boot provides us with a browser-based console that helps us interact with our H2 in-memory DB

//  Entity
//    A default Model can be equated to an Entity in Spring Boot
//    The Entity contains: * properties defining our table columns
//                          * Getters and Setters
//                          * main Constructor and a default Constructor
//                          * toString() method to call the properties for printing on the console
//                          * @Entity annotation

//  Controller
//    Create the EntityController Class where the RESTful APIs will be created';
//    and annotate it with the @RestController annotation
//    After creating the Controller, you call the Service Layer which will pass the logic to the DAO

//  Service
//    The convention is Creating an Interface for our service and then create the Class Implementing the service;
//    given a Service can have several Implementations - thus create an Interface then create the class implementing that Service Interface
//    Thus the Interface in the Service package and then create the Impl package that'll contain the Impl Classes for the Interfaces.
//    This Interface doesn't have to have the @Interface annotation, but the ServiceImpl Class must have the @Service annotation


//    Repository
//  The Repository Class must have the @Repository annotation.
//  JpaRepository will be extended for this project which will take in 2 properties;
//      1st one will be the Entity defining our DB Properties, then the
//      2nd one will be the Type for the Entity Property being used as the Primary Key
//  JpaRepository gives us a lot of methods that we can use directly for interacting our Entity with the DB



//    Design Flow for the saveDepartment POST API call
//    Controller Layer Flow
//  Create the saveDepartment method with the @RequestBody annotation referencing to the Created Entity;
//  @PostMapping() annotation is used with the path parameter defined inside the parenthesis
//  In the same Controller, Inject the Service Layer Impl class that communicates with the DAO;
//  Then return the newly created ServiceImpl Class calling the saveDepartment method which takes in the Class-level created Entity.
//    Service Layer Flow
//  Create saveDepartment method in the Service Layer Interface which will be implemented in the ServiceImpl Class;
//  In the ServiceImpl Class, create the same saveDepartment method that takes in the Department Entity,
//  and it will be an @Override annotated method;
//  Then Autowire the Repository Class which will connect us to the DB and allow us to use JPA methods;
//  Then return the newly created/referenced Repository class calling JPA save methods that takes in the class-referenced department Entity.



//    Design Flow for the fetchDepartment GET API call
//    Controller Layer Flow
//  Create the fetchDepartment method which fetches the Data available in the Entity as a List<> that takes in the Department Entity;
//  @GetMapping() annotation is used with the path parameter defined inside the parenthesis
//  fetchDepartment() will not take in any input since we are fetching Data from the Entity
//  The Service Layer Impl class that communicates with the DAO is already injected;
//  Then return the newly created ServiceImpl Class calling the fetchDepartment method which does not take in any input.
//    Service Layer Flow
//  Create fetchDepartment method in the Service Layer Interface which will be implemented in the ServiceImpl Class;
//  In the ServiceImpl Class, create the same fetchDepartment method which fetches the Data available in the Entity as a List<> that takes in the Department Entity,
//  and it will be an @Override annotated method;
//  The Repository Class is already Autowired to connect us to the DB and allow us to use JPA methods;
//  Then return the newly created/referenced Repository class calling JPA findAll method that does not take in any input since we are fetching Data.



//    Design Flow for the fetchDepartment GET API call
//    Controller Layer Flow
//  Create the fetchDepartmentById method which will make the Request
//  This method will take in the @GetMapping() ...
//  which takes in the url path that ends with a pathVariable call for the particular Entity property needed @GetMapping("/departments/{id}"
//  In our case we'll request for the data present in the specified Id declared in the URL path
//  The method itself will not take in List but will Call the Department Entity since we just want a particular set of Data for the specified ID: public Department fetch...()
//  The method now will Define the Entity being used as the Primary Key, which in this case is the ID: Long departmentId which will be taken in as an input
//  Then before the Entity Definition in the method input, add the @PathVariable("id") annotation that takes in the value put in the @GetMapping pathVariable
//      to enhance the communication and linkage of the pathVariable
//  Then finally call the return method to return the Autowired Service Interface then calls the created method which takes in the Entity property call as an input
//    Service Layer Flow
//




