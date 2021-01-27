import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Test13 {
    public static <string> void main(String[] args) {

        //запуск в Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\teststore\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        /*System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);*/


        driver.get("http://localhost/litecart");

            for (int i = 0; i < 3; i++) {
                List<WebElement> elementList = driver.findElements(By.xpath(".//ul[@class='listing-wrapper products']//li"));

                elementList.get(i).click();
                try {
                    new Select(driver.findElement(By.name("options[Size]"))).selectByValue("Small");
                }
                catch (Exception e) {
                }

                driver.findElement(By.name("add_cart_product")).click();
                wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("quantity")),""+(i+1)));

                driver.navigate().back();
            }

        driver.findElement(By.cssSelector("div#header-wrapper a.link")).click();

        List<WebElement> removeList = driver.findElements(By.name("remove_cart_item"));
        int countRemove = removeList.size();

        while (countRemove !=0 ){
            //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("remove_cart_item"))));
            driver.findElement(By.name("remove_cart_item")).click();
            WebElement table = driver.findElement(By.cssSelector(".dataTable"));
            wait.until(ExpectedConditions.stalenessOf(table));
        }

        driver.quit();
        driver=null;
    }
}
