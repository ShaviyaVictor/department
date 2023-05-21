package com.shavic.department.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 ***
 **
 *
    Controller

  @Component --> is a generic stereotype annotation that defines SpringBoot classes as Components so that whenever the app runs the classes are added to the Spring container
  @Controller/@RestController, @Service and @Repository annotations are specializations of @Component annotation.
      Check here:--> https://stackoverflow.com/questions/6827752/whats-the-difference-between-component-repository-service-annotations-in
  Controllers however are not just any class, they are an app resource given they are the Presentational layer of the app container having the app's CRUD operations defined there in
  @Controller --> a stereotype annotation that clearly defines a class as both a Controller & a Component given it has the @Component annotation in it and the Controller as the name suggests
  @RestController --> also defines a class as both a Controller & a Component since it contains the @Controller annotation within it which has @Component within it thus also defining the class as a Controller;
                      and also has the @ResponseBody annotation within it, an annotation that allows the class to return Response Body objects in either JSON or XML formats
  @RequestMapping --> maps requests from the client to the method annotated and can have params, such as,
                      value - that assigns the endpoint URL path as a String and,
                      method - defines the CRUD operation request from the client as a RequestMethod call
                  To avoid being verbose; @RequestMapping has some other more specific annotations:
                  @GetMapping - for GET methods and then you just define the endpoint path
                  @PostMapping - for POST methods
                  @DeleteMapping - for DELETE methods
                  @PutMapping - for UPDATE methods

  @RequestBody --> annotation that tells Spring Boot to take whatever JSON Data it is getting and convert it into the declared Object;
               --> mainly used in methods that send back Data to the DB i.e in @PostMapping & @PutMapping annotated methods

  https://stackoverflow.com/questions/13715811/requestparam-vs-pathvariable
 @PathVariable() --> annotation used to identify the pattern that is used in the URI for a request being actioned per a certain criteria
 --> annotation used to obtain some placeholder from the URI
 @RequestParam() --> annotation used for accessing the query parameter values from the request
 --> annotation used to obtain a parameter from the URI



    Entity

  @Entity --> is a persistence API interface that enables our defined Entity Object to interact with the DB
  @Id --> annotation that indicates the member field below is the primary key of current entity, inherited from javax.persistence.Id，
      --> placed on top of the property that is to be used as the Primary key
  @GeneratedValue --> annotation that configures the way of increment of the specified column(field).
                  --> contains a strategy as a parameter defining how the primary key should be generated using the GenerationType call



    Service

  @Service --> stereotype annotation for the Service/Business logic layer



    Repository

  @Repository --> stereotype annotation for the Persistence layer; the Data Access Object(DAO)


  @Autowired --> annotation that tells Spring Boot to Autowire the defined Object and create it and attach it to the particular reference created
              hence allowing the use of Dependency Injection and Inversion Control of Spring's functionality feature
                  Check here:--> https://www.baeldung.com/spring-autowire
              --> when Autowiring a class that is Implementing an Interface that is being Implemented more than once by different classes;
              Spring will throw a NoUniqueBeanDefinitionException exception. This is avoided by narrowing the Implementation using a @Qualifier annotation
                  Check here:--> https://stackoverflow.com/questions/40830548/spring-autowired-and-qualifier#:~:text=The%20%40Qualifier%20annotation%20is%20used,constructor%20arguments%20or%20method%20parameters.
  @Qualifier --> annotation used to resolve the autowiring conflict, when there are multiple beans of the same type



    HIBERNATE VALIDATIONS

  https://www.geeksforgeeks.org/spring-boot-validation-using-hibernate-validator/
  https://stackoverflow.com/questions/17137307/in-hibernate-validator-4-1-what-is-the-difference-between-notnull-notempty

 @NotNull --> The CharSequence, Collection, Map or Array object is NOT Null, BUT can be Empty
  @NotEmpty --> The CharSequence, Collection, Map or Array object is NOT Null nor Empty meaning the size > 0; even if it is Blank
  @NotBlank --> The String is NOT Null, NOT Empty, NOT Blank and thus the trimmed length is greater than 0.
  See Below examples
        String name = null;
@NotNull: false
@NotEmpty: false
@NotBlank: false

        String name = "";
@NotNull: true
@NotEmpty: false
@NotBlank: false

        String name = " ";
@NotNull: true
@NotEmpty: true
@NotBlank: false

        String name = "Great answer!";
@NotNull: true
@NotEmpty: true
@NotBlank: true



    PROJECT LOMBOK

 https://projectlombok.org/features/Data#:~:text=%40Data%20is%20a%20convenient%20shortcut,beans%3A%20getters%20for%20all%20fields%2C

 @Data --> is a Lombok convenient shortcut annotation that bundles the features of @Getter; @Setter; @ToString; @EqualsAndHashCode and @RequiredArgsConstructor annotations all together in one annotation
       --> this annotation basically generates all the boilerplate code that is normally associated with simple Plain Old Java Objects(POJOs) and beans;
            --> generating setters for all fields
            --> generating setters for all non-final fields
            --> generating all appropriate toString, equals and hashCode implementations that involve the fields of the class
            --> generating a Constructor that initializes all final fields, as well as non-final fields with no initializer that have been marked with @NonNull, in order to ensure the fields are never null.

 https://stackoverflow.com/questions/68314072/why-to-use-allargsconstructor-and-noargsconstructor-together-over-an-entity

 @ALlArgsConstructor --> generates a constructor requiring an argument for every field in the annotated class
                     --> it also allows the creation of static factory methods using the staticName attribute
 @NoArgsConstructor --> generates a default constructor with no parameters
                    --> it can create a static factory method for construction purposes
 Lombok can't call the super constructor unless it has a no-args constructor
 And the JPA specification requires that all persistent classes(Entity) have a no-arg constructor, either public or protected





 *
 **
 ***
 **/



@RestController
public class HelloWorld {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World Java!";
    }

}



/***
 **
 *
    Web Development architectural structure:
    1. Then the Back End team is responsible for creating the APIs
    2. The Front End technologies will consume the APIs to communicate with the DB

         Spring Boot's REST API architecture:
             1. Controller Layer      ===> this is the Presentational layer
                                      ===> it basically handles the client requests and gives back responses through the CRUD; POST, GET, UPDATE, DELETE operations
                                      ===> it passes its methods to the Service layer through the Autowired Service Interface
                                      ===> this is a Java Class
             2. Service Layer     ===> this is the Business logic layer
                                  ===> it contains the logic for our APIs
                                  ===> the layer as general will have an Interface and an Implementation class for the Interface
                                  ===> the Interface layer takes in the client request methods created in the Controller layer
                                  ===> the Implementation layer then Implements the methods defined in its Interface with added business logic and then calling the Autowired DAO layer for actioning in the DB
                                  ===> this comprises an Interface and a Java Impl Class that implements the Interface
             3. Repository layer       ===> this is the Data Access Object(DAO) layer or the Persistence layer
                                       ===> it is the Data Access Layer of our API since it is the layer that interacts with the DataBase
                                       ===> it extends JpaRepository interface that takes in the Entity/Bean Object defining our DB and the Entity property Type defined as our Primary Key for the DB
                                       ===> this is an Interface and thus allows us to work with the Spring Data JPA through extending it
             4. DataBase      ===> where our Data is stored
                              ===> Spring Boot offers H2 in-memory DB which can later be switched to a real DB such as PostgreSQL or mySQL or MSSQL
                              ===> Spring Boot h2 dependency provides us with a browser-based console that helps us interact with our H2 in-memory DB

  Entity
    A default Model can be equated to an Entity in Spring Boot
    The Entity contains: * properties defining our table columns
                          * Getters and Setters
                          * main Constructor and a default Constructor
                          * toString() method to call the properties for printing on the console
                          * @Entity annotation

  Controller
    Create the EntityController Class where the RESTful APIs will be created';
      and annotate it with the @RestController annotation
    After creating the Controller, you call the Service Layer Interface which will pass the methods created to the Service Implementation class for Implementation

  Service
    The convention is Creating an Interface for our service and then create the Class Implementing the service interface;
      given an Interface can have several Implementations in different classes -  create an Interface then create the class implementing that Service Interface
    Thus the Interface in the Service package and then create the Impl package that'll contain the Impl Classes for the Interfaces.
    This Interface shouldn't have the @Repository annotation, but the ServiceImpl Class must have the @Service annotation


    Repository
  The Repository Class must have the @Repository annotation.
  JpaRepository will be extended for this project which will take in 2 properties;
      1st one will be the Entity defining our DB Properties, then the
      2nd one will be the Type for the Entity Property being used as the Primary Key, having the @Id annotation
  JpaRepository gives us several commonly used built-in methods that we can use directly for interacting our Entity with the DB eg. findAll(), findById(),


  In the created Controller, Inject the Service Layer Interface that will pass the created methods to the Service Impl class that passes the same to the DAO;


    Design Flow for the saveDepartment POST API call
    ***   Controller Layer Flow
  Create the saveDepartment method with the @RequestBody annotation referencing to the Entity where the Data Object is to be mapped to in the DB;
  @PostMapping() annotation is used with the path parameter defined inside the parenthesis as a String
  Then return the Autowired Service Interface calling the saveDepartment method which takes in the Method-level created Entity Object called as a RequestBody.
    ***   Service Layer Flow
  Create saveDepartment method in the Service Layer Interface which will be implemented in the ServiceImpl Class;
  In the ServiceImpl Class, create the same saveDepartment method that takes in the Department Entity,
      and it will be an @Override annotated method;
  Then Autowire the Repository Class which will connect us to the DB and allow us to use JPA methods;
  Then return the Autowired Repository class that is calling JPA built-in save method that takes in the class-referenced department Entity.



    Design Flow for the fetchDepartment GET All Departments API call
    ***   Controller Layer Flow
  Create the fetchDepartment method which fetches the Data available in the Entity as a List<> that takes in the Department Entity;
  @GetMapping() annotation is used with the URL path defined inside the parenthesis as a String parameter
  fetchDepartment() will not take in any input since we are fetching Data from the Entity
  The Service Layer Interface to be Implemented is already injected;
  Then return the Autowired Service Interface calling the fetchDepartment method which does not take in any input parameter.
    ***   Service Layer Flow
  Create fetchDepartment method in the Service Layer Interface which will be implemented in the ServiceImpl Class;
  In the ServiceImpl Class, create the same fetchDepartment method which fetches the Data available in the Entity as a List<> that takes in the Department Entity,
  and it will be an @Override annotated method;
  The Repository Class is already Autowired to connect us to the DB and allow us to use JPA methods;
  Then return the newly created/referenced Repository class calling JPA findAll method that does not take in any input since we are fetching Data.



    Design Flow for the fetchDepartment GET By ID API call
    ***   Controller Layer Flow
  Create the fetchDepartmentById method which will make the Request
  This method will take in the @GetMapping() ...
      which takes in the url path that ends with a Variable declaration call for the particular Entity property needed; @GetMapping("/departments/{id}"
  In our case we'll request for the data present in the Id as declared in the URL path
  The method itself will not take in List but will Call the Department Entity since we just want a particular set of Data for the specified ID: public Department fetch...()
  The method now will Define the Entity being used as the Primary Key, which in this case is the ID: Long departmentId which will be taken in as an input
  Then before the Entity Definition in the method input, add the @PathVariable("id") annotation that takes in the value put in the @GetMapping URL path
      to enable the communication and Binding/linkage of the Variable defined in the path as well as with the Entity Type and Identity defined in the method Input
  Then finally call the return method to return the Autowired Service Interface then calls the created method which takes in the Entity property Identity as an input
    ***   Service Layer Flow
  Then create the method in the ServiceInterface which takes in the defined Entity property
  Again create the method in the ServiceImpl class to implement the GetMethod request coming from the Presentational layer
  Here in the ServiceImpl class, the return method calls the DAO method that has been Autowired
      which then calls the JPA method findById() and takes in the defined Entity property
  Then the get() method is called: findById(departmentId).get()



    Design Flow for the deleteById DELETE By ID API call
    ***   Controller Layer Flow
  Create the deleteDepartmentById() method/function which is to make the API request
  This method is to take the @DeleteMapping() annotation ...
      which takes in the basic same URL path just as the GetById URL path which ends with a Variable call for the particular Entity property needed; @DeleteMapping("/departments/{id}"
  In this case, the data that will be deleted will be the data present in the specified Id declared in the URL path
  The method creation itself won't have the Entity defined on it since we are not returning an Object after the call but instead we'll be deleting an Object after the request is actioned
  The method in this case will have a String definition which will help us define the return String message to be printed for us once the API request has been actioned successfully;
  The method then will take in the @PathVariable() annotation that takes in the variable defined in the Mapping annotation
      and after the PathVariable definition the Entity defined as the Primary Key is defined with its Type
  Then call the Service Interface that was Autowired which then calls the just created method taking in the Entity property as an input: departmentService.deleteById(departmentId)
  Then return a String statement that will be printed on the REST client(Postman) after a successful actioning of the API call
    ***   Service Layer Flow
  Then create a Void method in the Service Interface with the deleteDepartmentById() that takes in the Entity property type and definition
  Then create another method in the ServiceImpl class that implements the void method created in the Interface;
  This will be an @Override method that will be public and void meaning it won't return any value after it's actioning and;
      thus the request actioning shall be to call our DAO, departmentRepository that will call a JPA method deleteById(departmentId) which takes in the Entity property definition



    Design Flow for the updateDepartment UPDATE By ID API call
    ***   Controller Layer Flow
  Create the updateDepartment method which is to make the API request
  This method is to take the @PutMapping annotation ...
      which is to take in the URL path with the {id} path variable for updating the particular declared Id
  Thus, in this case, the data that will be updated will be the data present in the specified Id declared in the URL path
  This method creation will have the Department Entity declaration since some data will be outputted after an update is made to the specified Entity by Id;
      then the method updateDepartment() will take in 2 input parameters;
          the @PathVariable("Id") which links the declared Id in the URL path and also defines the Primary Key to which to check for updating
          then @RequestBody annotation which defines the Entity Body to which the changes are to be matched against and updated
          Thus updateDepartment(@PathVariable("id") Long departmentId,
                                  @RequestBody Department department)
  Then the method will return the Service Interface calling the method which takes in both the Defined Primary Key Entity Property as well as the department Entity Object
    ***   Service Layer Flow
  Then create the method call in the Service Interface for implementation
  The ServiceImpl Class in implementing the Service Interface shall include a logic to check if the Entity Properties are either NotNull or not blank and nothing unchanged, ignoring the casing;
      if this check passes, then that particular Property is skipped without being changed thus retaining it's initial value;
      but if either of the checks is not passed, then the newly detected value is set on the particular Entity Property for the defined id



    Design Flow for the fetchDepartment another Entity Property, say GET Department By Name API call
    ***   Controller Layer Flow
  Create the fetchDepartmentByName method which will make the Request
  This method will take in the @GetMapping() ...
      which takes in the url path that ends with a Variable call for the particular Entity property needed; @GetMapping("/departments/{name}"
  In our case we'll request for the data present with the specified name declared in the URL path
  The method itself will not take in List but will Call the Department Entity since we just want a particular set of Data for the specified name: public Department fetch...()
  The method now will Define the Entity being used as the Point of Reference for binding;
      with the Entity Type and Identifier defined, which in this case is the name: String departmentName which will be taken in as an input
  Then before the Entity Definition in the method input, add the @PathVariable("name") annotation that takes in the value put in the @GetMapping URL path
      to enable the communication and Binding/linkage of the Variable defined in the path as well as with the Entity Property Type and Identity defined as the method Input
  Then finally call the return method which returns the Autowired Service Interface that calls the created method which takes in the Entity property Identity as an input
    ***   Service Layer Flow
  Then create the method in the ServiceInterface which takes in the defined Entity property
  Again create the method in the ServiceImpl class to implement the GetMethod request coming from the Presentational layer
  Here in the ServiceImpl class, the return method calls the DAO method that has been Autowired
      which then is to call a default JPA method findByName() and takes in the defined Entity property, but since the default method is not there,
      we first custom create a findByDepartmentName() method in the DAO layer that the Service Impl Class will call
  The naming convention of findByDepartmentName() method is key in that it should match the Entity Property Identity that is to be called; and it should be findBy NOT fetch or any other terminology
      and then take in the Entity Property Type and Identity as Input Parameters
  Then get back to the ServiceImpl Class and call the custom method created in the DAO through the Autowired DAO;
      And this time round we don't need to add the get() method after the call since we custom created the method ourselves and thus the DAO shall get the depertmentByName
      if tye naming convention is okay!




      HIBERNATE VALIDATIONS

  Add the validation dependency
  Then add the @NotBlank annotation on the Entity property you want to always be present on the JSON RequestBody
      and ypu can also add a message within the parenthesis for printing when the property is passed blank
    Then add @Valid annotation just before the @RequestBody of our POST method call;
    this way, whenever the JSON body comes in to be added in the DB, that body will be validated against the @NotBlank annotation that we added in the Entity class



      ADDING LOGGERS

  All applications should have Logging functionality available for better tracing from: INFO, WARN, TRACE etc.
  For Development purposes, a simple Logging system can word but for Production purposes;
      a more Logging structure would be useful to have the Logs written in a external file within the machine;
      This can be achieved using Dependency Libraries like Log4j
  For Development purposes, you can use 2 approaches:
      1. This one wouldn't need a dependency added for the Logging to work:
          You just create a private static final Logger class and initialize a log class for it within the Java Class that you want logs for
              The Logger should be a Slf4j Interface
          then call LoggerFactory which calls the getLogger method which will take in then Java Class as an input parameter;
          Check this implementation in DepartmentController Java Class...
      2. The second one would be as simple as annotating the Java Class with @Slf4j annotation which Spring Boot will add a lombok dependency that enables us use the logging interface
          Then start making the log calls within the file and you good to go
          Check this implementation in DepartmentServiceImpl Java Class...
  Logging prints the particular log Type(INFO, WARN); Thread count; the Class printing the log & the Log message



        PROJECT LOMBOK
  lombok is Java annotation library that helps us reduce the boilerplate code in our Java applications
 When working with Java applications, we tend to create a lot of Plain Old Java Objects(POJO's) aka Entities.
    And the POJO's come with creation of their respective  Properties; Getters; Setters; POJO Constructors: Default Constructors and the toString method for the POJO
    It is easy to create all these but then our project will have huge lines of Code and this is where Lombok comes in handy to help reduce this boilerplate code
 Lombok will thus create for us the Getters; Setters; POJO Constructors with arguments; Default Constructors for the POJO without Arguments and the respective toString() method
 Thus all you need now to do is just add Lombok Dependency and its Plugin and add the respective Annotations

 Now comment out the Getters; Setters; POJO Constructors with arguments; Default Constructors for the POJO without Arguments and the respective toString() method
 Then add their respective Lombok Annotations described above on the Annotations section











 *
 **/