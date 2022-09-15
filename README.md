# Spring-Boot-Concepts-in-Depth
<hr>

#### Requirements:
1. JDK 16
2. Maven 3.x


### How To Run
This application is packaged as a jar which has Tomcat 8 embedded. 
You don't need Tomcat installed in your system

* Clone This Repository.
* Build the Project with mvn clean install
* Run the application with mvn spring-boot:run
* Go to [http://localhost:8080](http://localhost:8080 "Named link title") or open postman to call api's

Once the application runs you should see something like this:
```
2022-08-17 16:43:22.498  INFO 13028 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-08-17 16:43:22.509  INFO 13028 --- [           main] c.e.springrest.SpringrestApplication     : Started SpringrestApplication in 8.402 seconds (JVM running for 9.472)
```

### Features

:white_check_mark: CRUD  
:white_check_mark: One To One Relational mapping  
:white_check_mark: One To Many Relational Mapping   
:white_check_mark: Many To Many Relational Mapping   
:white_check_mark: Java8 Optional   
:white_check_mark: Mapping resultset to custom dta   
:white_check_mark: Exception Handling  

- Use of different Annotations    
   :heavy_check_mark: @OneToOne   
   :heavy_check_mark: @OneToMany               
   :heavy_check_mark: @ManyToMany            
   :heavy_check_mark: @SqlResultSetMapping      
   :heavy_check_mark: @JoinColumn                           
   :heavy_check_mark: @JoinTable                        
   :heavy_check_mark: @Query             
   :heavy_check_mark: @PersistenceContext              
   :heavy_check_mark: @Transactional         
   :heavy_check_mark: @ExceptionHandler              
   :heavy_check_mark: @ControllerAdvice             
   :heavy_check_mark: @Mock               
   :heavy_check_mark: @Test


### Quick Guide (Tips):

## 1. Hibernate vs JPA vs Spring Data JPA
<hr>

### 1. Hibernate:
- Hibernate is a ORM framework that maps the relational data to the Java Objects.
- It also provides configuration options to configure the data store and developers can also write queries with Hibernate (HQL).
- It provides features like:
   - Caching.
   - Lazy Loading.
   - Scalability.
   - HQL (Hibernate Query Language)
   - Database Independent (Provides in memory database)

### 2. JPA:
- JPA stands for Java Persistence API and it is the Java specification that defines how to persist java objects. 
- It is considered as a link between an object-oriented model and a relational database system. 
- Hibernate is the standard implementation of JPA. 
- JPA cannot be used alone and it always needs an implementation like Hibernate, EclipseLink, iBatis, etc.
- |      JPA        |     Hibernate    |                     
  |-----------------|------------------| 
  |JPA provides JPQL (Java Persistence Query Language).| HQL provided by Hibernate is a superset of it.|
  |JPA provides EntityManagerFactory interface to create Session instances.| whereas Hibernate provides SessionFactory to create the Session instances.|
  |For CRUD operations on instances of mapped entity classes, JPA uses EntityManager.|  Hibernate uses the Session interface |

### 3. Spring Data JPA:
- JPA is a standard for defining the persistence layer and Spring Data JPA is a sub-project under the Spring Framework umbrella which allows Spring applications to integrate with JPA. 
- Contrary to the popular Myth that it's a JPA implementation like Hibernate, it actually provides another level of abstraction to produce more cleaner code and it always needs a JPA implementation like Hibernate to work with.
- If you are thinking what is the point of using Spring Data JPA if you have to use Hibernate or Eclipse Link then let me tell you that its a kind of add-on, it makes it easier to write your Data Access Layer and provides clean methods to save and retrieve data from any Database without writing SQL.
- Spring Data JPA comes with a concept called JPA Repository and Query methods. JPA Repository is nothing a set of interfaces that defines query methods like findByFirstName or findByLastName etc. These methods are converted into low-level SQL queries by Spring.
- The Spring Data Jpa dependency can be added as below and this will do the data source auto-configuration as well. After adding this, we just need to add a database dependency to make sure it is available in the class path.
```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
<version>{version}</version>
</dependency>
```
## 2. Mockito
<hr>

- When you use the @SpringBootTest annotation then SpringExtension for Junit5 starts an application context before running your test, and to make mocks in tests you need to use @MockBean annotation instead of @Mock & @InjectMocks
- If you do not write @SpringBootTest annotation, use @ExtendWith(MockitoExtension.class) annotation and use @Mock annotation to make mocks in tests.
- @ExtendWith(MockitoExtension.class) annotation opens and closes the mocks for us. We do not have to explicitly open and close them. 
- @Mock annotation is a shorthand for the Mockito.mock(). Unlike the mock() method, we need to enable Mockito annotations to use this annotation. We can do this either by using MockitoJUnitRunner to run the test or by calling the MockitoAnnotations.initMocks() method explicitly.

## 3. Persistence Life Cycle
<hr>

<img src="entity lifecycle.png" width="500" height="300">

### 1. Transient:
- The lifecycle state of a newly instantiated entity object is called transient. The entity hasn’t been persisted yet, so it doesn’t represent any database record.
- The persistence context doesn’t know about your newly instantiate object. As long as your entity object is in the lifecycle state transient, you can think of it as a basic Java object without any connection to the database and any JPA-specific functionality.

### 2. Persistent / Managed:
- In this state. each object represents one row in the database table. 
- Therefore, if we make any changes in the data then hibernate will detect these changes and make changes in the database table.

### 3. Detached:
- An entity gets detached when you close the persistence context. 
- That typically happens after a request got processed. Then the database transaction gets committed, the persistence context gets closed, and the entity object gets returned to the caller
- For converting an object from Persistent State to Detached State, we either have to close the session or we have to clear its cache. 
- As the session is closed here or the cache is cleared, then any changes made to the data will not affect the database table. 
- Whenever needed, the detached object can be reconnected to a new hibernate session.

### 4. Removed:
- when the entity object is deleted from the database then the entity object is known to be in the removed state.