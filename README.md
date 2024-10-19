
# Java 17 1z0-829 Practice App

This is a Spring Boot web application that displays a series of questions.

## Requirements

- Java 11 or higher
- Maven 3.x
- Spring Boot 2.x.x

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/tobi-akindele/j17-epractice-app.git
   cd j17-epractice-app
   ```

2. Build the project using Maven:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. The application will start on the default port `8080`. You can access it at:

   ```
   http://localhost:8080/question
   ```

## Entry Point

The entry point for the application is the `/question` endpoint, where the user starts interacting with the series of questions. Navigate to `http://localhost:8080/question` to begin the process of answering the questions.
