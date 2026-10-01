# Selenium BDD Automation Framework

A Java-based Selenium BDD automation framework built using Selenium WebDriver, Cucumber, TestNG and Maven.

The framework supports local and Selenium Grid execution across Chrome, Firefox and Edge, with parallel scenario execution and Docker-based Grid infrastructure.

## Tech Stack

- Java 25
- Selenium 4.49.0
- Cucumber
- TestNG
- Maven
- Selenium Grid 4.49.0
- Docker & Docker Compose
- Apache POI
- Log4j2
- Git & GitHub

## Framework Features

- Cucumber BDD
- Page Object Model
- TestNG parallel execution
- ThreadLocal WebDriver management
- Chrome / Firefox / Edge support
- Local and Grid execution
- Docker Selenium Grid
- Configuration-driven execution
- Excel test data
- Logging
- Retry mechanism
- Cucumber HTML reports

## Architecture

```text
Feature
   ↓
Step Definitions
   ↓
Hooks / TestContext
   ↓
DriverFactory
   ↓
BrowserDriver
   ↓
WebDriver
   ↓
Page Objects
   ↓
Application

````
## For Grid execution:

DriverFactory
      ↓
RemoteWebDriver
      ↓
Selenium Grid
      ↓
Chrome / Firefox / Edge Nodes

````##Project Structure
src/test/java
├── context
├── framework
│   ├── driver
│   ├── factory
│   ├── pages
│   ├── retry
│   ├── testdata
│   └── utils
├── hooks
├── listeners
├── runner
└── stepdefinitions

src/test/resources
├── config
├── features
├── testdata
└── log4j2.xml

reports/
pom.xml
testng.xml
mvnw
mvnw.cmd
.gitignore

````
```##Run Tests
-Local Chrome: .\mvnw.cmd clean test -Pqa -Dbrowser=chrome -Dexecution=local

-Selenium Grid - Chrome: .\mvnw.cmd clean test -Pqa -Dbrowser=chrome -Dexecution=grid

-Selenium Grid - Firefox : .\mvnw.cmd clean test -Pqa -Dbrowser=firefox -Dexecution=grid

-Selenium Grid - Edge : .\mvnw.cmd clean test -Pqa -Dbrowser=edge -Dexecution=grid

```
```##Docker Selenium Grid
-Start Grid: docker compose up -d
-Check containers: docker compose ps
-Stop containers: docker compose stop
-Remove containers and network: docker compose down

```
````##Design Principles
The framework currently follows:
- Single Responsibility Principle
- Open/Closed Principle
- Interface Segregation Principle
- Dependency Inversion Principle
- Page Object Model
- Factory-based driver creation
- Constructor-based dependency injection
- ThreadLocal-based test isolation