# Hotel API (Property View Service)

A RESTful backend service for managing hotel data, built with Spring Boot.  
The application provides endpoints for hotel management, search, and analytics.

---

## Features

- Create and retrieve hotels
- Search hotels with filters
- Add amenities to hotels
- Get aggregated statistics (histogram) by:
  - brand
  - city
  - country
  - amenities
- Validation of incoming requests
- OpenAPI (Swagger) documentation

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 / PostgreSQL (configurable)
- Liquibase
- MapStruct
- Springdoc OpenAPI (Swagger)

---

## API Overview

### Hotels

- POST /hotels — create a hotel  
- GET /hotels/{id} — get hotel by id  
- GET /hotels — get all hotels  

### Search

- GET /search — search hotels by filters (name, brand, city, country, etc.)

### Amenities

- POST /hotels/{id}/amenities — add amenities to a hotel

### Statistics

- GET /histogram/{param} — get grouped counts by:
  - brand
  - city
  - country
  - amenities

---

## How to Run
- Using Maven:  
  - mvn spring-boot:run  
- Or run from IDE

## Database

Default configuration uses H2 in-memory database.

H2 console available at:
/h2-console

## API Documentation

Swagger UI:
/swagger-ui.html

OpenAPI JSON:
/v3/api-docs
