# Compilacion
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Ejecucion
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Busca el .jar tanto en /app/target/ como en /target/
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Pasa el puerto de Render dinámicamente si existe, o usa 8080 por defecto
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]