package com.saucedemo.tests;

import com.saucedemo.driver.WebDriverManager;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.LoggerUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private Logger logger;

    @BeforeEach
    public void setup() {
        driver = WebDriverManager.getDriver(System.getProperty("browser", "firefox"));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        logger = LoggerUtil.getLogger(LoginTests.class);
    }

    @AfterEach
    public void tearDown() {
        WebDriverManager.quitDriver();
    }

    @Test
    public void testLoginEmptyCredentials() {
        logger.info("UC-1: Test login with empty credentials");
        loginPage.setUsername("any");
        loginPage.setPassword("any");
        loginPage.setUsername("");
        loginPage.setPassword("");
        loginPage.clickLogin();
        MatcherAssert.assertThat(
                loginPage.getErrorMessage(),
                Matchers.containsString("Username is required")
        );
    }

    @Test
    public void testLoginMissingPassword() {
        logger.info("UC-2: Test login with missing password");
        loginPage.setUsername("any");
        loginPage.setPassword("any");
        loginPage.setPassword("");
        loginPage.clickLogin();
        MatcherAssert.assertThat(
                loginPage.getErrorMessage(),
                Matchers.containsString("Password is required")
        );
    }

    @ParameterizedTest
    @MethodSource("com.saucedemo.utils.DataProvider#validUsers")
    public void testLoginValidCredentials(String username, String password) {
        logger.info("UC-3: Test login with valid credentials: " + username);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        MatcherAssert.assertThat(driver.getTitle(), Matchers.equalTo("Swag Labs"));
    }
}