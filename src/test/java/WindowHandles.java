import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public WebDriver driver;

    @Test
    public void handlesWindow() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();


        //click "multiple windows" link in homepage
        driver.findElement(By.linkText("Multiple Windows")).click();
        Thread.sleep(1000);
        //click the link in the navigating page
        driver.findElement(By.linkText("Click Here")).click();

        //use it when need to right click a link and open in new tab/window
//        Actions a = new Actions(driver);
//       a.contextClick(element).sendKeys(Keys.ENTER).build().perform();
//        a.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.className("example")).getText());

        driver.switchTo().window(parentId);

        System.out.println(driver.findElement(By.className("example")).getText());
    }
}
