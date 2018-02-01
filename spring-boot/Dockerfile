FROM openjdk:8-jdk-alpine
COPY target/*.jar /usr/src/boot/
WORKDIR /usr/src/boot
EXPOSE 8080
CMD ["java", "-jar", "spring-boot-0.0.1-SNAPSHOT.jar"]
