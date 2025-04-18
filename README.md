# Student-Campus-Portal
Student Campus Portal is a role-based web system developed to manage core campus services. 

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- MySQL
- Git

---

### 📥 Cloning the Project

```bash
git clone https://github.com/your-username/smart-campus-portal.git
cd smart-campus-portal
```

### 🛠️ Setup Instructions
1. Create your local configuration file:
Copy the provided template:
cp src/main/resources/application-template.properties src/main/resources/application.properties
2. Edit application.properties with your DB credentials and OAuth settings

### ▶️ Running the App
Use Maven to run the Spring Boot application:
```./mvnw spring-boot:run```

Or run it from your IDE (IntelliJ, VS Code, etc.)

### 🧪 Running Tests
```
./mvnw test
```

### 📂 Project Structure
- src/main/java – Java source code

- src/main/resources – Application config files

- .gitignore – Ensures sensitive files like application.properties are not tracked

- README.md – Project instructions

### 🙌 Contributing

1. Fork the repo

2. Create a new branch (git checkout -b feature-xyz)

3. Commit your changes (git commit -am 'Add new feature')

4. Push to the branch (git push origin feature-xyz)

5. Open a Pull Request

