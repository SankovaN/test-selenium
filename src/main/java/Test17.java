import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import static org.junit.Assert.assertTrue;


public class Test17 {
    public static <string> void main(String[] args) {

        //запуск в Firefox
        /*System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\teststore\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
*/
        /*System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium2\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);*/

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium2\\drivers\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("w3c", true);
        WebDriver driver = new ChromeDriver(option);


        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        driver.findElement(By.cssSelector(".row > td:nth-child(3) > a[href*='category_id=2']")).click();



       List<WebElement> elementList = driver.findElements(By.cssSelector(".row > td:nth-child(3) > a[href*='product_id']"));
       int count = elementList.size();

        for (int i = 0; i < count; i++) {

            List<WebElement> elementList1 = driver.findElements(By.cssSelector(".row > td:nth-child(3) > a[href*='product_id']"));
            elementList1.get(i).click();

            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println(l);
            }
            assertTrue(l.equals(""));
            driver.navigate().back();
        }


        //driver.manage().logs().getAvailableLogTypes();

        driver.quit();
        driver=null;
    }
}
