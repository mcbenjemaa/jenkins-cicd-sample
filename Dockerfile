FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8400

ARG JAR_FILE=target/simple-app.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","/app.jar"]
