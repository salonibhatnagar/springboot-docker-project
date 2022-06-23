FROM openjdk:16-alpine3.13
MAINTAINER saloni bhatnagar<saloni@gmail.com>
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/usermanagement-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} usermanagement.jar
ENTRYPOINT ["java","-jar","/usermanagement.jar"]
