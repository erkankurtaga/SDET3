package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;

public class BaseStaticDriver {
    public static WebDriver driver;

    static {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
    }

    public static void Bekle(int saniye){
        try {
            Thread.sleep((long) saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void BekleKapat(int saniye){
        Bekle(saniye);
        driver.quit();
    }

    public static WebElement getElementById(String id){
        try {
            return driver.findElement(By.id(id));
        }catch(Exception e){
          return null;
        }
    }

    public static WebElement getElementByClassName(String className){
        try {
            return driver.findElement(By.className(className));
        }catch(Exception e){
            return null;
        }
    }

    public static WebElement getElementByTagName(String tagName){
        try {
            return driver.findElement(By.tagName(tagName));
        }catch(Exception e){
            return null;
        }
    }

    public static WebElement getElementByCssSelector(String cssSelector){
        try {
            return driver.findElement(By.cssSelector(cssSelector));
        }catch(Exception e){
            return null;
        }
    }

    public static WebElement getElementByXPath(String xPath){
        try {
            return driver.findElement(By.xpath(xPath));
        }catch(Exception e){
            return null;
        }
    }
}
