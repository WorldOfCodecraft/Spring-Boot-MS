
# Microservice and Spring Boot

The primary objective of our solution is to deliver a framework that leverages the latest advancements in Spring Boot and Microservices architecture. It excels in three key areas: adoptability, robustness, and comprehensive test case coverage.

With comprehensive documentation and best practices, teams can integrate this technology stack effortlessly. We prioritize robustness by incorporating fault-tolerant architecture, ensuring system resilience and uninterrupted service delivery.

## DEMO: REST API, Spring Doc
### DEMO API's using SPRING API:
https://mxmtxt.com/openapi/swagger-ui.html

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

