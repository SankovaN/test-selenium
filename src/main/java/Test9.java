import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Test9 {


    public static <string> void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //страны расположены в алфавитном порядке
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        List<WebElement> elementList = driver.findElements(By.cssSelector(".row > td:nth-child(5) > a"));
        int count = elementList.size();

        for (int i = 0; i < count-1; i++){

            String prev = elementList.get(i).getText();
            String next = elementList.get(i+1).getText();

            System.out.println("пара "+ i + " для сравнения") ;
            System.out.println(prev);
            System.out.println(next);

            if (prev.compareTo(next) > 0)
                System.out.println("Сортировка не по алфавиту");
            else
                System.out.println("Сортировка по алфавиту");

        }

        //зоны расположены в алфавитном порядке
        for(int j = 0; j < count; j++){
            List<WebElement> elementList3 = driver.findElements(By.cssSelector(".row > td:nth-child(5) > a"));
            List<WebElement> elementList1 = driver.findElements(By.cssSelector(".row > td:nth-child(6)"));
            String countryZone = elementList1.get(j).getText();
            if(!countryZone.equals("0")) {
                elementList3.get(j).click();

                List<WebElement> elementList2 = driver.findElements(By.cssSelector(".dataTable td:nth-child(3)"));
                int count2 = elementList2.size() - 2;
                for (int i = 0; i < count2; i++){
                    String prev = elementList2.get(i).getText();
                    String next = elementList2.get(i+1).getText();

                    System.out.println("пара "+ i + " для сравнения") ;
                    System.out.println(prev);
                    System.out.println(next);

                    if (prev.compareTo(next) > 0)
                        System.out.println("Сортировка не по алфавиту");
                    else
                        System.out.println("Сортировка по алфавиту");
                }

                driver.navigate().back();
            }
        }

        //зоны расположены в алфавитном порядке
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        List<WebElement> elementList4 = driver.findElements(By.cssSelector(".row > td:nth-child(3) > a"));
        int count4 = elementList4.size();

        for (int i = 0; i < count4; i++){
            List<WebElement> elementList5 = driver.findElements(By.cssSelector(".row > td:nth-child(3) > a"));
            elementList5.get(i).click();

            List<WebElement> elementList6 = driver.findElements(By.cssSelector(".dataTable td:nth-child(3) option[selected='selected']"));
            int count6 = elementList6.size() - 1;
            for (int j=0; j < count6; j++){

                String prev = elementList6.get(j).getText();
                String next = elementList6.get(j+1).getText();

                System.out.println("пара "+ j + " для сравнения") ;
                System.out.println(prev);
                System.out.println(next);

                if (prev.compareTo(next) > 0)
                    System.out.println("Сортировка не по алфавиту");
                else
                    System.out.println("Сортировка по алфавиту");
            }

            driver.navigate().back();

        }

        driver.quit();
        driver=null;
    }
}
