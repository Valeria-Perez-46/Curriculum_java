# Compilar la aplicación con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Ejecutar la aplicación con una imagen ligera de Java 17
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /target/springbootproject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]