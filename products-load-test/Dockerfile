FROM adoptopenjdk/maven-openjdk8 AS builder
WORKDIR /app
COPY . /app
RUN mvn clean install

FROM adoptopenjdk/openjdk8 AS final
WORKDIR /app
COPY --from=builder /app/target/products-load-test*.jar /app/
RUN mv products-load-test*.jar api.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "api.jar"]