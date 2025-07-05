FROM amazoncorretto:21-alpine

WORKDIR /app

COPY target/desafio-globo-0.0.1-SNAPSHOT.jar desafio-globo-0.0.1-SNAPSHOT.jar

ENV REDIS_HOST=redis
ENV REDIS_PORT=6379

ENTRYPOINT ["java", "-jar", "desafio-globo-0.0.1-SNAPSHOT.jar"]
