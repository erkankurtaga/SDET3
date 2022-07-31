package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/*
    1- https://www.youtube.com/ adresine gidiniz
    2- "Selenium" kelimesi ile video aratınız.
    3- Listelenen sonuçlarda 80 videoaya kadar lsiteyi uzatınız.
    4- Son videonun title ını yazdırınız.
*/

public class _07_YouTube_Scroll extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.youtube.com/");

        wait.until(ExpectedConditions.visibilityOf(getElementBy(By.id("search-input"))));

        getElementBy(By.cssSelector("#search-input input")).sendKeys("Selenium");
        getElementBy(By.id("search-icon-legacy")).click();

        wait.until(ExpectedConditions.titleIs("Selenium - YouTube"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        int sonucSayisi=0;
        WebElement element;

        List<WebElement> list;
        do {
           list = driver.findElements(By.tagName("ytd-playlist-renderer"));
           element = list.get(list.size()-1);
           sonucSayisi += list.size();
           js.executeScript("arguments[0].scrollIntoView()",element);
        }while(sonucSayisi < 80);

        System.out.println("İstenilen Sonuç Sayısına Ulaşıldı:"+sonucSayisi);

        BekleKapat(3);
    }
}
