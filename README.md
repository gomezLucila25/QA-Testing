# SauceDemo Login Tests — Selenium · JUnit 5 · Parallel

My first UI automation project in the EPAM track: data-driven login tests for [SauceDemo](https://www.saucedemo.com).

## Test cases

| ID | Scenario | Expected |
|---|---|---|
| UC-1 | Type credentials, clear both, submit | Error: *"Username is required"* |
| UC-2 | Type username and password, clear password, submit | Error: *"Password is required"* |
| UC-3 | Log in with each accepted user and `secret_sauce` | Dashboard title *"Swag Labs"* |

## Implementation

- **Page Object** (`LoginPage`) with **XPath** locators.
- **Data-driven** tests: every accepted username runs through the same test.
- **Parallel execution** with JUnit 5 (concurrent classes and methods, 3 threads).
- Driver manager for **Firefox and Edge**, plus test logging.

## Stack

Java · Selenium WebDriver · JUnit 5 · Hamcrest · Maven

---
👉 See where this ended up: **[selenium-framework-patterns](https://github.com/gomezLucila25/selenium-framework-patterns)**, with design patterns, BDD, Allure and Jenkins.
