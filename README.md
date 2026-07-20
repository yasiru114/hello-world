# Lab 05 - Maven Session (Part 01)

## Student Information
- **Module:** Software Engineering / Core IT Build Lifecycle
- **Full Name:** Y.N Hirimuthugoda
- **Registration Number:** 245037A
- **Group:** ITM

---

## Task Summary
In this practical laboratory session, a standard Java application was built and managed using Apache Maven[cite: 1].

1. **Project Scaffold Generation**: Created a standardized directory layout (`src/main/java`, `src/test/java`, `pom.xml`) using the `maven-archetype-quickstart` template[cite: 1].
2. **POM Configuration**: Configured custom organization settings (`groupId`) and project names (`artifactId`)[cite: 1].
3. **Property Injection**: Added custom application properties (`app.name`, `app.version`) inside the `pom.xml` configurations[cite: 1].
4. **App Implementation**: Updated `App.java` to dynamically capture and log these injected configuration variables from the system runtime environment using `System.getProperty()`[cite: 1].
5. **Executable JAR Build**: Added and configured the `maven-jar-plugin` to embed the main entry-point class metadata directly into the final packaged binary[cite: 1].

---

## Build and Run Instructions

### Prerequisites
- Java JDK 17 or higher installed
- Apache Maven installed globally[cite: 1]

### Compile and Package the App
To clean old target files and compile a fresh, executable JAR binary, execute:
```bash
mvn clean package
```[cite: 1]

### Run the Application

#### Option 1: Using Classpath
```bash
java -cp target/hello-world-1.0-SNAPSHOT.jar com.mycompany.app.App
```[cite: 1]

#### Option 2: Running as an Executable JAR
```bash
java -jar target/hello-world-1.0-SNAPSHOT.jar
```[cite: 1]