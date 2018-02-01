# dockerize spring boot
- https://hub.docker.com/_/openjdk/
  - openjdk:<version>
  - openjdk:alpine # lack git/bash

## spring boot
### run
```
mvn spring-boot:run
```
goto http://localhost:8080/
### package & run
```
mvn clean package
java -jar target/*.jar
```
## docker
### Dockerfile
```
FROM openjdk:8-jdk-alpine
COPY target/*.jar /usr/src/boot/
WORKDIR /usr/src/boot
EXPOSE 8080
CMD ["java", "-jar", "spring-boot-0.0.1-SNAPSHOT.jar"]
```
## build image
```
docker build -t spring-boot .
```
### docker run
```
docker run -d -p 8080:8080 --name=boot spring-boot
```
goto http://localhost:8080

## compose
### docker-compose.yml
