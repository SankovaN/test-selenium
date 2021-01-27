import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Test10 {
    public static <string> void main(String[] args) {

        /*//запуск в Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);*/

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://localhost/litecart");

        String txt = driver.findElement(By.cssSelector("div#box-campaigns .name")).getText();
        String oldPrice = driver.findElement(By.cssSelector("div#box-campaigns .regular-price")).getText();
        String price = driver.findElement(By.cssSelector("div#box-campaigns .campaign-price")).getText();
        String oldPriceColor = driver.findElement(By.cssSelector("div#box-campaigns .regular-price")).getCssValue("color");
        String oldPriceDecoration = driver.findElement(By.cssSelector("div#box-campaigns .regular-price")).getCssValue("text-decoration");
        String PriceColor = driver.findElement(By.cssSelector("div#box-campaigns .campaign-price")).getCssValue("color");
        String PriceColorFont = driver.findElement(By.cssSelector("div#box-campaigns .campaign-price")).getTagName();
        String PriceSize = driver.findElement(By.cssSelector("div#box-campaigns .campaign-price")).getCssValue("font-size").substring(0,2);
        String oldPriceSize = driver.findElement(By.cssSelector("div#box-campaigns .regular-price")).getCssValue("font-size").substring(0,4);

        double intPriceSize = Double.parseDouble(PriceSize);
        double intOldPriceSize = Double.parseDouble(oldPriceSize);


        //цена на главной странице серая
        Color color = Color.fromString(oldPriceColor);
        int colorRed = color.getColor().getRed();
        int colorGreen = color.getColor().getGreen();
        int colorBlue = color.getColor().getBlue();

        if (colorRed == colorGreen && colorGreen == colorBlue)
            System.out.println("цена на главной странице серая");
        else
            System.out.println("цена на главной странице не серая");

        //цена на главной странице зачеркнутая
        if (oldPriceDecoration.contains("line-through"))
            System.out.println("цена на главной странице зачеркнутая");
        else
            System.out.println("цена на главной странице не зачеркнутая");

        //акционная цена на главной странице красная
        Color colorNew = Color.fromString(PriceColor);
        int colorGreenNew = colorNew.getColor().getGreen();
        int colorBlueNew = colorNew.getColor().getBlue();

        if (colorGreenNew == 0 && colorBlueNew == 0)
            System.out.println("акционная цена на главной странице красная");
        else
            System.out.println("акционная цена на главной странице не красная");

        //акционная цена на главной странице жирная
        if (PriceColorFont.contains("strong"))
            System.out.println("акционная цена на главной странице жирная");
        else
            System.out.println("акционная цена на главной странице не жирная");

        //акционная цена на главной странице крупнее, чем обычная
        if (intPriceSize > intOldPriceSize)
            System.out.println("акционная цена на главной странице крупнее, чем обычная");
        else
            System.out.println("акционная цена на главной странице меньше, чем обычная");


        driver.findElement(By.cssSelector("div#box-campaigns > div > ul > li > .link")).click();

        String txt1 = driver.findElement(By.cssSelector("#box-product .title")).getText();
        String oldPrice1 = driver.findElement(By.cssSelector("#box-product .regular-price")).getText();
        String price1 = driver.findElement(By.cssSelector("#box-product .campaign-price")).getText();
        String oldPriceColor1 = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("color");
        String oldPriceDecoration1 = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("text-decoration");
        String PriceColor1 = driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("color");
        String PriceColorFont1 = driver.findElement(By.cssSelector("#box-product .campaign-price")).getTagName();
        String PriceSize1 = driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("font-size").substring(0,2);
        String oldPriceSize1 = driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("font-size").substring(0,2);

        int intPriceSize1 = Integer.parseInt(PriceSize1);
        int intOldPriceSize1 = Integer.parseInt(oldPriceSize1);


        if (txt.equals(txt1))
            System.out.println("текст названия товара совпадает");
        else
            System.out.println("текст названия товара не совпадает");

        if (oldPrice.equals(oldPrice1))
            System.out.println("цена совпадает");
        else
            System.out.println("цена не совпадает");

        if (price.equals(price1))
            System.out.println("акционная цена совпадает");
        else
            System.out.println("акционная цена не совпадает");

        //цена на странице продукта серая
        Color color1 = Color.fromString(oldPriceColor1);
        int colorRed1 = color1.getColor().getRed();
        int colorGreen1 = color1.getColor().getGreen();
        int colorBlue1 = color1.getColor().getBlue();

        if (colorRed1 == colorGreen1 && colorGreen1 == colorBlue1)
            System.out.println("цена на странице продукта серая");
        else
            System.out.println("цена на странице продукта не серая");

        //цена на странице продукта зачеркнутая
        if (oldPriceDecoration1.contains("line-through"))
            System.out.println("цена на странице продукта зачеркнутая");
        else
            System.out.println("цена на странице продукта не зачеркнутая");

        //акционная цена на странице продукта красная
        Color colorNew1 = Color.fromString(PriceColor1);
        int colorGreenNew1 = colorNew1.getColor().getGreen();
        int colorBlueNew1 = colorNew1.getColor().getBlue();

        if (colorGreenNew1 == 0 && colorBlueNew1 == 0)
            System.out.println("акционная цена на странице продукта красная");
        else
            System.out.println("акционная цена на странице продукта не красная");

        //акционная цена на странице продукта жирная
        if (PriceColorFont1.contains("strong"))
            System.out.println("акционная цена на странице продукта жирная");
        else
            System.out.println("акционная цена на странице продукта не жирная");

        //акционная цена на странице продукта крупнее, чем обычная
        if (intPriceSize1 > intOldPriceSize1)
            System.out.println("акционная цена на странице продукта крупнее, чем обычная");
        else
            System.out.println("акционная цена на странице продукта меньше, чем обычная");


          driver.quit();
          driver=null;
    }

}
