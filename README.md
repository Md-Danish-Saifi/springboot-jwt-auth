
<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Md-Danish-Saifi/springboot-jwt-auth">
    <img src="images/jwt-banner-2.png" alt="Logo">
  </a>

  <h3 align="center">JWT Auth</h3>

  <p align="center">
    A simple implementation of spring security using jason web tokens
    <br />
  </p>
  <br/>
</div>

**Spring Boot JWT Role Based Authentication Readme**

**Created by Danish**

**Date: March 17, 2024**

---

## Description

This repository contains the source code for the Spring Boot assignment. The assignment involves building a Spring Boot application that utilizes RESTful APIs and includes necessary configurations like JWT Role Based Authentication and Spring Security Configuration along with Database connectivity with MySQL8.

## Installation

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/Md-Danish-Saifi/springboot-jwt-auth.git
    ```

2. Navigate to the project directory:

    ```bash
    cd spring-boot-assignment
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Configuration

The Spring Boot application utilizes the following configurations:

- **Java Version**: Java 8 or higher
- **Spring Boot Version**: 2.5.0 or higher
- **Dependencies**:
    - Spring Boot Starter Web
    - Spring Boot Starter Test (for testing)
- **REST Template Configuration**:
    - Configured a `RestTemplate` bean in the `AppConfig` class to enable HTTP requests to external APIs.
- **Application Properties**:
    - Application properties file (`application.properties` or `application.yml`) contains configurable properties such as server port, logging configurations, etc.

## Usage

1. Start the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

2. Access the application at `http://localhost:8080` in your web browser.


3. use postman to access registration url `http://localhost:8080/api/v1/auth/register` with
required parameters 


    {
    "firstName": "user",
    "lastName": "name",
    "password": "L2zylpdt",
    "email": "user@gmail.com",
    "role": ["admin"]
    }




5. use postman to hit login url `http://localhost:8080/api/v1/auth/login` with credentials 
#### Danish

   email:- danish@gmail.com & password:- 12345
   #### Sibani
   email:- sibani@gmail.com & password :- 12345,

    {
    "password": "12345",
    "email": "danish@gmail.com"
    }
## Additional Notes

- Ensure that all dependencies specified in the `pom.xml` file are resolved.
- Make sure to configure any external API URLs or credentials in the application properties file.
- For further customization or enhancements, refer to the codebase and make necessary modifications.

## Contributor

- Danish


## License

This project is licensed under the [MIT License](LICENSE).
