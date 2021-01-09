import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Test8 {


    public static <string> void main(String[] args) {

        //запуск в Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);


        driver.get("http://localhost/litecart");

        List<WebElement> elementList = driver.findElements(By.xpath(".//ul[@class='listing-wrapper products']//li"));
        int count = elementList.size();
        //System.out.println(count);

        for (int i = 0; i < count; i++) {

            WebElement product = elementList.get(i);

            int count1 = product.findElements(By.xpath(".//div[starts-with(@class, 'sticker')]")).size();
            if (count1 != 1) System.out.println("Нет стикера");
        }

        driver.quit();
        driver=null;
    }


}
