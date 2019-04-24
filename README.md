# GraphQL Tutorial Implementation

This is an implementation of [GraphQL Tutorial for Java](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/) using [Clean Architecture principles](https://medium.freecodecamp.org/a-quick-introduction-to-clean-architecture-990c014448d2). This application also gives an example of how to use GraphQL with data stored in a database.

The purpose of this project is learning GraphQL technology, how to develop and how to test it.

## Getting Started

### Run Locally
```sh
$ mvn spring-boot:run
```
Application will be available at http://localhost:8080/graphql .

### Sample Query
The sample query below searches for books that contains the word "Tower" in the name, returns book and its author information:
 
```sh
curl \
	-X POST \
	-H "Content-Type: application/json" \
	--data '{ "query" : "{ bookByName(name: \"Tower\"){ id name pageCount author { firstName lastName } } }" }' \
	http://localhost:8080/graphql
```

### Going further
You can navigate through all data provided by this application visiting [this file](src/main/resources/schema.graphqls).

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Spring-Boot](https://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
* [GraphQL](https://graphql.org/) - GraphQL is a query language for APIs and a runtime for fulfilling those queries with your existing data.
* [H2 Database](https://www.h2database.com) - In-memory database.