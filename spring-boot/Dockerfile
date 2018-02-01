FROM openjdk:8-jdk-alpine
COPY target/spring-boot-0.0.1-SNAPSHOT.jar /usr/src/app.jar
WORKDIR /usr/src
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
