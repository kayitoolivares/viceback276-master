
FROM openjdk:8-jdk-alpine

RUN apk update && apk add tzdata
ENV TZ="America/Mexico_City"

ADD ./viceback276-0.0.2-SNAPSHOT.jar app.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
