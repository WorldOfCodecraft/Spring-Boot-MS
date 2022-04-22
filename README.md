
# Microservice and Spring Boot

The primary objective of our solution is to deliver a framework that leverages the latest advancements in Spring Boot and Microservices architecture. It excels in three key areas: adoptability, robustness, and comprehensive test case coverage.

With comprehensive documentation and best practices, teams can integrate this technology stack effortlessly. We prioritize robustness by incorporating fault-tolerant architecture, ensuring system resilience and uninterrupted service delivery.

## DEMO: REST API, Spring Doc
### LIVE SERVER DEMO:
https://mxmtxt.com/openapi/swagger-ui.html


## DEMO APS's portal
### 01 API PORTAL
1. Used to switch between sites, when multiple sites are available
2. Used to show the API for create action API, you'll find very detailed documentation and an embedded tool to test requests
3. Used to show the API for get action API, the tool in this API can be used to retrieve data
4. Used to show the API for delete action API, the tool in this API can be used to delete data.
5. Other schemas for information, showing the format of information entities used to transfer

### Tips: The demo server has backups, feel free to try dangerous things :)
![alt text](https://github.com/WorldOfCodecraft/Spring-Boot-MS/blob/master/res/01-OpenAI.png?raw=true)

### 02 Function Area

6. Click the "Try it out" button to open an online tool to test API!
![alt text](https://github.com/WorldOfCodecraft/Spring-Boot-MS/blob/master/res/02-API-test-1.png?raw=true)

### Tips: For test creation usages, you may want to try 2222, or any numbers more than 5 digits
7. Edit the nubmer at 2, and click button 3 to execute
![alt text](https://github.com/WorldOfCodecraft/Spring-Boot-MS/blob/master/res/03-API-test-2.png?raw=true)

### Read the response
8. Response will be displayed at 4, and you will find the result code, and there's a section below this section explaining the codes
![alt text](https://github.com/WorldOfCodecraft/Spring-Boot-MS/blob/master/res/04-API-test-3.png?raw=true)

### DEMO TEST SCRIPT
### There's a "TEST ALL" bash script file under the root
### It runs under standard Unix/Linux env, and can be easily modified to fit Windows Terminal
![alt text](https://github.com/WorldOfCodecraft/Spring-Boot-MS/blob/master/res/05-Prj-test-1.png?raw=true)

### There are five parts of the test file
1. Cleaning part, will remove all orphans
2. Create new containers
3. Will test composite API, the API exposed to outside
4. Will test not only the existed one, but also non-existed ones
5. Will give an overall feedback
![alt text](https://github.com/WorldOfCodecraft/Spring-Boot-MS/blob/master/res/06-Prj-test-2.png?raw=true)



## Deployment

To deploy this project run the following commands under the project root

```bash
  ./gradlew build
  docker-compose build
```


## Installation

To deploy this project run the following commands under the project root

```bash
    docker-compose up
```

## Running Tests

To test this project run the following commands under the project root

```bash
  ./test-em-all.bash start stop
```



## Tech Stack

**Framework/Platform:** Spring Boot, Docker

**API Development/Documentation:** Spring WebFlux, Springdoc-openapi,
OpenAPI, Swagger

**Data Storage:** Spring Data, MongoDB, MySQL, Testcontainers

**Message-based Microservices:** Spring Cloud Stream

## Upcoming Integrations

### Reactive Programming:

**Reactive approach**: Explains the importance of a reactive approach and how to develop end-to-end reactive services.

### Service Development and Testing:

**Non-blocking synchronous RESTful APIs**: Teaches how to develop and test non-blocking synchronous RESTful APIs.

**Asynchronous event-driven services**: Covers the development and testing of asynchronous event-driven services.

### Service Discovery and Load Balancing:

**Netflix Eureka**: Shows how to use Netflix Eureka in Spring Cloud for service discovery. Microservices are configured to use Spring Cloud LoadBalancer to find other microservices. Automatic registration of microservices and load balancing to new instances is achieved.

### Edge Server and API Exposure:

**Spring Cloud Gateway**: Guides on hiding microservices behind an edge server using Spring Cloud Gateway. It also covers exposing select APIs and hiding the internal complexity of the microservices from external consumers.

### API Security:

**OAuth 2.0**: Explains how to protect exposed APIs using OAuth 2.0 authorization server based on Spring Authorization Server. It includes configuring the edge server and composite service to require valid access tokens issued by the authorization server.

**OpenID Connect**: Demonstrates replacing the internal OAuth 2.0 authorization server with an external OpenID Connect provider from Auth0.

### Centralized Configuration Management:

**Spring Cloud Config Server**: Covers the addition of a Spring Cloud Config Server to collect configuration files from microservices in a central repository. Microservices are configured to retrieve their configuration from the Config Server at runtime.

### Resilience and Fault Tolerance:

**Resilience4j**: Explains how to utilize Resilience4j capabilities to improve resilience in microservices. This includes adding retry mechanisms, circuit breakers, and fallback methods to handle failures and provide best-effort responses.

### Distributed Tracing:

**Zipkin**: Demonstrates using Zipkin to collect and visualize tracing information in distributed systems.

**Spring Cloud Sleuth**: Covers the integration of Spring Cloud Sleuth to add trace IDs to requests, enabling visualization of request chains between cooperating microservices.

