## Computer Interface Programming Course Final Project

# Donation and Fundraising Management API

A Spring Boot application to manage donation campaigns, donors, donations, and receipts. It includes audit logging and API key security for access control. Uses H2 in-memory database for easy testing and development.

---

## Features

- Manage **Campaigns** with details, goals, and donations.
- Track **Donors** and their donations.
- Generate **Receipts** for donations.
- Audit log actions for transparency.
- API key-based security to restrict access.
- RESTful API endpoints.
- Embedded H2 database with web console support.

---

## Technologies

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Jakarta Servlet API
- Maven or Gradle (your choice)

---

## Getting Started

### Prerequisites

- Java 17 or higher installed
- Maven or Gradle build tool installed
- An IDE like IntelliJ IDEA, VSCode, or Eclipse (optional)

### Configuration

Add your API key in `application.properties`:

```properties
security.api.key=your-secure-api-key
spring.datasource.url=jdbc:h2:mem:fundraisingdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=your-password
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## Running the Application
```bash
./mvnw spring-boot:run
# or for Gradle
./gradlew bootRun
```

## Accessing H2 Console

### Open your browser and navigate to:

```bash
http://localhost:8080/h2-console
```

### and for the public domain navigate to:

```bash
http://dnf-api.sourcico.click/status
```

## Using the API

### All requests must include the X-API-Key header with the correct API key.
### Example with curl:

```bash
curl -H "X-API-Key: your-secure-api-key" http://localhost:8080/campaigns
```

### Example for the public domain:

```bash
curl -H "X-API-Key: your-secure-api-key" http://dnf-api.sourcico.click/campaigns
```

## Project Structure
```bash
src/main/java
├── com.example
│   ├── config       # API key filter and configuration
│   ├── controller   # REST controllers
│   ├── entity       # JPA entities (Campaign, Donation, Donor, Receipt, AuditLog)
│   ├── repository   # Spring Data JPA repositories
│   └── service      # Business logic services
```

## Database Schema

- AuditLog: Tracks all important actions.
- Campaign: Represents fundraising campaigns.
- Donation: Records donations linked to campaigns and donors.
- Donor: Stores donor information.
- Receipt: Receipt data for donations.

## API Key Security

### The API is secured with an API key that must be included in the X-API-Key header on every request. 
### Unauthorized requests will receive a 401 response with the message:

```vbnet
Unauthorized: Invalid or missing API Key!
```

### This is implemented via a custom servlet filter (ApiKeyFilter) configured in Spring Boot.

## Notes

- The H2 database is in-memory and resets on each app restart. For production, replace it with a persistent database.
- Audit logs provide transparency and traceability for operations.
- API key security helps restrict access to authorized users only.
