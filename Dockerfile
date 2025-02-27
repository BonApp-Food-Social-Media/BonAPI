#------------------------------------------------------------------------------
# /**
#  * @Documented
#  * This Dockerfile builds and runs a Spring Boot application using Maven and Java 21.
#  * 
#  * @since 1.0
#  * @version 1.1 - Updated to use multi-stage build for smaller final image.
#  */
#------------------------------------------------------------------------------

# === STAGE 1: Build the application ===
FROM maven:3.9.1-eclipse-temurin-21 AS builder

# Create app directory
WORKDIR /app

# Copy pom.xml and fetch dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire source code
COPY src/ ./src/

# Package the application (skipping tests for faster builds)
RUN mvn clean package -DskipTests

# === STAGE 2: Create the runtime container ===
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
