FROM adoptopenjdk/maven-openjdk8 AS builder
WORKDIR /app
COPY . /app
RUN mvn clean install

FROM adoptopenjdk/openjdk8 AS final
WORKDIR /app
COPY --from=builder /app/target/microservice-v1-*.jar /app/
RUN mv microservice-v1-*.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]