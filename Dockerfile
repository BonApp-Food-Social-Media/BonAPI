#------------------------------------------------------------------------------
# /**
#  * @Documented
#  * Dockerfile für eine Spring Boot Anwendung, basierend auf Maven 3.9.4 + Java 21 (Eclipse Temurin).
#  *
#  * @since 1.0
#  * @version 1.1 - Fix: Verwende existierenden Maven-Tag '3.9.4-eclipse-temurin-21'
#  */
#------------------------------------------------------------------------------

# === STAGE 1: Build the application ===
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

# Kopiere pom.xml und lade Abhängigkeiten
COPY pom.xml .
RUN mvn dependency:go-offline

# Kopiere den Rest des Codes
COPY src/ ./src/

# Package die Anwendung
RUN mvn clean package -DskipTests

# === STAGE 2: Create the runtime container ===
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
