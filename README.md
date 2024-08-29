# Tree Assignment (JAVA and Spring Boot)

=======================================
## Retrieve Statements
### Description:
This API endpoint allows you to retrieve a list of statements based on various criteria:

1. Account ID: The ID of the account for which you want to retrieve statements.
2. Date Range: The start and end dates of the desired statement period.
3. Amount Range: The minimum and maximum amounts to filter statements by.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [API Documentation](#api-documentation)
- [Database Diagrams](#database-diagrams)
- [User Roles](#user-roles)

## Technologies Used

This project leverages several key technologies and tools:

- **Java 22.0.2**
- **Spring Boot**
- **Maven 3.9.9**
- **Hibernate**
- **PostgreSQL**
- **Spring Data JPA**
- **Lombok**
- **SonarQube**



## Installation

### Prerequisites
- JDK 11 or later
- Maven 3.6.0 or later
- PostgreSQL (or any other required database)
- Git

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/waseem0abuameer/TreeAssignment.git
   ```
2. Navigate to the project directory:
   ```bash
   cd project-name
   ```
3. Configure the database:
    - Update the `application.properties` 
    - Configuration

Before running the project, ensure that your application is configured correctly. Below is the configuration used in the `application.properties` file:

```properties
# Application Name
spring.application.name=treeassignment

# Database Configuration
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5433/accountsdb
spring.datasource.username=postgres
spring.datasource.password=123456

# JPA and Hibernate Configuration
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server Configuration
server.port=8000
```

4. Build the project:
   ```bash
   mvn clean install
   ```
   
5. Access the application:
    - Open your browser and navigate to `http://localhost:8080` 

## API Documentation

### Get All Accounts
- **Endpoint:** `/api/accounts`
- **Method:** GET
- **Description:** Retrieves all accounts.

## Database Diagrams

![database-diagrams](/src/img/Database.png)


## User Roles
### The authenticated users are::
1. Admin : Username: admin & Password: admin
2. User : Username: user & Password: user






