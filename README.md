# Assignment 3 — Pharmacy & Prescriptions(assignment4 SOLID)
## Java OOP + PostgreSQL (JDBC)

---

## Student Information
- **Name:** Nurasyl Zhambyl
- **Group:** SE-2518
- **Course:** Object-Oriented Programming (OOP)
- **Assignment:** 3

---

## Project Description
This project is a Java console application that demonstrates the use of
**Object-Oriented Programming principles** together with
**database connectivity using JDBC** and **PostgreSQL**.

The application works with a pharmacy domain model and connects to a real
PostgreSQL database to retrieve and display data using SQL queries.

The main goal of this assignment is to show:
- correct OOP structure
- exception handling
- JDBC usage
- interaction between Java and PostgreSQL

---

## Technologies Used
- **Java (JDK 17 +)**
- **PostgreSQL 16**
- **JDBC (Java Database Connectivity)**
- **Maven**
- **IntelliJ IDEA**
- **pgAdmin 4**

---

## Database Overview

The PostgreSQL database is named **Pharmacy** and includes the following tables:

- `patients` — stores patient information
- `doctors` — stores doctors data
- `medicines` — list of medicines with prices
- `prescriptions` — prescriptions issued by doctors
- `prescription_items` — medicines inside prescriptions
- `sales` — sales information related to prescriptions

The database structure and data were verified using **pgAdmin**.
![img_1.png](img_1.png)
![img.png](img.png)


---

## OOP Concepts Used

- **Encapsulation**  
  Data fields are private and accessed through getters/setters.

- **Inheritance**  
  Common fields are placed in `BaseEntity`.

- **Interfaces**  
  `Validatable` and `PricedItem` define shared behavior.

- **Dependency Injection**  
  `Connection` is passed to repositories via constructor.

- **Exception Handling**  
  Custom exceptions and `try-catch` blocks are used to handle runtime problems.

---

## JDBC and Database Connection

The database connection is handled in the `DatabaseConnection` class using JDBC:

java
DriverManager.getConnection(url, user, password)

The PostgreSQL JDBC driver is added via Maven dependency.

All database operations use:

PreparedStatement

ResultSet


This approach prevents SQL injection and ensures safe database access.



Repository Layer

Repositories are responsible for executing SQL queries and mapping database records to Java objects:

PatientRepository

MedicineRepository


Each repository receives a Connection object and performs database operations such as retrieving all records.



Program Execution Flow

1. Application starts from Main.java


2. Database connection is established


3. Repository executes SQL query


4. Results are processed and displayed in the console


5. Connection is closed safely


# Assignment 4 — SOLID & Advanced OOP (Refactoring)

This project is an extension of **Assignment 3 (Pharmacy & Prescriptions)**.
The database schema and domain remain unchanged.
Only the internal Java architecture was refactored.


## Architectural Changes

The project was reorganized into a layered structure:
Main -> Controller -> Service -> Repository -> Database


Each layer has a single responsibility and communicates through abstractions.


## SOLID Principles Applied

- **SRP** – Controllers delegate logic, services handle business rules, repositories handle data access.
- **OCP** – New medicine types can be added by extending `BaseMedicine` without changing existing code.
- **LSP** – `OTCMedicine` and `PrescriptionMedicine` are used via `BaseMedicine` references.
- **ISP** – Small interfaces (`CrudRepository<T>`, `PricedItem`, `Validatable<T>`) are used.
- **DIP** – Services depend on repository interfaces, not implementations.


## Advanced OOP Features

- **Abstract class**: `BaseMedicine`
- **Polymorphism**: different medicine types handled as `BaseMedicine`
- **Generics**: `CrudRepository<T>`
- **Lambda expressions**: sorting medicines by price
- **Reflection (RTTI)**: runtime inspection of class methods
- **DTO**: `MedicineDTO` used as input structure in `Main`


## Composition

- `Prescription` contains a list of `PrescriptionItem`
- `PrescriptionItem` contains a `BaseMedicine`

This represents a has-a relationship in the domain model.


## Demonstration

The `Main` class demonstrates:
- DTO to domain mapping
- Controller → Service → Repository flow
- Polymorphism
- Lambda-based sorting
- Reflection output

<img width="1143" height="573" alt="image" src="https://github.com/user-attachments/assets/8a3ef831-815f-4bc7-aeb1-2df8f36473be" />



