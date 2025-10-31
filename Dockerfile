# Use OpenJDK 17 as the base image for Java console apps
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the source code to the container
COPY . .

# Compile all Java source files, creating package directories if present
RUN javac -d . *.java

# Set the entry point
CMD ["java", "-cp", ".:/app", "Quickfood"]
