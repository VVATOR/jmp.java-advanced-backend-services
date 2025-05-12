# Java Advanced: Backend Services

This course will provide you with technical hands-on knowledge of Spring Boot configuration, designing RESTful APIs, different types of RPC protocols and data formats, and Spring Security authentication and authorization features.


#### Modules:

<details>
<summary><u><strong>Module 1: Spring Boot</strong></u></summary>

#### Table of Content

- Spring Boot
- Plugins in build tools
- Spring boot templates
- Auto-dependency, auto-configuration, embedded servers
- Real live code examples
- Properties
- Integration tests with SpringBoot
- Spring actuator
- Fat jars
- Listeners
- Security


### Task 1. Spring Boot 

#### Spring Boot Homework Tasks

---

<details>
<summary>Task 1 - Hello-world application</summary>

#### Task 1 - Hello-world application

**Cost**: 15 points
- Use [Spring Initializr](https://start.spring.io) to create a basic Spring Boot application with minimal dependencies.
- Implement the `CommandLineRunner` interface in your application.
- Output the message `hello world` to the console.
- Run the application and verify that the message is displayed when the Spring context starts.
</details>

---

<details>
<summary>Task 2 - CRUD REST application</summary>

#### Task 2 - CRUD REST application

**Cost**: 20 points
- Choose a simple entity (e.g., `Customer`, `Product`) with a few attributes (e.g., `id`, `name`, etc.).
- Use `Spring Data JPA` for repository management, but avoid the use of Spring Data REST Starter.
- Create a REST controller with endpoints supporting Create, Read, Update, and Delete (CRUD) operations for the entity.
- Test the endpoints using tools such as `Postman` or `cURL`.
</details>

---

<details>
<summary>Task 3 - CRUD application: security</summary>

### Task 3 - CRUD application: security

**Cost**: 20 points
- Implement authentication and authorization mechanisms using OAuth2 and JWT tokens.
- Configure a security setup that includes OAuth2 for user authentication.
- Issue JWT tokens for authenticated users, and ensure incoming requests validate these tokens.
- Restrict access to endpoints based on user roles (e.g., `USER`, `ADMIN`).
</details>

---

<details>
<summary>Task 4 (Optional) - CRUD application: externalized configuration</summary>

#### Task 4 (Optional) - CRUD application: externalized configuration

**Cost**: 10 points
- Use Spring Profiles to support multiple environments like `local`, `dev`, `stg`, `prod`.
- Create separate configuration files (`application-{profile}.yml`) for each environment with different database properties.
- Enable the correct profile during runtime (e.g., by setting `spring.profiles.active`), and ensure corresponding configuration is applied.
</details>

---

<details>
<summary>Task 5 (Optional) - CRUD application: data migrating</summary>

#### Task 5 (Optional) - CRUD application: data migrating

**Cost**: 10 points
- Select a tool like `Flyway` or `Liquibase` for managing database schema migrations.
- Provide migration scripts or files to create and update the database schema as needed.
- Configure the migration tool to run automatically during the application startup.
</details>

---

<details>
<summary>Task 6 - Actuator</summary>

#### Task 6 - Actuator

**Cost**: 15 points
- Enable Spring Boot Actuator within your application for monitoring and management purposes.
- Implement custom health indicators to monitor application-specific health metrics.
- Add custom metrics for Prometheus or other tools to observe the application's behavior.
</details>

---

<details>
<summary>Task 7 (Optional) - CRUD application: testing</summary>

#### Task 7 (Optional) - CRUD application: testing

**Cost**: 10 points
- Configure an in-memory database (e.g., H2) for test purposes.
- Implement repository tests to validate data access logic.
- Write unit tests for service-level logic.
- Test `RestController` endpoints using `MockMvc`.
- Perform integration tests to validate end-to-end behavior in the application.
</details>

---

#### Point Calculation
- **Mandatory tasks sum**: 70 points (Tasks 1, 2, 3, and 6)
- **Optional tasks sum**: 30 points (Tasks 4, 5, and 7)
- **Total possible points**: 100 points
---
**Pro Tip:** Break down the tasks into manageable steps. Use version control tools (e.g., Git) to commit incremental progress. Ensure documentation and meaningful comments are included for better maintainability.
</details>

<details>
<summary><u><strong>Module 2: RPC Protocols and Data Formats</strong></u></summary>

#### Table of Content

- gRPC
- HTTP/2
- Protobuf
- Rsocket
- Apache Avro
- Apache Thrift


### Task 2. RPC Protocols and Data Formats

#### Preparation
>- In the first task, you will need to write a gRPC client in any other language you like, so you probably need to install some dependencies.
>- You need to install Kafka for the second task (or Docker if you want to run it in a container)

#### Main

---

<details>
<summary>1. **gRPC part** *(40 points)* </summary>

1. **gRPC part** *(40 points)*
    - Create a simple gRPC server application that listens on port 8080 for a request like this (feel free to add more fields)
      ``` json
        {
            "message": "Ping"
        }
      ```
      And responses with something like this (feel free to add more fields)
      ``` json
        {
            "message": "Pong"
        }
      ```
    - Create a simple Java gRPC client application that sends a request to the simple server (share the same proto file), gets a response, and prints it.
    - Create a simple gRPC client application in any other language you like (or ask a trainer/lector for a Python example) that sends a request to the simple server, gets a response, and prints it. Use the same proto file.
    - Start a server and try to communicate with it using the clients you just wrote.

</details>

---

<details>
<summary>2. **Avro part** *(60 points)* </summary>

2. **Avro part** *(60 points)*
    - In this task, you need to create a Kafka producer and consumer using Avro to serialize messages.
    - Create a simple Kafka producer that sends a simple message to a topic serializing it using Avro.
    - Create a simple Kafka consumer which listens to a topic for a message, deserializes the message, and prints it.
    - Start Kafka, create a topic, and run consumer and producer.
    - Try to use different Avro schemas for serialization and deserialization. Observe that
      schema version/id has changed e.g. in schema registry and kafka message payload(bytes 1-4).

</details>

---

</details>


<details>
<summary><u><strong>Module 3: Reactive Programming</strong></u></summary>

#### Table of Content

- Project Reactor and Reactive Core
- Reactive web app with Spring Boot
- Spring WebFlux
- Spring Reactive Data


### Task 3. Reactive Programming

#### Prerequisites
1. Installed database from list of available: https://spring.io/projects/spring-data-r2dbc#overview
2. Java version 17+
3. Gradle
4. Java IDE

---

<details>
<summary>Task 1 - ETL process (40 Points)</summary>

#### Task 1 - ETL process (40 Points)

1. Create data model with following fields:
```json
    "id": int, // id of sport
    "name": string // sport name
```
2. Create Reactive Repository
3. Create Setup class with following functionality:
   3.1. Requests items from https://webservice.rakuten.co.jp/explorer/api/IchibaItem/Search
   3.2. Parse Json Response using reactive pipelines and save objects using reactive repository

</details>

---

<details>
<summary>Task 2 - API for Sports (40 Points)</summary>

#### Task 2 - API for Sports (40 Points)

1. Implement the following API methods using Router Functions:
```
    - POST /api/v1/sport/{sportname]} // create sport with name. make sure that you correctly cach exceptions if sport with provided name already exist
    - GET /api/v1/sport?q=... //search sports by name
```    
2. Implement methods in reactive repository with methods to support API above

</details>

---

<details>
<summary>Task 3 - Refactor ETL process using backpressure (20 Points)</summary>

#### Task 3 - Refactor ETL process using backpressure (20 Points)

1. Modify our ETL implementation to apply backpressure. Tell the upstream to only send 20 elements at a time by using request().

2. Log operations to see that request(20) is calles, followed by 20 onNext() calls, then request(20) again and so on.

</details>

---

</details>

<details>
<summary><u><strong>Module 4:  Security (Security Applications)</strong></u></summary>

#### Table of Content

- Security Overview
- Identification
- Authentication
- Authentication Types
- Authorization
- OAuth
- OpenID Connect



### Task 4.  Security (Security Applications)

#### Security Application Task

#### Necessary Tools

- Java Development Kit 11+
- Apache Maven 3.6.0+
- Git 2.24+
- Spring 5
- Spring Boot 2

#### Task

(20 points)

##### 1.	Create Spring Boot MVC project.
##### 2.	Create REST endpoint "GET /info" that provide random stats (ex: "MVC application"). Test this endpoint.
##### 3.	Add Spring Security module to your project and configure it for authenticated access to all resources. Use email/password combination for it.

(20 points)

##### 4.	Use a non-embedded DB to store users.
##### 5.	Use salt and hashing to store user passwords.
##### 6.	Create additional REST endpoint "GET /about" and configure non-authenticated access to it.

(40 points)
##### 7.	Create one more REST endpoint "GET /admin".
##### 8.	Now you need to add authorised access to "GET /info" and "GET /admin", add "VIEW_INFO", "VIEW_ADMIN" permissions for it. Create 3 users with different combination of permissions.
##### 9.    Create new Login/Logout pages and configure Spring Security to use new Login/Logout.
##### 10.   Add Brute Force protector. BLock user email for 5 minute on 3 unsuccessful login.
##### 11.   Create an endpoint to show blocked users

(20 points)

##### 12.	Implement a new Spring Boot MVC application called "Secret providers". Application should provide page with text form. After sending a secret, application must generate uniq link address, to provide one-time access to secret information. After this information must be removed from application.
##### 13.   User (sender and recipient) must be authorized and have "STANDARD" permission.
##### 14.   Use docker containers to implement solution.

Create pull requests to your mentor with implemented application (-s).

#### References

- [Prevent Brute Force](https://www.baeldung.com/spring-security-block-brute-force-authentication-attempts)
- [Spring Security](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)
- [Build a REST API with Spring](https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
- [Password Hashing](https://www.baeldung.com/java-password-hashing)

</details>

#### NOTES

- To create Queue, Exchange and Binding should processor (application processor).

</details>


<details>
<summary><u><strong>Module 3: Testing</strong></u></summary>

#### Table of Content

- [What to do](#what-to-do)
- [Sub-task 1: Testing strategy](#sub-task-1-testing-strategy)
- [Sub-task 2: Perform different types of testing](#sub-task-2-perform-different-types-of-testing)

### What to do

In this module it is needed to adjust services with adding tests.

### Sub-task 1: Testing strategy

1) For solving this task, come up with a testing strategy and describe approach on how to ensure application stability and testing strategies:
- Unit tests
- Integration tests
- Component tests
- Contract tests
- End-to-end tests
2) Describe it in a short document what approach was chosen and how the combination of the strategies would help to solve task, e.g., either it's going to be 100% **unit tests** and **integration tests** or something else.

### Sub-task 2: Perform different types of testing

1) _Unit tests_: choose JUnit or Spock and choose module that need to be tested.
2) _Integration tests_: choose JUnit or Spock and cover integration layers.
3) _Component tests_: cover component scenarios on a business level, specifying exact scenario or scenarios and expected outcomes in a natural language, preferably using the Cucumber framework.
4) _Contract tests_: cover all contracts that are used in a specific scenario, preferably using the [Spring Cloud Contract](https://spring.io/projects/spring-cloud-contract) or Pact (contract tests should cover BOTH communication styles: synchronous HTTP and messaging, including stubs propagation).
5) _End-to-end tests_: all scenarios should be described in a natural language. Focus is on coverage on the API layer. Cucumber testing framework can be used in this case with the component tests from above.

**Note**

- At least one test should be executed for each test type.


## MY NOTES


### How to make WSL Docker accessible from Windows host:

Run with Powershell (as admin):
```$wslip = ((wsl hostname -I) -split " ")[0]
  $dockerhost = "tcp://" + $wslip + ":2375"
  setx DOCKER_HOST $dockerhost
  Write-Host "Set: setx DOCKER_HOST $dockerhost"
  #get-childitem env:*
  Read-Host -Prompt "Press Enter to exit"
```
This command returns connection address like `tcp://172.25.34.178:2375`
Its address we should add to configuration **c:\Users\<user_name>\.testcontainers.properties**
that testcontainers used to connection with docker
```properties
docker.client.strategy=org.testcontainers.dockerclient.NpipeSocketClientProviderStrategy
docker.host=tcp://172.25.34.178:2375

# docker.host it's internal wsl IP that should be configured to access in WSL 
```

In WSL terminal you should to add address from  the previous step to **/etc/docker/daemon.json**
with come text editor

```
{
  "hosts": [
    "unix:///var/run/docker.sock", 
    "tcp://172.25.34.178:2375"
  ]
}
```
Restart wsl wih help PowerShell:
```
  wsl --shutdown
  wsl -l
```


**Useful links:**

- [Fix the issue with listening docker from host in WSL](https://github.com/testcontainers/testcontainers-java/issues/4958)
- [How to install WSL](https://dev.to/bowmanjd/install-docker-on-windows-wsl-without-docker-desktop-34m9)
- [DB Integration Tests with Spring Boot and Testcontainers](https://www.baeldung.com/spring-boot-testcontainers-integration-test)

</details>