import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Test14 {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector(".button")).click();

        String mainWindow = driver.getWindowHandle();

        List<WebElement> elementList = driver.findElements(By.cssSelector(".fa-external-link"));
        int count = elementList.size();
        for (int i = 0; i < count; i++){
            elementList.get(i).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Set<String> oldWindows = driver.getWindowHandles();
            oldWindows.remove(mainWindow);
            String newWindow = oldWindows.iterator().next();
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }

        driver.quit();
        driver=null;
    }
}
