# Persona Service

Persona is a Spring Boot application for managing user persona information.
It exposes REST endpoints that allow clients to query user profiles by UID or email.

## Prerequisites

- **Java 21**
- **Maven** (or use the provided `mvnw` wrapper)
- **MySQL** running locally with a database named `persona`

## Setup

1. Clone this repository.
2. Ensure MySQL is running and update `src/main/resources/application.yml` with your
   database credentials if needed.
3. Build and start the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   The service will start on port `8084`.

## Example API Usage

Retrieve a user persona by UID:
```bash
curl "http://localhost:8084/api/persona/uid?uID=12345"
```

Retrieve a user persona by email:
```bash
curl "http://localhost:8084/api/persona/email?email=user@example.com"
```
