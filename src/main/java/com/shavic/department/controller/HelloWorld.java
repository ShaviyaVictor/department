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


//      https://stackoverflow.com/questions/13715811/requestparam-vs-pathvariable
//  @PathVariable() --> annotation used to identify the patter that is used in the URI for the incoming request
//                 --> annotation used to obtain some placeholder from the URI
//  @RequestParam() --> annotation used for accessing the query parameter values from the request
//                 --> annotation used to obtain a parameter from the URI



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
//    ***   Controller Layer Flow
//  Create the saveDepartment method with the @RequestBody annotation referencing to the Created Entity;
//  @PostMapping() annotation is used with the path parameter defined inside the parenthesis
//  In the same Controller, Inject the Service Layer Impl class that communicates with the DAO;
//  Then return the newly created ServiceImpl Class calling the saveDepartment method which takes in the Class-level created Entity.
//    ***   Service Layer Flow
//  Create saveDepartment method in the Service Layer Interface which will be implemented in the ServiceImpl Class;
//  In the ServiceImpl Class, create the same saveDepartment method that takes in the Department Entity,
//  and it will be an @Override annotated method;
//  Then Autowire the Repository Class which will connect us to the DB and allow us to use JPA methods;
//  Then return the newly created/referenced Repository class calling JPA save methods that takes in the class-referenced department Entity.



//    Design Flow for the fetchDepartment GET All Departments API call
//    ***   Controller Layer Flow
//  Create the fetchDepartment method which fetches the Data available in the Entity as a List<> that takes in the Department Entity;
//  @GetMapping() annotation is used with the path parameter defined inside the parenthesis
//  fetchDepartment() will not take in any input since we are fetching Data from the Entity
//  The Service Layer Impl class that communicates with the DAO is already injected;
//  Then return the newly created ServiceImpl Class calling the fetchDepartment method which does not take in any input.
//    ***   Service Layer Flow
//  Create fetchDepartment method in the Service Layer Interface which will be implemented in the ServiceImpl Class;
//  In the ServiceImpl Class, create the same fetchDepartment method which fetches the Data available in the Entity as a List<> that takes in the Department Entity,
//  and it will be an @Override annotated method;
//  The Repository Class is already Autowired to connect us to the DB and allow us to use JPA methods;
//  Then return the newly created/referenced Repository class calling JPA findAll method that does not take in any input since we are fetching Data.



//    Design Flow for the fetchDepartment GET By ID API call
//    ***   Controller Layer Flow
//  Create the fetchDepartmentById method which will make the Request
//  This method will take in the @GetMapping() ...
//      which takes in the url path that ends with a pathVariable call for the particular Entity property needed; @GetMapping("/departments/{id}"
//  In our case we'll request for the data present in the specified Id declared in the URL path
//  The method itself will not take in List but will Call the Department Entity since we just want a particular set of Data for the specified ID: public Department fetch...()
//  The method now will Define the Entity being used as the Primary Key, which in this case is the ID: Long departmentId which will be taken in as an input
//  Then before the Entity Definition in the method input, add the @PathVariable("id") annotation that takes in the value put in the @GetMapping URL path
//      to enable the communication and Binding/linkage of the Variable defined in the path as well as with the Entity Type and Identity defined as the method Input
//  Then finally call the return method to return the Autowired Service Interface then calls the created method which takes in the Entity property Identity as an input
//    ***   Service Layer Flow
//  Then create the method in the ServiceInterface which takes in the defined Entity property
//  Again create the method in the ServiceImpl class to implement the GetMethod request coming from the Presentational layer
//  Here in the ServiceImpl class, the return method calls the DAO method that has been Autowired
//      which then calls the JPA method findById() and takes in the defined Entity property
//  Then the get() method is called: findById(departmentId).get()



//    Design Flow for the deleteById DELETE By ID API call
//    ***   Controller Layer Flow
//  Create the deleteById() method/function which is to make the API request
//  This method is to take the @DeleteMapping() annotation ...
//      which takes in the basic same URL path just as the GetById URL path which ends with a pathVariable call for the particular Entity property needed; @DeleteMapping("/departments/{id}"
//  In this case, the data that will be deleted will be the data present in the specified Id declared in the URL path
//  The method creation itself won't have the DAO defined on it since we are not returning an Object after the call but instead we'll be deleting an Object after the request is actioned
//  The method in this case will have a String definition which will help us define the message to be printed for us once the API request has been actioned successfully;
//  The method then will take in the @PathVariable() annotation that takes in the value defined in the Mapping annotation
//      and after the PathVariable definition the Entity defined as the Primary Key is defined with its Type
//  Then call the Service Interface that was Autowired which then calls the just created method taking in the Entity property as an input: departmentService.deleteById(departmentId)
//  Then return a String statement that will be printed on the REST client(Postman) after a successful actioning of the API call
//    ***   Service Layer Flow
//  Then create a Void method in the Service Interface with the deleteById() that takes in the Entity property type and definition
//  Then create another method in the ServiceImpl class that implements the void method created in the Interface;
//  This will be an @Override method that will be public and void meaning it won't return any value after it's actioning and;
//      thus the request actioning shall be to call our DAO, departmentRepository that will call a JPA method deleteById(departmentId) which takes in the Entity property definition



//    Design Flow for the updateDepartment UPDATE By ID API call
//    ***   Controller Layer Flow
//  Create the updateDepartment method which is to make the API request
//  This method is to take the @PutMapping annotation ...
//      which is to take in the URL path with the {id} path variable for updating the particular declared Id
//  Thus, in this case, the data that will be updated will be the data present in the specified Id declared in the URL path
//  This method creation will have the Department Entity declaration since some data will be outputted after an update is made to the specified Entity by Id;
//      then the method updateDepartment() will take in 2 input parameters;
//          the @PathVariable("Id") which links the declared Id in the URL path and also defines the Primary Key to which to check for updating
//          then @RequestBody annotation which defines the Entity Body to which the changes are to be matched against and updated
//          Thus updateDepartment(@PathVariable("id") Long departmentId,
//                                  @RequestBody Department department)
//  Then the method will return the Service Interface calling the method which takes in both the Defined Primary Key Entity Property as well as the department Entity Object
//    ***   Service Layer Flow
//  Then create the method call in the Service Interface for implementation
//  The ServiceImpl Class in implementing the Service Interface shall include a logic to check if the Entity Properties are either NotNull or not blank and the casing is the same, nothing unchanged,
//      if this check passes, then that particular Property is skipped without being changed thus retaining it's initial value;
//      but if either of the checks is not passed, then the newly detected value is set on the particular Entity Property for the defined id



//    Design Flow for the fetchDepartment GET Department By Name API call
//    ***   Controller Layer Flow
//  Create the fetchDepartmentByName method which will make the Request
//  This method will take in the @GetMapping() ...
//      which takes in the url path that ends with a pathVariable call for the particular Entity property needed; @GetMapping("/departments/{name}"
//  In our case we'll request for the data present with the specified name declared in the URL path
//  The method itself will not take in List but will Call the Department Entity since we just want a particular set of Data for the specified name: public Department fetch...()
//  The method now will Define the Entity being used as the Point of Reference for binding with the Entity Type and Identifier defined, which in this case is the name: String departmentName which will be taken in as an input
//  Then before the Entity Definition in the method input, add the @PathVariable("name") annotation that takes in the value put in the @GetMapping URL path
//      to enable the communication and Binding/linkage of the Variable defined in the path as well as with the Entity Property Type and Identity defined as the method Input
//  Then finally call the return method to return the Autowired Service Interface then calls the created method which takes in the Entity property Identity as an input
//    ***   Service Layer Flow
//  Then create the method in the ServiceInterface which takes in the defined Entity property
//  Again create the method in the ServiceImpl class to implement the GetMethod request coming from the Presentational layer
//  Here in the ServiceImpl class, the return method calls the DAO method that has been Autowired
//      which then is to call a default JPA method findByName() and takes in the defined Entity property, but since the default method is not there,
//      we custom create a fetchByDepartmentName() method in the DAO layer that the Service Impl Class will call
//  The naming convention of fetchByDepartmentName() method is key in that it should match the Entity Property Identity that is to be called;
//      and then take in the Entity Property Type and Identity as Input Parameters
//  Then get back to the ServiceImpl Class and call the custom method created in the DAO through the Autowired DAO
