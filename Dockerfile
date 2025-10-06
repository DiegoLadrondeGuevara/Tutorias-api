# Etapa 1: build
FROM maven:3.9.2-eclipse-temurin-17 as build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: runtime
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/tutoria-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
