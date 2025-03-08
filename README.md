# e-FIR System Backend

## Overview
This repository contains the backend implementation for the **e-FIR System**, a complaint registration system using **Spring Boot** and **Hibernate** with a **MySQL database**.

## Features
- **User Management**: Register and authenticate users.
- **Complaint Registration**: Users can file complaints, which include details such as FIR ID, complainant details, accused details, and witnesses.
- **Hibernate ORM**: Manages database operations seamlessly.
- **Spring Security with JWT**: Ensures secure authentication.
- **Database Integration**: Uses MySQL as the persistent data store.

## Technologies Used
- **Java 17**
- **Spring Boot** (Spring Web, Spring Data JPA, Spring Security, JWT)
- **Hibernate ORM**
- **MySQL Database**
- **Postman** (for API testing)

## API Endpoints
### User Management
- `POST /user/register` - Registers a new user.
- `POST /user/login` - Authenticates a user and returns a JWT token.

### Complaint Management
- `POST /complaint/register` - Registers a new complaint.
- `GET /complaint/{id}` - Retrieves complaint details by ID.

## Database Schema
### User Table (`user`)
| ID  | Email                | Contact     | Name     | Password      | Role    | User ID  |
|-----|----------------------|------------|----------|--------------|---------|----------|
| 1   | johndoe@example.com | 9876543210 | John Doe | securePass   | Citizen | USER12345 |

### Complaint Table (`complaint`)
| ID  | FIR ID | Filed By (User ID) | Description        | Status   |
|-----|--------|------------------|--------------------|----------|
| 1   | 101    | USER12345         | Theft complaint   | Pending  |

## Expected JSON for Complaint Registration
```json
{
  "firId": 101,
  "description": "Theft complaint",
  "filedBy": { "id": 1 },
  "witnesses": [
    {
      "name": "Jane Smith",
      "address": "456 Elm Street, Townsville",
      "age": 35,
      "aadhar": "234567890123",
      "contact": "8765432109",
      "occupation": "Doctor",
      "personType": "WITNESS"
    }
  ],
  "victims": [
    {
      "name": "John Doe",
      "address": "123 Main Street, Cityville",
      "age": 30,
      "aadhar": "123456789012",
      "contact": "9876543210",
      "occupation": "Engineer",
      "personType": "VICTIM"
    }
  ]
}
```

## Common Issues and Fixes
### 1. **Null Values in Request Body**
- Ensure JSON structure matches the `Complaint` class.
- Verify `@RequestBody` is used in the controller.
- Use **"Content-Type: application/json"** in Postman.

### 2. **SQL Error: 'Field firId doesn't have a default value'**
- Ensure `firId` is properly set in the request.
- Verify database column allows `NULL` or auto-generation if needed.

## Running the Project
### Prerequisites
- Install **Java 17**
- Install **MySQL** and create a database
- Configure `application.properties` with DB credentials

### Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/e-fir-backend.git
   cd e-fir-backend
   ```
2. Build and run the project:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. Test APIs using **Postman** or **cURL**.

## Contributing
Feel free to raise issues or submit PRs to enhance the project.



