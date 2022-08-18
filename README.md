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

- [x] CRUD 
- [x] One To One Relational mapping
- [x] One To Many Relational Mapping
- [x] Many To Many Relational Mapping
- [x] Java8 Optional 
- [x] Mapping resultset to custom dta 
- [x] Exception Handling

:white_check_mark: - emoji checkbox example
 

- Use of different Annotations
   - [x] @OneToOne
   - [x] @OneToMany
   - [x] @ManyToMany
   - [x] @JoinColumn
   - [x] @JoinTable
   - [x] @Query
   - [x] @PersistenceContext
   - [x] @Transactional



