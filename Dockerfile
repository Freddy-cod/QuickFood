# Use OpenJDK 17 as the base image for Java console apps
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the source code to the container
COPY . .

# Compile all Java source files (handles multiple files)
RUN javac *.java

# Set the entry point to run the main class
CMD ["java", "Quickfood"]