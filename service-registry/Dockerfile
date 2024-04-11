# Use a base image with OpenJDK 17
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/service-registry-1.0.0.jar /app/service-registry.jar

# Expose the port that the Spring Boot application listens on
EXPOSE 8070

# Define the command to run the Spring Boot application
CMD ["java", "-jar", "service-registry.jar"]