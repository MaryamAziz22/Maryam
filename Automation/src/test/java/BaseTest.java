import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
         public class BaseTest {
    public WebDriver driver;

    @Test
    public void setupDriver() throws InterruptedException {
        // Flow for launching a browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup(); //setting up ChromeDriver binary automatically
        driver = new ChromeDriver(options);
        driver.get("https://demoblaze.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
//      Sign up Flow
        driver.findElement(By.id("signin2")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("sign-username")).sendKeys("AutomationTest123");
        //driver.findElement(By.cssSelector("input[id='sign-username']")).sendKeys("AutomationTest123");
        driver.findElement(By.id("sign-password")).sendKeys("12345");
        driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept(); //Used for managing pop-up
        driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Close'])[2]")).click();
        //        Login Flow
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys("AutomationTest123");
        Thread.sleep(1000);
        driver.findElement(By.id("loginpassword")).sendKeys("12345");
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
        Thread.sleep(2000);

        // Flow for logout
        driver.findElement(By.id("logout2")).click();
         Thread.sleep(2000);
         }
}