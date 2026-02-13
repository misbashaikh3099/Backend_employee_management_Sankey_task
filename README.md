# Employee Management (Spring Boot)

## Objective
Develop a RESTful backend service to manage employees, departments, and reporting managers.

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## Features Implemented

### Employee Management
- Create employee
- Update employee
- Delete employee
- Fetch employee with department & manager

### Department Management
- Create department
- Get all departments
- Delete department (blocked if employees exist)

---

## Business Rules Implemented

1. Employee details fetched with department and manager using JOIN.
2. Deleting manager sets manager_id = NULL for subordinates.
3. Department deletion blocked if employees exist.
4. Referential integrity enforced using foreign keys.

---

## Middleware

Global logging filter logs:
- HTTP Method
- Endpoint
- Response Status
- Execution Time

---

## Database Tables

### Employee
- id (PK)
- first_name
- last_name
- email (unique)
- department_id (FK)
- manager_id (self FK)
- created_at
- updated_at

### Department
- id (PK)
- name (unique)

---

## API Endpoints

### Employee APIs

| Method | Endpoint |
|--------|----------|
| POST | /api/employees |
| GET | /api/employees |
| GET | /api/employees/{id} |
| PUT | /api/employees/{id} |
| DELETE | /api/employees/{id} |

---

### Department APIs

| Method | Endpoint |
|--------|----------|
| POST | /api/departments |
| GET | /api/departments |
| DELETE | /api/departments/{id} |

---

## How to Run

1. Clone repository
2. Configure MySQL in `application.properties`
3. Run Spring Boot application

---

## Postman Testing Steps

1. Create Department
2. Create Manager Employee
3. Create Subordinates
4. Test JOIN Fetch
5. Test Manager Deletion Rule
6. Test Department Deletion Rule

---

## Author
Misba Shaikh
