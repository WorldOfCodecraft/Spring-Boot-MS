FROM adoptopenjdk:16_36-jre-hotspot as builder
WORKDIR extracted

#The fat-jar file will be added to the Docker image from the Gradle build library, build/libs.
ADD ./build/libs/*.jar app.jar

#MNote, p103, 01
#When it comes to handling the suboptimal packaging of fat-jar files in Docker images,
#Spring Boot addressed this issue in v2.3.0, making it possible to extract the content
#of a fat-jar file into a number of folders.
#By default, Spring Boot creates the following folders after extracting a fat-jar file:
#1. dependencies, containing all dependencies as jar-files
#2. spring-boot-loader, containing Spring Boot classes that know how to start a Spring Boot application
#3. snapshot-dependencies, containing snapshot dependencies, if any
#4. application, containing application class files and resources
RUN java -Djarmode=layertools -jar app.jar extract

FROM adoptopenjdk:16_36-jre-hotspot
WORKDIR application

#MNote, p103, 01
#The Spring Boot documentation recommends creating one Docker layer for each folder in the order listed above.
#After replacing the JDK-based Docker image with a JRE-based image and adding instructions
#for exploding the fat-jar file into proper layers in the Docker image,
#the Dockerfile looks like:
COPY --from=builder extracted/dependencies/ ./
COPY --from=builder extracted/spring-boot-loader/ ./
COPY --from=builder extracted/snapshot-dependencies/ ./
COPY --from=builder extracted/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]