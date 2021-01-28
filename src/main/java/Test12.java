import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class Test12 {
    public static <string> void main(String[] args) throws InterruptedException {

        //запуск в Firefox
        /*System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);*/

        //запуск в Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium2\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.cssSelector("a[href*='edit_product']")).click();

        if (!driver.findElement(By.cssSelector("input[type='radio'][value='1']")).isSelected())
            driver.findElement(By.cssSelector("input[type='radio'][value='1']")).click();

        driver.findElement(By.name("name[en]")).sendKeys("TestName");
        driver.findElement(By.name("code")).sendKeys("TestCode");

        if (!driver.findElement(By.cssSelector("input[type='checkbox'][name='categories[]'][value='0']")).isSelected())
            driver.findElement(By.cssSelector("input[type='checkbox'][name='categories[]'][value='0']")).click();

        if (!driver.findElement(By.cssSelector("input[type='checkbox'][name='categories[]'][value='1']")).isSelected())
            driver.findElement(By.cssSelector("input[type='checkbox'][name='categories[]'][value='1']")).click();

        if (!driver.findElement(By.cssSelector("input[type='checkbox'][name='categories[]'][value='2']")).isSelected())
            driver.findElement(By.cssSelector("input[type='checkbox'][name='categories[]'][value='2']")).click();

        Select defaultCategory = new Select(driver.findElement(By.name("default_category_id")));
        defaultCategory.selectByVisibleText("Subcategory");

        if (!driver.findElement(By.cssSelector("input[type='checkbox'][name='product_groups[]'][value='1-2']")).isSelected())
            driver.findElement(By.cssSelector("input[type='checkbox'][name='product_groups[]'][value='1-2']")).click();

        driver.findElement(By.name("quantity")).sendKeys("5");

        Select quantityUnit = new Select(driver.findElement(By.name("quantity_unit_id")));
        quantityUnit.selectByVisibleText("pcs");

        Select deliveryStatus = new Select(driver.findElement(By.name("delivery_status_id")));
        deliveryStatus.selectByVisibleText("3-5 days");

        Select soldOutStatus = new Select(driver.findElement(By.name("sold_out_status_id")));
        soldOutStatus.selectByVisibleText("Temporary sold out");

        File f = new File("image/testimage.jpg");
        driver.findElement(By.name("new_images[]")).sendKeys(f.getAbsolutePath());

        driver.findElement(By.name("date_valid_from")).click();
        driver.findElement(By.name("date_valid_from")).sendKeys("01.01.2021");
        driver.findElement(By.name("date_valid_to")).click();
        driver.findElement(By.name("date_valid_to")).sendKeys("10.12.2021");

        driver.findElement(By.linkText("Information")).click();
        Thread.sleep(1000);

        Select manufacturer = new Select(driver.findElement(By.name("manufacturer_id")));
        manufacturer.selectByVisibleText("ACME Corp.");

        driver.findElement(By.name("keywords")).sendKeys("keywords");
        driver.findElement(By.name("short_description[en]")).sendKeys("short description");
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("description test");
        driver.findElement(By.name("head_title[en]")).sendKeys("head title");
        driver.findElement(By.name("meta_description[en]")).sendKeys("meta description");

        driver.findElement(By.linkText("Prices")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("purchase_price")).sendKeys("15");

        Select price = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        price.selectByVisibleText("Euros");

        driver.findElement(By.name("gross_prices[EUR]")).sendKeys("2");
        driver.findElement(By.name("save")).click();

        assertTrue(driver.findElement(By.linkText("TestName")).isDisplayed());

        driver.quit();
        driver=null;
    }
}
