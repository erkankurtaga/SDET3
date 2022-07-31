package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseStaticDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static Robot robot;

    static
    {
        KalanOncekileriKapat();
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize(); // max
        driver.manage().deleteAllCookies();  //

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // bütün webElement için geçerli

        robot = getRobot();
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

    public static WebElement getElementBy(By by){
        try {
            return driver.findElement(by);
        }catch(Exception e){
            return null;
        }
    }

    public static List<WebElement> getElementsBy(By by){
        try {
            return driver.findElements(by);
        }catch(Exception e){
            return null;
        }
    }

    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

     private static Robot getRobot(){
        try {
            return new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
}
