
# Microservice and Spring Boot

Used to implement new features, ideas, and tests


## Optimizations

It would be preferable to setup all the modules in their own scopes, so that they will have their own version control.
However, we want to keep the deployment simple so we made api and util integrated within the project.

## TODO

The business logic should be added when implementing the microservices.
This should ensure that business logic is separated from the protocol-specific code, 
making it easier both to test and reuse. 

## Starting docker

To run a specific microservice as a docker

`docker run --rm -p8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" product-service`

_--rm option tells Docker to clean up the container once we stop the execution from the Terminal using Ctrl + C
With the -e option, specifies environment variables, it tells Spring what profiles to use._

