# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## About This Repository

This is the course repository for _Fortgeschrittene Programmierung_ (Advanced Programming), lecture series WWIBE125. It contains demo source code and course materials for a **Java advanced programming lecture aimed at students**.

**Topics covered:** Comparators, Maps, Optionals, Lambdas, Records, Exceptions, Java Stream API, Unit Tests, Mocks, Generics

- Course documentation: https://jappuccini.github.io/java-docs/production/
- Exercise solutions: https://github.com/appenmaier/java_exercises
- Exam exercise solutions: https://github.com/appenmaier/java_exam_exercises

## Build & Test Commands

```bash
# Compile the project
mvn compile

# Run all tests
mvn test

# Run a single test class
mvn test -Dtest=MyTestClass

# Run a single test method
mvn test -Dtest=MyTestClass#myTestMethod

# Package the project
mvn package
```

## Tech Stack

- **Java 21** (Maven compiler target)
- **Maven** build system (`edu.jappuccini:demos`)
- **Lombok** 1.18.36 — used for reducing boilerplate (annotations like `@Data`, `@Builder`, etc.)
- **JUnit 5** (jupiter-api 5.11.3) — test framework
- **Mockito** 5.14.2 — mocking framework for tests
- **Eclipse** — primary IDE (`.project`, `.classpath`, `.settings/` present)

## Javadoc Conventions

All classes and non-trivial methods must have a short Javadoc comment in English. Target audience is students, so keep descriptions clear and beginner-friendly.

**Required tags on every class:**
- `@author Daniel Appenmaier`
- `@version 0.0.1`

**Write Javadoc for:** classes, constructors, public/package methods with non-obvious behavior, fields that need explanation.

**Skip Javadoc for:** getters, setters, and overridden `Object` methods (`toString`, `equals`, `hashCode`).

Example:
```java
/**
 * Represents a bank account with a balance and basic transaction methods.
 *
 * @author Daniel Appenmaier
 * @version 0.0.1
 */
public class BankAccount {

    /**
     * Deposits the given amount into this account.
     *
     * @param amount the amount to deposit (must be positive)
     */
    public void deposit(double amount) { ... }
}
```

## Project Structure

Standard Maven layout:

- `src/main/java/` — production source code
- `src/test/java/` — test source code
- `skript/` — course script/notes in Markdown
- `static/` — PDF downloads (exam, solution, cheatsheet)
- `target/` — build output (gitignored)
