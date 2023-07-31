package com.shavic.department.controller;

import org.springframework.beans.factory.annotation.Value;
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
  @Qualifier --> annotation used to resolve the auto wiring conflict, when there are multiple beans of the same type



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
            --> generating getters & setters for all fields
            --> generating setters for all non-final fields
            --> generating all appropriate toString, equals and hashCode implementations that involve the fields of the class
            --> generating a Constructor that initializes all final fields, as well as non-final fields with no initializer that have been marked with @NonNull, in order to ensure the fields are never null.

 https://stackoverflow.com/questions/68314072/why-to-use-allargsconstructor-and-noargsconstructor-together-over-an-entity

 @AllArgsConstructor --> generates a constructor requiring an argument for every field in the annotated class
                     --> it also allows the creation of static factory methods using the staticName attribute
 @NoArgsConstructor --> generates a default constructor with no parameters
                    --> it can create a static factory method for construction purposes
 Lombok can't call the super constructor unless it has a no-args constructor
 And the JPA specification requires that all persistent classes(Entity) have a no-arg constructor, either public or protected



    EXCEPTION HANDLING

 https://stackoverflow.com/questions/43124391/restcontrolleradvice-vs-controlleradvice
 https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html

 @ControllerAdvice --> Is a Specialization of @Component annotation for classes that declare @ExceptionHandler; @InitBinder; or @ModelAttribute methods
                        which are to be shared across multiple @Controller classes
                    --> can be used in REST web services but you will need to add the @ResponseBody annotation
 @RestControllerAdvice --> Is a syntactic sugar for @ControllerAdvice + @ResponseBody annotations bundled up together
 @ExceptionHandler --> Annotation for handling exceptions in specific handler classes and/or handler methods
 @ResponseStatus --> Annotation used to mark a method or exception class that contains a status code and the reason message that should be returned

 Optional<> --> Is a container object which may or may not contain a non-null value;
                if a value is present, isPresent() will return TRUE and get() will return the value
                If no value is present, the object is considered empty and isPresent() returns false.




    UNIT TEST ANNOTATIONS

 https://stackoverflow.com/questions/59097035/springboottest-vs-webmvctest-datajpatest-service-unit-tests-what-is-the-b
 https://www.baeldung.com/lombok-builder
 https://www.java67.com/2023/04/difference-between-mockitomock-mock-and.html#:~:text=Difference%20between%20%40Mock%20and%20%40MockBean%20annotation%20in%20Spring%20Boot&text=%40Mock%20is%20used%20for%20mocking,tests%20with%20the%20Mockito%20framework.

 @SpringBootTest --> annotation that helps to load the full application context;
                    exactly like how you start a Spring container when you run your Spring Boot application
                    Typically a general annotation but you would annotate this on Test Class written for the Service layer Interface
 @DataJpaTest --> annotation that loads only the configuration for JPA.
                It uses an embedded in-memory H2 if not specified otherwise
                Typically annotated on test Classes for the Repository layer
 @WebMvcTest(-controllerClass-) --> annotation that loads only the Web layer, which includes security, filter, interceptors, etc
                essentially centered around handling requests/responses.
                Thus, you would typically write tests for methods under @Controller/@RestController and annotate the class with this

 The Service Layer Impl class Tests should ideally not have any annotations(except for ones that aid in mocking);
    this is because The ServiceImpl Class is where your business logic(independent of any configurations) reside

 @Builder --> annotation added to our POJOs to help with creating object mocks of our POJOs
            Added to the Entity class and called in tests to create dummy test case instances of the POJOs
            It creates a builder class for a final Class

 @Mock --> annotation used for mocking objects that are not part of the Spring context
 @MockBean --> annotation used for mocking objects that are part of the Spring context(check the service && controller layer test cases)
                this annotation is not aware of the Spring context;
                and thus is typically used for unit testing isolated components without the need for a full Spring context setup.
 Check the above provided link

 *
 **
 ***
 **/



@RestController
public class HelloWorld {

//    pulling data from the application.properties file and attaching the value to this new String variable
    @Value("${welcome.message}")
    private String welcomeMessage;
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld() {
        return welcomeMessage;
    }

}



/***
 **
 *
    Web Development architectural structure:
    1. The Back End team is responsible for creating the APIs that enable Communication/ Data manipulation
    2. Then the Front End technologies will consume the APIs to communicate with the DB

         Spring Boot's REST API architecture:
             1. Controller Layer      ===> this is the Presentational layer
                                      ===> it basically handles the client requests and gives back responses through the CRUD; POST, GET, UPDATE, DELETE operations
                                      ===> it passes its methods to the Service layer through the Autowired Service Interface
                                      ===> this is a Java Class
             2. Service Layer     ===> this is the Business logic layer
                                  ===> it contains the logic for our APIs
                                  ===> this layer in general will have an Interface and an Implementation class for the Interface
                                  ===> the Interface layer takes in the client request methods created in the Controller layer
                                  ===> the Implementation layer then Implements the methods defined in its Interface with added business logic
                                        and then calling the Autowired DAO layer for actioning in the DB
                                  ===> thus comprising an Interface and a Java Impl Class that implements the Interface
             3. Repository layer       ===> this is the Data Access Object(DAO) layer or the Persistence layer
                                       ===> it is the Data Access Layer of our API since it is the layer that interacts with the DataBase
                                       ===> it extends JpaRepository interface that takes in the Entity/Bean Object defining our DB and the Entity property Type defined as our Primary Key for the DB
                                       ===> this is an Interface and thus allows us to work with the Spring Data JPA through extending it
             4. DataBase      ===> this is where our Data is stored
                              ===> Spring Boot offers H2 in-memory DB which can later be switched to a real DB such as PostgreSQL or mySQL or MSSQL
                              ===> Spring Boot h2 dependency provides us with a browser-based console that helps us interact with our H2 in-memory DB
                              ===> Check the application.properties file on how the configuration for the H2 DB is done

  Entity   - @ 01:35:10
    A default Model can be equated to an Entity in Spring Boot
    The Entity contains: * properties defining our table columns
                          * Getters and Setters
                          * main Constructor and a default Constructor
                          * toString() method to call the properties for printing on the console
                          * @Entity annotation

  Controller
    Create the EntityController Class where the RESTful APIs will be created';
      and annotate it with the @RestController annotation
    After creating the Controller, you inject by autowiring the Service Layer Interface which will pass the methods created to the Service Implementation class for Implementation

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


            CREATING REST APIs FLOW   - @ 01:56:35

  In the created Controller, Inject the Service Layer Interface that will pass the created methods to the Service Impl class that passes the same to the DAO;


    Design Flow for the saveDepartment POST API call   - @ 02:13:45
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



    Design Flow for the fetchDepartment GET All Departments API call   - @ 02:27:40
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
      which takes in the url path that ends with a Variable declaration call for the particular Entity property needed; @GetMapping("/departments/{id}")
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



    Design Flow for the deleteById DELETE By ID API call   - @ 02:30:00
    ***   Controller Layer Flow

  Create the deleteDepartmentById() method/function which is to make the API request
  This method is to take the @DeleteMapping() annotation ...
      which takes in the basic same URL path just as the GetById URL path which ends with a Variable call for the particular Entity property needed; @DeleteMapping("/departments/{id}"
  In this case, the data that will be deleted will be the data present in the specified Id declared in the URL path
  The method creation itself won't have the Entity defined on it since we are not returning an Object after the call but instead we'll be deleting an Object after the request is actioned
  The method in this case will have a String definition which will help us define the return String message to be printed for us once the API request has been actioned successfully;
  The method then will take in the @PathVariable() annotation that takes in the variable defined in the Mapping annotation
      and after the PathVariable definition the Entity property defined as the Primary Key is defined with its Type
  Then call the Service Interface that was Autowired which then calls the just created method taking in the Entity property as an input: departmentService.deleteById(departmentId)
  Then return a String statement that will be printed on the REST client(Postman) after a successful actioning of the API call
    ***   Service Layer Flow
  Then create a Void method in the Service Interface with the deleteDepartmentById() that takes in the Entity property type and definition
  Then create another method in the ServiceImpl class that implements the void method created in the Interface;
  This will be an @Override method that will be public and void meaning it won't return any value after it's actioning and;
      thus the request actioning shall be to call our DAO, departmentRepository that will call a JPA method deleteById(departmentId) which takes in the Entity property definition



    Design Flow for the updateDepartment UPDATE By ID API call   - @ 02:35:30
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



    Design Flow for the fetchDepartment another Entity Property, say GET Department By Name API call   - @ 02:43:33
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
      if the naming convention is okay!




      HIBERNATE VALIDATIONS   - @ 02:47:20

  Add the validation dependency in the POM file
  Then add the @NotBlank annotation on the Entity property you want to always be present on the JSON RequestBody
      and you can also add a message within the parenthesis for printing when the property is passed blank
    Then add @Valid annotation just before the @RequestBody of our POST method call;
    this way, whenever the JSON body comes in to be added in the DB, that body will be validated against the @NotBlank annotation that we added in the Entity class



      ADDING LOGGERS    - @ 02:57:15

  All applications should have Logging functionality available for better tracing from: INFO, WARN, TRACE etc.
  For Development purposes, a simple Logging system can work but for Production purposes;
      a more Logging structure would be useful to have the Logs written to an external file within the machine;
      This can be achieved using Dependency Libraries like Log4j
  For Development purposes, you can use 2 approaches:
      1. This one wouldn't need a dependency added for the Logging to work:
          You just create a private static final Logger class and initialize a log class for it within the Java Class that you want logs for
              The Logger should be a Slf4j Interface
          then call LoggerFactory which calls the getLogger method which will take in the Java Class as an input parameter;
          Check this implementation in DepartmentController Java Class...
      2. The second one would be as simple as annotating the Java Class with @Slf4j annotation which Spring Boot will add a lombok dependency that enables us use the logging interface
          Then start making the log calls within the file and you good to go
          Check this implementation in DepartmentServiceImpl Java Class...
  Logging prints the particular log Type(INFO, WARN); Thread count; the Class printing the log & the Log message



        PROJECT LOMBOK   - @ 03:02:55

  lombok is Java annotation library that helps us reduce the boilerplate code in our Java applications
 When working with Java applications, we tend to create a lot of Plain Old Java Objects(POJO's) aka Entities.
    And the POJO's come with creation of their respective  Properties; Getters; Setters; POJO Constructors: Default Constructors and the toString method for the POJO
    It is easy to create all these but then our project will have huge lines of Code and this is where Lombok comes in handy to help reduce this boilerplate code
 Lombok will thus create for us the Getters; Setters; POJO Constructors with arguments; Default Constructors for the POJO without Arguments and the respective toString() method
 Thus all you need now to do is just add Lombok Dependency and its Plugin and add the respective Annotations

 Now comment out the Getters; Setters; POJO Constructors with arguments; Default Constructors for the POJO without Arguments and the respective toString() method
 Then add their respective Lombok Annotations described above on the Annotations section



        EXCEPTION HANDLING   - @ 03:08:25

 Exception Handling helps us avoid getting error stack trace with all irrelevant details and thus customize the trace to particular relevant details that we need!
 Create a Package for the various Custom Error Handling Java Classes:
    Inside the package Create the Custom Exception Handling Class
    Override the Class using the Shortcut keys: ALT + INSERT
        The above step will allow you create the public methods that override(select all):
            exception method class only
            exception taking in the String message as the only input argument
            exception taking in the String message and the Throwable cause as input arguments
            exception taking in the Throwable cause as the only input argument
            exception taking in the String message, Throwable cause, and a separation as input arguments
 Add the Custom Exception Class as method signatures to the Service Impl method call, Service Interface method call and the Controller method call

 To ensure that we get just the necessary Log Trace that are relevant to the User;
    we need to configure the Controller layer so that it identifies Exceptions when they are thrown and sends back a Response in place of the Exception caught
 Create a Global Exception Handler class that will be responsible for sending all Responses based on the Exception caught;
    and annotate it with @RestControllerAdvice so as to make it globally available to all Controllers
    also annotate it with @ResponseStatus to get the HttpStatus response
 Then create a new POJO/Entity class that will contain the properties that we need sent for the Error trace instances: HttpStatus && String message fields
 Then create a public method inside the Global Exception Handling class;
    The method shall be an instance of the ErrorMessage Entity created and it should be an instance of ResponseEntity Type: ResponseEntity<ErrorMessage>
    And the method call shall take in an instance of the custom exception being handled as well as WebRequest instance as input parameters
    Annotate the method with @ExceptionHandler annotation that will take in the Custom Exception handling class being called as an input class parameter
 Create a new ErrorMessage Class Instance to be sent back once an exception is thrown and caught by the Controller
 Make the return call that will be the ResponseEntity Instance calling the status which takes in a parameter the HttpStatus calling the expected status description
    and then call the body method that will take in the just created ErrorMessage Class Instance

 And it's all good:
    Whenever the requests comes to the Controller, the Controller shall throw the task to the GlobalExceptionHandler which has been annotated with the @RestControllerAdvice;
        which contains the logic to handle the particular exception that has been thrown by the Controller Class
    The Logic with the message is in the ServiceImpl and will be called through the ExceptionHandling Class that was called in the Impl class with the message

 Just implemented Exception Handling for throwing an Exception when trying to UPDATE a Department Object which does not exist
 Then also implemented another Exception Handling Logic that entailed changing the Department object Instance of the DAO custom method turned to Class Type Optional;
    Then adjusting all the method level Department Instances to Optional Type and adding the signature to the inherited methods and throwing the NotFoundException



            MIGRATING FROM H2 to POSTGRES DB   - @ 03:21:50

    https://medium.com/@tonykay001/how-to-connect-a-springboot-application-to-postgresql-on-your-local-machine-a1e16c8626ef
    https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples

 Creating a new server on pgAdmin 4 which shall contain the Databases for projects in Development phases
 Then inside the server is where the various Databases for the projects shall be contained

 Create the Database for the project: department_api under User Postgres for development purposes



            UNIT TESTING   - @ 03:27:30

 Every application should have Unit Tests to test:
    1) Integration Testing - Testing the Entire End-2-End functionality of the application, or
    2) Unit Tests - Testing the individual functionalities of the application
 Spring Boot provides by default 2 libraries to help with the testing:
    1) JUnit
    2) Mockito
            MOCKING CONCEPT
 The Application flow is usually dependent on various layers:
    The Controller layer requests for Data or passes data through the Service layer;
    the Service layer on the other hand will request/pass data through the Repository layer;
    and then the Repository layer interacts with the Database to either get data or populate data.
 So whenever we are Testing methods within an individual layer, we don't want to be concerned with the external layers that it depends on;
    let's say we are testing the Controller layer, we will Mock data required from/to the Service layer and Provide a Mocked data,
    so as to avoid calling the Service layer
    Same case when dealing with the Repository layer, we Mock the data we would want from the DB,
    so as to avoid hitting the DB.

            UNIT TESTING    -   Service Layer       @ 03:30:00
    *** Testing fetchDepartmentByName() method of the Service Layer
 We'll write tests for all the layers from the -> Service layer -> Repository layer -> Controller layer
    And implement mocking
 Create the Class Test file:
    - Go to the Service layer Interface on the Class level and;
        use ALT + Enter OR Right-Click and go to Generate
        choose Tests
        choose setUp/@BeforeEach default function which we'll use in Mocking
        don't choose the Methods, we'll create our own Test names since we'll be writing tests for both scenarios, passing(+) and failing(-) scenarios
 To enable Spring Boot recognize the newly created Class as a Test add: @SpringBootTest annotation
 Then create the first test method:
    The method should be void since we are not returning any value after execution
    The method name should be as descriptive as possible for ease of identification of the purpose of the method
 Within the method Test Case, we will need to find the departmentName through calling the method that we are testing from the Service layer;
    For that reason we need to inject the Service layer Interface that we are testing its method using @Autowired annotation
 Then annotate the custom method with @Test annotation to tell Spring Boot that that is a Test case
 Create a logic for the Test case validation:
    Declare the expected value upon the test call
    Create a variable holding the Object obtained from the method call from the Autowired Service Interface
    Then assert the values against each other

 The method call as of now, will try to retrieve the data from the DAO/repository which is not the behavior we want:
    Thus create a dummy mock Object from the Repository
 The Mocked Object will be created inside the @BeforeEach annotated method which is usually created before each Test method is run;
 First, unlike the @autowiring convention, here we @MockBean the DAO class privately to bring in the method call we need as a dummy object rather than the real object
    Then define what you want when the mocked bean method is called within the @BeforeEach annotated setUp() method.
    You can manually create the Constructor yourself, but that will be much work;
    We use the @Builder annotation that we earlier added in our Entity Class to help us in building the Desired Object here
 @Builder annotation provides us with a Builder Pattern:
    Builder Pattern --> is used when you have multiple fields available in the Entity, yet you want to use different sets of fields/properties every time;
                        it essentially allows us not to have to define all the Entity properties to get the dummy value that we want;
                        unlike with manually creating the Constructor where we would have had to create all the Property fields for the Constructor to be valid.
 Then in the setUp() create the desired mock object using the builder() method from the Entity annotation
 To then ensure that the mocked data is being passed when the DAO is called, use Mockito to define the data u want provided for validation
    i.e Mockito.when()
                .thenReturn();



            UNIT TESTING    -   Repository Layer       @ 03:44:00
 Testing the Repository layer is a little bit tricky since it is our interface to the DB hence DAO;
    and so you don't want to store any junk data values or change stuff in the DB
 This is where Spring Boot comes in handy with the @DataJpaTest annotation to test the Repository layer;
    the annotation persists data at the time of execution for the data in question and when the operation is completed, the data is flushed out

 You can alternatively create an entirely different testing DB, either in-memory DB or containerized DB; though this is too much work

 Create the Test Class for the repository layer with the @BeforeEach setUp() function
 Then annotate the Repository layer Test Class with the special @DataJpaTest annotation
 Autowire the Repository Class which we'll be testing its methods
 Then add the Test Entity Manager; since we choose to use an Entity Manager, we get the default Test Entity Manager that will still save & persist data
    Thus Autowire the TestEntityManager Class
  *** Testing findById() method of the Repository Layer
 Since for the testing we need the Data, we need to create the dummy Data Object we'll persist for Testing in the SetUp() function
 Then use the Autowired EntityManager Class to persist the dummy data object using the persist() function
 Now that the dummy data is persisted, you can now create the Test case that'll call the persisted data
 Inside the class, call the method to be tested and then use Assertions to validate the values against the persisted data

 ** check the issue with the dialect conflict btwn H2, PostgreSQL and the both test cases
 * Tests were failing coz of the below DB configuration:
 *  #spring.jpa.properties.hibernate.dialect
 * Commented it out and streamlined the configurations and as of 05062023, everything was working as expected
  * - The goodness of God, now 31 days to go and am out of Jamaica, just doing my revision here 31072023



            UNIT TESTING    -   Controller Layer       @ 03:50:00
 Testing the Controller layer is also a little different since this layer is only called when a particular endpoint has been hit
 This is where Spring Boot again comes in handy with the @WebMvcTest annotation to test the Controller layer;
    the annotation helps us create the testing context for the endpoints.
    Then Inside the Annotation, define the Controller class whose mock context is to be created
 Given the Controller layer calls are centered around the WebMvc, we need to Autowire the MockMvc final class of the servlet context;
    as well as Mock the Service layer since this layer is called when an endpoint is hit yet we don't actually want to interfere with the external layer calls
    we thus annotate it with the @MockBean annotation to indicate we just want to mock the class
 Call the Department Object which is to be simulated for the endpoint calls
    Then create the dummy outputted object test case inside the @BeforeEach setUp() method call which will act as the Output object for the endpoint calls
 ---> Save() Method Test Case
 Since the Save() method endpoint takes in the Department object as an input param as a RequestBody and then Outputs the same entire Department object;
    we need to simulate the same in the test case but the Input Department Object shall not have the ID since this POJO property is AutoGenerated
    Be sure to give the 2 Department Mock Objects distinct names for ease of identity during Mocking
 To ensure that the mocked data is being passed when the Service layer is called, use Mockito to define:
    the data u want provided as an input in the i.e Mockito.when() mocked service method call;
    and then the data u want outputted in the .thenReturn() call;
 Now that our input and output data have have been persisted using the Mockito call;
    we need to make the appropriate Endpoint call.
 The Endpoint call is made using the Autowired MockMvc class which uses the perform() method;
    which again takes in the MockMvcRequestBuilders abstract class that calls:
        the appropriate RequestMapping Endpoint call that takes in the url path;
        then defines the appropriate contentType that takes in the type definition;
        and the mocked content sample in the expected/above defined contentType
 After using the perform() method, the Autowired MockMvc class will then use the andExpect() method;
    which takes in the MockMvcResultMatchers abstract class that calls:
        the status() method which then defines afterwards the expected Status response
 Finally add Exception to the method signature expected by the perform() method call.

 Since the Static MockMvnRequestBuilders and the MockMvcResultMatchers are longer;
    you can use the shortcut: ALT + ENTER to use the Import operation which allows us to shorten the Static class names by;
        adding the on-demand static import for the long static class names.
 And now we are good to go,
    the mockMvc.perfom call shall act as the Endpoint call providing the content to be dummy added;
    and through the simulation it is matched against the Provided Service layer Input data
    and then against the Object to be Outputted from the method call
 Ensure the Dummy Data provided match at all places without unnecessary commas or anything not expected, otherwise the test will fail

 ---> fetchDepartmentById() Method Test Case
 This is a little less complicated since it doesn't expect an Input Object; it should just give us an Output Object as a response
 Thus, use Mockito to define:
    the id you want passed as an input parameter in the Mockito.when() mocked service method call;
    and then the data u want outputted upon a successful response in the .thenReturn() call;
 Now use the already illustrated mockMvc GET operation to grab and assert the data.
 This one though, the perform() call will not take in the .content() call since we are not sending any object but receiving.
 We'll thus add an extra .andExpect() call that will check if the JSON Object being provided matches the outputted JSON Object provided in the setUp() function
 The values are usually pulled using the `$` sign.




                        Managing Configuration - Adding Configurations in the properties file   - @ 04:00:00

 This is instrumental when u have some data that u need to add to ur application or for data that should be dynamic every now and then;
 Adding such data to the application.properties file is the best approach.
    This enables us to just be changing the values in the application.properties file instead of messing around with the code hard-coding values
 Create a key-value pair in the application.properties file;
    then create a private variable of the type of value you wanna call, either Int or String
    then annotate the variable with the @Value() annotation that will take in the key being referenced in the application.properties file "${key}"
 That simple, now just pass the variable where you want the data called in your code and simply fetch the data
 So, the data is fetched from the properties file and will be attached to our custom variable which is now called in our code.
 You can also add custom values in different files and you'll just need to reference those files and the data will be fetched.




                        Adding application.yml file for our application from application.properties file    - @ 04:03:00

 Spring Boot also supports the yaml file support for the application configurations.
 Why opt for the yaml file:
    - Yaml file is in a more human readable format
    - Yaml file helps in reducing duplicacy where it's indentation format helps cut out the redundant duplicates
    - It's an easy formatted file that is embraced by most technologies eg. Docker, Kubernetes & even AWS configurations
 There are different Plugins that can help with converting application.properties file contents to application.yml files;
    or Online resources that help with the conversion.
    eg. https://www.javainuse.com/app2yaml
 Either the .yml or .yaml file extensions can do.
 And Indentation is very important.





 *
 **/