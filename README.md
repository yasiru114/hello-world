# README: Introduction to Maven Lab Guide

Maven is a powerful build automation and dependency management tool used to handle the complete lifecycle of a software project[cite: 1]. It automates tasks such as compiling source code, managing external dependencies, running test suites, packaging artifacts, and installing builds[cite: 1].

---

## 🛠️ Maven Installation Guide

### Windows
1. **Download Maven**:
   * Visit the official download page: `https://maven.apache.org/download.cgi`[cite: 1]
   * Download the latest Apache Maven binary ZIP file (e.g., `apache-maven-3.8.4`)[cite: 1].
2. **Extract Files**:
   * Create an installation directory (e.g., `C:\Program Files\Apache\`)[cite: 1].
   * Extract the ZIP contents to folder `C:\Program Files\Apache\apache-maven-3.8.4`[cite: 1].
3. **Configure Environment Variables**:
   * Open **System Properties** > **Advanced System Settings** > **Environment Variables**[cite: 1].
   * Under **System variables**, create a new variable:
     * **Variable name**: `MAVEN_HOME`[cite: 1]
     * **Variable value**: `C:\Program Files\Apache\apache-maven-3.8.4`[cite: 1]
   * Edit the **Path** system variable, click **New**, and add `%MAVEN_HOME%\bin`[cite: 1].
4. **Verify Installation**:
   * Open Terminal/Command Prompt and run[cite: 1]:
     ```bash
     mvn -version
     ```[cite: 1]

### macOS
Install via Homebrew[cite: 1]:
```bash
brew install maven
```[cite: 1]

### Linux (Ubuntu/Debian)
Install via APT[cite: 1]:
```bash
sudo apt install maven
```[cite: 1]

---

## 🚀 Creating a New Project

To generate a standard Java project structure using a Maven archetype, execute[cite: 1]:

```bash
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=hello-world -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```[cite: 1]

### Command Parameter Breakdown:
* `mvn`: Invokes the Maven command-line utility[cite: 1].
* `archetype:generate`: Generates a new project from a project template/blueprint[cite: 1].
* `-DgroupId=com.mycompany.app`: Unique package identifier for your project organization[cite: 1].
* `-DartifactId=hello-world`: Project name/artifact identifier[cite: 1].
* `-DarchetypeArtifactId=maven-archetype-quickstart`: Standard Java application archetype template[cite: 1].
* `-DarchetypeVersion=1.4`: Version of the quickstart archetype[cite: 1].

---

## 📁 Directory Structure

Executing the archetype generation produces the standard Maven project tree[cite: 1]:

```text
hello-world/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── mycompany/
    │               └── app/
    │                   └── App.java
    └── test/
        └── java/
            └── com/
                └── mycompany/
                    └── AppTest.java
```[cite: 1]

* `src/main`: Contains application source code[cite: 1].
* `src/test`: Contains test cases and unit tests[cite: 1].
* `pom.xml`: Project Object Model file controlling dependencies, configurations, and build settings[cite: 1].

---

## 📄 Understanding `pom.xml`

The `pom.xml` file is the core configuration unit in Maven[cite: 1].

### Key XML Structure
```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  
  <!-- Project Coordinates -->
  <groupId>com.example</groupId>
  <artifactId>my-project</artifactId>
  <version>1.0.0</version>
  
  <!-- Custom Properties -->
  <properties>
    <java.version>1.8</java.version>
    <app.name>HelloWorldApp</app.name>
    <app.version>1.0.0</app.version>
  </properties>
  
  <!-- Dependencies -->
  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>5.3.8</version>
    </dependency>
  </dependencies>
  
  <!-- Build Plugins -->
  <build>
    <plugins>
      <!-- Compiler Plugin -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
      
      <!-- Executable JAR Plugin -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.2.0</version>
        <configuration>
          <archive>
            <manifest>
              <mainClass>com.mycompany.app.App</mainClass>
            </manifest>
          </archive>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```[cite: 1]

---

## ⚙️ Essential Maven Commands

| Command | Description |
| :--- | :--- |
| `mvn clean` | Deletes the `target` directory containing previous build outputs[cite: 1]. |
| `mvn compile` | Compiles application source code[cite: 1]. |
| `mvn test` | Runs tests using test frameworks configured in the project[cite: 1]. |
| `mvn package` | Bundles compiled code into its distribution format (e.g., JAR/WAR)[cite: 1]. |
| `mvn install` | Stores the package into the local repository (`~/.m2/repository`)[cite: 1]. |
| `mvn clean install` | Cleans target files then performs compile, test, package, and installation steps[cite: 1]. |
| `mvn clean package` | Cleans target files then packages the compiled artifact[cite: 1]. |

---

## 💻 Running the Executable Project

### 1. Execute via Classpath Flag
To run the compiled class directly from the JAR output[cite: 1]:
```bash
java -cp target/hello-world-1.0-SNAPSHOT.jar com.mycompany.app.App
```[cite: 1]

### 2. Execute directly via Runnable JAR
Once the `maven-jar-plugin` entry with `<mainClass>` is added to `pom.xml`, compile and execute directly using[cite: 1]:
```bash
java -jar target/hello-world-1.0-SNAPSHOT.jar
```[cite: 1]

### Example Java Application Code (`App.java`)
Reading POM system properties within Java[cite: 1]:

```java
package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        String appName = System.getProperty("app.name");
        String appVersion = System.getProperty("app.version");
        
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
    }
}
```[cite: 1]