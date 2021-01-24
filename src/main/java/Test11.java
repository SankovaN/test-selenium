import com.sun.deploy.cache.BaseLocalApplicationProperties;
import javafx.scene.input.DataFormat;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test11 {

    public static WebDriver driver;

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Calendar cal =Calendar.getInstance();
        String newmail = "test+" + cal.getTimeInMillis() + "@testmail.ru";

        driver.get("http://localhost/litecart");
        //driver.get("https://litecart.stqa.ru/en/");

        //createAccount
        driver.findElement(By.cssSelector("form[name='login_form'] table tr:nth-child(5)")).click();

        driver.findElement(By.cssSelector(".select2-selection__rendered")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("United States" + Keys.ENTER);

        driver.findElement(By.cssSelector("select[name='zone_code']")).click();
        driver.findElement(By.cssSelector("select[name='zone_code'] option[value='AK']")).click();

        driver.findElement(By.name("firstname")).sendKeys("имя");
        driver.findElement(By.name("lastname")).sendKeys("фамилия");
        driver.findElement(By.name("address1")).sendKeys("адрес");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("город");

        driver.findElement(By.name("email")).sendKeys(newmail);
        driver.findElement(By.name("phone")).sendKeys("1234567891");
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("confirmed_password")).sendKeys("12345678");
        driver.findElement(By.name("create_account")).click();

        //logout
        driver.findElement(By.cssSelector("div#box-account div.content li:last-child a")).click();

        //login
        driver.findElement(By.name("email")).sendKeys(newmail);
        driver.findElement(By.name("password")).sendKeys("12345678");
        driver.findElement(By.name("login")).click();

        //logout
        driver.findElement(By.cssSelector("div#box-account div.content li:last-child a")).click();

        driver.quit();
        driver=null;
    }
}
