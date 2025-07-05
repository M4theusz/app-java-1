FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install

FROM amazoncorretto:21-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENV REDIS_HOST=redis
ENV REDIS_PORT=6379

ENTRYPOINT ["java", "-jar", "app.jar"]
