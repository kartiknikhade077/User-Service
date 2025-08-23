# Use Java 21 JDK
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/User-Service-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8082
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
