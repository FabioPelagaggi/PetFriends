# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/petfriend-0.0.1-SNAPSHOT.jar petfriend.jar

# Make port 8989 available to the world outside this container
EXPOSE 8989

# Run the JAR file
ENTRYPOINT ["java", "-jar", "petfriend.jar"]