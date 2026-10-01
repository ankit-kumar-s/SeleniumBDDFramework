# Selenium BDD Automation Framework

A Java-based Selenium BDD automation framework built with Selenium WebDriver, Cucumber, TestNG and Maven.

The framework supports local and remote browser execution across Chrome, Firefox and Edge, including parallel execution and Docker-based Selenium Grid.

## Tech Stack

- Java 25
- Selenium 4.49.0
- Cucumber
- TestNG
- Maven
- Selenium Grid 4.49.0
- Docker / Docker Compose
- Apache POI
- Log4j2
- Git / GitHub

## Features

- Cucumber BDD
- Page Object Model
- TestNG parallel execution
- ThreadLocal WebDriver management
- Chrome / Firefox / Edge
- Local execution
- Selenium Grid execution
- Docker Selenium Grid
- Configuration-driven execution
- Excel test data
- Logging
- Retry mechanism
- Cucumber HTML reporting

## Architecture

### Local Execution

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
```

### Grid Execution

```text
DriverFactory
      ↓
RemoteWebDriver
      ↓
Selenium Grid
      ↓
Chrome / Firefox / Edge Nodes
```

## Project Structure

```text
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
```

## Test Execution

Run Maven commands from:

```text
C:\Users\ankit\IdeaProjects\SeleniumBDDFramework
```

### Local Chrome

```cmd
.\mvnw.cmd clean test -Pqa -Dbrowser=chrome -Dexecution=local
```

### Selenium Grid - Chrome

```cmd
.\mvnw.cmd clean test -Pqa -Dbrowser=chrome -Dexecution=grid
```

### Selenium Grid - Firefox

```cmd
.\mvnw.cmd clean test -Pqa -Dbrowser=firefox -Dexecution=grid
```

### Selenium Grid - Edge

```cmd
.\mvnw.cmd clean test -Pqa -Dbrowser=edge -Dexecution=grid
```

## Docker Selenium Grid

Docker Compose configuration:

```text
C:\Docker\selenium-grid
```

Start Grid:

```cmd
docker compose up -d
```

Check containers:

```cmd
docker compose ps
```

Stop containers:

```cmd
docker compose stop
```

Remove containers and network:

```cmd
docker compose down
```

Grid UI:

```text
http://localhost:4444/ui/
```

## Design Principles

The framework currently applies:

- Single Responsibility Principle
- Open/Closed Principle
- Interface Segregation Principle
- Dependency Inversion Principle
- Page Object Model
- Factory-based driver creation
- Constructor-based dependency injection
- ThreadLocal-based test isolation

## Automated Flows

- Login
- Products
- Cart
- Checkout

**Application Under Test:** SauceDemo

## Reports

Cucumber HTML report:

```text
reports/cucumber/cucumber.html
```

## Current Status

Implemented and verified through Week 10:

- Selenium BDD
- Cucumber + TestNG
- Page Object Model
- Driver Factory
- ThreadLocal
- Test Data
- Logging
- Retry
- Selenium Grid
- Docker Selenium Grid
- Git & GitHub