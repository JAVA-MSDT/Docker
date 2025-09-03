# Stage 1: The Build Stage (name it 'builder')
FROM maven:3-eclipse-temurin-21 AS builder
# Set the working directory inside the container for the build steps
WORKDIR /Docker-Demo
# Copy the Project Object Model (pom.xml) file first.
# This is a separate step to leverage Docker's build cache.
# As long as the POM doesn't change, the downloaded dependencies are reused.
COPY pom.xml .
# Download all project dependencies (the 'go-offline' goal is not perfect but helps)
RUN mvn dependency:go-offline -B
# Copy the actual application source code into the container
COPY src ./src
# Package the application into a JAR file, skipping tests for a faster build.
# The output will be in /app/target/*.jar
RUN mvn package -DskipTests

# Stage 2: The Runtime Stage - creates the final, lean production image
FROM eclipse-temurin:21-jre-alpine
# Set the working directory for the runtime
WORKDIR /Docker-Demo
# Copy the JAR file from the builder stage to the current runtime stage.
COPY --from=builder /Docker-Demo/target/*.jar Docker-Demo-snapshot.jar
# Tell Docker that the container will listen on port 8080 at runtime.
# This is documentation; it doesn't actually publish the port
EXPOSE 8080
# The command to run when the container starts.
# Using the "exec form" for proper signal handling (e.g., SIGTERM for graceful shutdown).
ENTRYPOINT ["java", "-jar", "Docker-Demo-snapshot.jar"]