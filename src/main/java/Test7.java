import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Test7 {


    public static <string> void main(String[] args) {

        //запуск в Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //запуск в Chrome
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\teststore\\drivers\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


        List<WebElement> elementList = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']"));
        int numberMainMenu = elementList.size();

        for (int i = 0; i < numberMainMenu; i++) {

            elementList = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']"));
            elementList.get(i).click();
            driver.findElement(By.cssSelector("td#content>h1"));

            //String h1 = driver.findElement(By.xpath(".//td[@id='content']/h1")).getText();
            //String h1 = driver.findElement(By.cssSelector("td#content>h1")).getText();
            //System.out.println(h1);


            List<WebElement> elementList1 = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']//ul[@class='docs']//li"));
            int numberMenu = elementList1.size();

            for (int j = 0; j < numberMenu; j++) {

                elementList1 = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']//ul[@class='docs']//li"));
                elementList1.get(j).click();
                driver.findElement(By.cssSelector("td#content>h1"));

                //String h = driver.findElement(By.cssSelector("td#content>h1")).getText();
                //System.out.println(h);

            }
        }

        driver.quit();
        driver=null;
    }


}