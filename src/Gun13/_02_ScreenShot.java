package Gun13;

import Utils.BaseStaticDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class _02_ScreenShot extends BaseStaticDriver {
    public static void main(String[] args) throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement element;

        element = getElementBy(By.id("txtUsername"));
        element.clear();
        element.sendKeys("erkan");

        element = getElementBy(By.id("txtPassword"));
        element.clear();
        element.sendKeys("123456");

        getElementBy(By.id("btnLogin")).click();

        Bekle(1);

        List<WebElement> spanMessage = getElementsBy(By.id("spanMessage"));
        if(spanMessage.size() > 0){
            System.out.println("Login Olamadı. Hata mesajı "+spanMessage.get(0).getText()+" göründü.");

            TakesScreenshot ts = (TakesScreenshot) driver;
            File dosya = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(dosya,new File("ekranGoruntuleri/LoginKontrol.png"));

        }

        BekleKapat(3);
    }
}
