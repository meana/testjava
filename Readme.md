# Classora TestJava

[![Java Version](https://img.shields.io/badge/java-17-blue.svg)](https://adoptopenjdk.net/)
[![Spring Boot Version](https://img.shields.io/badge/spring%20boot-3.2.2-brightgreen.svg)](https://spring.io/projects/spring-boot)

## Description

This API is part of a java aptitude test for Classora, [here](./others/TestJava.txt) file with instructions for the test.

## Prerequisites

- Java JDK 17
- Gradle 8.5 or higher

## Setting Up
Clone the Repository
```bash
git clone https://github.com/meana/testjava
cd testjava
```

## Building the Application
Use Gradle to build the application:

```bash
./gradlew build
```

## Running the Application
Run the application using Gradle:

```bash
./gradlew bootRun
```

The application will be accessible at http://localhost:8080.


## H2 Database Console
The H2 database console can be accessed at http://localhost:8080/h2-console. Use the JDBC URL, username, and password as specified in your application.properties.

