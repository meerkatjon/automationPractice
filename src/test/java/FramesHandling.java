import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesHandling {
    public WebDriver driver;
@Test
    public void frames() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Nested Frames")).click();

        //working with multiple frames
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));

        System.out.println(element.getText());

    }
}
