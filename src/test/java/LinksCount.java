import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinksCount {

    public WebDriver driver;

    @Test
    public void links(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.findElements(By.tagName("a")).size());

    }

}
