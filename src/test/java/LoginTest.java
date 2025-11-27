import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://www.saucedemo.com/";

    @BeforeEach
    public void setUp(){
        System.out.println("Setting up WebDriver for Chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("WebDriver initialized successfully");
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            System.out.println("Closing WebDriver");
            driver.quit();
        }
    }

    @Test
    public void testEmptyCredentials_UC1(){
        System.out.println("Starting UC-1: Test Login form with empty credentials");
        driver.get(BASE_URL);
        System.out.println("Navigated to: " + BASE_URL);

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        System.out.println("Clicking login button without entering credentials");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorText = errorMessage.getText();
        System.out.println("Error message received: " + errorText);

        if(errorText.contains("Username is required")){
            System.out.println("UC-1 PASSED: Error message is correct");
        } else {
            throw new RuntimeException("UC-1 FAILED: Expected 'Username is required' but got: " + errorText);
        }
    }

    @Test
    public void testUsernameOnly_UC2(){
        System.out.println("Starting UC-2: Test Login form with username only");
        driver.get(BASE_URL);
        System.out.println("Navigated to: " + BASE_URL);

        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        System.out.println("Typing username: standard_user");
        usernameField.sendKeys("standard_user");

        System.out.println("Clicking login button without password");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorText = errorMessage.getText();
        System.out.println("Error message received: " + errorText);

        if(errorText.contains("Password is required")){
            System.out.println("UC-2 PASSED: Error message is correct");
        } else {
            throw new RuntimeException("UC-2 FAILED: Expected 'Password is required' but got: " + errorText);
        }
    }

    @Test
    public void testValidCredentials_UC3(){
        System.out.println("Starting UC-3: Test Login with valid credentials");
        driver.get(BASE_URL);
        System.out.println("Navigated to: " + BASE_URL);

        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        System.out.println("Entering credentials - Username: standard_user");
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        System.out.println("Clicking login button");
        loginButton.click();

        WebElement dashboardTitle = driver.findElement(By.xpath("//div[@class='app_logo']"));
        String titleText = dashboardTitle.getText();
        System.out.println("Dashboard title received: " + titleText);

        if(titleText.equals("Swag Labs")){
            System.out.println("UC-3 PASSED: Successfully logged in");
        } else {
            throw new RuntimeException("UC-3 FAILED: Expected 'Swag Labs' but got: " + titleText);
        }
    }
}