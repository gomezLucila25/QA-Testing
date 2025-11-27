# Test Automation Project - SauceDemo Login

## Task Description

**Application URL:** https://www.saucedemo.com/

---

## Test Cases

### UC-1: Test Login form with empty credentials
1. Type any credentials into "Username" and "Password" fields
2. Clear the inputs
3. Hit the "Login" button
4. **Expected Result:** Check the error message: "Username is required"

### UC-2: Test Login form with credentials by passing Username
1. Type any credentials in username
2. Enter password
3. Clear the "Password" input
4. Hit the "Login" button
5. **Expected Result:** Check the error message: "Password is required"

### UC-3: Test Login form with credentials by passing Username & Password
1. Type credentials in username which are under Accepted username sections
2. Enter password as "secret_sauce"
3. Click on Login and validate the title "Swag Labs" in the dashboard
4. Provide parallel execution, add logs for tests and use Data Provider to parametrize tests

**Note:** Make sure that all tasks are supported by these 3 conditions: UC-1, UC-2, UC-3.

---

## Technical Stack

| Component | Technology |
|-----------|-----------|
| **Test Automation Tool** | Selenium WebDriver |
| **Project Builder** | Maven |
| **Browsers** | Firefox, Edge |
| **Location Strategy** | XPath |
| **Test Runner** | JUnit |
| **Assertions** | Hamcrest |

---

## Optional Implementations

- **Design Patterns:**
  - Singleton
  - Adapter
  - Strategy

- **Test Automation Approach:** BDD (Behavior-Driven Development)

- **Logger:** SLF4J

---

## 🚀 Getting Started

*(Add your setup and execution instructions here)*

