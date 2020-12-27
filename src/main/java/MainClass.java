import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\test-selenium\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://software-testing.ru/edu");
        driver.quit();
    }
}
