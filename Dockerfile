FROM ubuntu:latest

WORKDIR /app

ARG JAR_FILE

COPY ${JAR_FILE} app/api.jar

RUN apt-get update

RUN apt-get install unzip -y

EXPOSE 8080

#CMD ["java", "-jar", "api.jar"]