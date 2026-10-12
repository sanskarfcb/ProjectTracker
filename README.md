# Project Task Manager API

A mini-Jira style backend built with Spring Boot. Users create projects, add tasks to them, and track progress.

> Status: work in progress (learning project). See the checklist below for what is done and what is next.

## Tech Stack

- Java, Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Lombok
- Bean Validation (`@Valid`)
- Testing with Postman

## Idea in Simple Words

- A **User** has an account (name, email, password, role).
- A **Project** is a bigger piece of work. Every project has one owner (a User).
- A **Task** is a small piece of work inside a project, assigned to a User, with a status (TODO / IN_PROGRESS / DONE).

```
User --owns--> Project --has many--> Task --assigned to--> User
```

## Architecture

```
Client -> Controller -> Service -> Repository -> Database
```

- **Controller**: receives the HTTP request, validates input, calls the service
- **Service**: business logic (find owner, build entity, map to DTO)
- **Repository**: talks to the database via Spring Data JPA
- **Entity**: database table as a Java class
- **DTO**: what the client sends and receives (entities are never exposed directly, so passwords never leak)

## What Is Done and Working

- [x] `AppUser` entity with `Role` enum (ADMIN / MEMBER), unique email
- [x] `Project` entity with `@ManyToOne` owner relationship and auto `createdAt`
- [x] `UserRepo` and `ProjectRepo`
- [x] Request/Response DTOs for User and Project (password is never returned)
- [x] Constructor injection with `@RequiredArgsConstructor`
- [x] `POST /api/users` (tested, returns 201)
- [x] `POST /api/projects` (tested, returns 201, owner linked correctly)

## In Progress

- [ ] `GET /api/projects/{id}` and `GET /api/projects` (code written, needs testing)
- [ ] `GET /api/users/{id}` and `GET /api/users`

## Planned Next

1. Task entity (linked to Project and User) and Task CRUD
2. Custom `ResourceNotFoundException` and global exception handling with `@ControllerAdvice` (proper 404s instead of 500s)
3. Password hashing and Spring Security with JWT (register / login, protected endpoints)
4. Pagination, filtering and sorting on tasks (`/tasks?status=TODO&page=0&size=10`)
5. Project members (many-to-many) with per-project roles: Owner, Editor, Viewer
6. Flyway migrations
7. Docker + docker-compose
8. Swagger / OpenAPI docs
9. Unit and integration tests
10. iOS app (SwiftUI) that consumes this API

## API Endpoints

| Method | Endpoint | Description | Status |
|---|---|---|---|
| POST | `/api/users` | Create a user | Working |
| POST | `/api/projects` | Create a project for an owner | Working |
| GET | `/api/projects` | List all projects | Testing pending |
| GET | `/api/projects/{id}` | Get one project | Testing pending |
| GET | `/api/users` | List all users | To do |
| GET | `/api/users/{id}` | Get one user | To do |

### Example: create a user

```json
POST /api/users
{
  "name": "Sanskar",
  "email": "sanskar@test.com",
  "password": "test123",
  "role": "ADMIN"
}
```

### Example: create a project

```json
POST /api/projects
{
  "name": "Website Redesign",
  "description": "Redesigning company site",
  "ownerId": 1
}
```

## Known Limitations (for now)

- Passwords are stored as plain text until Spring Security / BCrypt is added
- Missing records throw a generic `RuntimeException` (500) until exception handling is added
- No authentication yet, so `ownerId` is passed manually in the request

## How to Run

1. Install PostgreSQL and create a database: `CREATE DATABASE project_tracker;`
2. Set your DB username and password in `src/main/resources/application.properties`
3. Run the app from your IDE or with `./mvnw spring-boot:run`
4. Test the endpoints with Postman on `http://localhost:8080`
