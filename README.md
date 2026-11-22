# 🏥 MediVault – Healthcare Document Management System

MediVault is a **Java-based healthcare document management web application** designed to help users store, manage, and access their health-related documents in one centralized platform.

The application is developed using **Spring MVC, Hibernate, and MySQL**, following the MVC architecture to maintain a clean separation between the presentation, business logic, and data access layers.

It provides a structured approach to managing medical information, including prescriptions, laboratory reports, and other healthcare documents, through REST API endpoints.

---

## 🚀 Key Features

### 👤 User Management
- User management through dedicated REST API endpoints.
- Structured handling of user-related information.

### 📄 Healthcare Document Management
- Manage medical documents through dedicated API endpoints.
- Organize and access prescriptions.
- Manage laboratory reports.
- Centralized handling of healthcare-related records.

### 🔗 REST API Integration
- RESTful endpoints for different application modules.
- JSON data handling using Jackson.
- Organized API structure for managing application resources.

### ⚙️ Backend Architecture
- MVC architecture using Spring MVC.
- Hibernate ORM for database operations.
- Connection pooling using HikariCP.
- Separation of configuration, controllers, and persistence logic.

---

## 🛠 Tech Stack

| Technology | Usage |
|---|---|
| **Java** | Backend development |
| **Spring MVC 6** | Web application architecture |
| **Hibernate 6** | ORM and database operations |
| **MySQL** | Relational database |
| **HikariCP** | Database connection pooling |
| **JDBC** | Database connectivity |
| **REST APIs** | Communication between application modules |
| **Jackson** | JSON serialization and deserialization |
| **Maven** | Dependency management and build |
| **Jakarta Servlet & JSTL** | Web application support |
| **Apache Tomcat** | Application server |
| **HTML, CSS, Bootstrap** | Frontend development |

---

## 🏗 Architecture

MediVault follows the **Model-View-Controller (MVC)** architectural pattern.

The application separates responsibilities into different layers:

- **Model:** Represents application data and persistence entities.
- **View:** Handles the presentation layer.
- **Controller:** Processes incoming HTTP requests and manages application flow.
- **Service / Business Logic:** Handles application-specific operations.
- **Persistence Layer:** Uses Hibernate ORM to interact with the MySQL database.

This architecture improves code organization, maintainability, and separation of concerns.

---

## 📂 Project Modules

The application is organized around the following functional modules:

- `Users` – User-related operations.
- `Prescriptions` – Prescription management.
- `Lab Reports` – Laboratory report management.
- `Documents` – Healthcare document management.

The backend exposes REST API routes under the `/api` path.

---

## ▶️ How to Run the Project

### Prerequisites

- Java JDK
- Apache Maven
- MySQL Server
- Apache Tomcat 10.1+ (or a compatible Jakarta Servlet 6.0 container)
- Eclipse IDE or VS Code

### Installation Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/Shashwat200503/Medi-Vault.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Medi-Vault
   ```

3. Configure the MySQL database and update the database connection settings in the application configuration.

4. Build the project using Maven:

   ```bash
   mvn clean package
   ```

5. Deploy the generated WAR file to a compatible Apache Tomcat server.

6. Start the server and access the application through your browser.

---

## 🎯 Learning Outcomes

- Practical experience with Spring MVC application development.
- Understanding of Hibernate ORM and object-relational mapping.
- Implementing RESTful APIs using Java.
- Database integration using MySQL and JDBC.
- Understanding database connection pooling with HikariCP.
- Working with Maven for dependency management.
- Applying MVC architecture and separation of concerns.
- Handling JSON data using Jackson.

---

## 👨‍💻 Author

**Shashwat Mishra**

Computer Science Graduate | Java Backend Developer

Interested in Java, Spring Framework, Backend Development, and Software Engineering.

---

⭐ If you find this project useful, feel free to star the repository!

**Repository:** [MediVault – GitHub](https://github.com/Shashwat200503/Medi-Vault)
