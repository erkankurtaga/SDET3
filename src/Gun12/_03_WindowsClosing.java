package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

/*
   1- https://www.selenium.dev/  sayfasına gidiniz
   2- Sayfadaki bütün yeni sayfa açan linkleri tıklatınız(mailto hariç)
   3- Açılan bütün yeni sayfaları teer teker kapatınız
 */

public class _03_WindowsClosing extends BaseStaticDriver {
    public static void main(String[] args) {
        WebElement element;

        driver.get("https://www.selenium.dev/");
        String anaSayfaWindowId = driver.getWindowHandle();

        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));

        for(WebElement e:linkler){
            if(!e.getAttribute("href").contains("mailto"))
                e.click();
        }

        Set<String> whs = driver.getWindowHandles();
        for(String id:whs){
            if(id.equals(anaSayfaWindowId)) continue;
            driver.switchTo().window(id);
            driver.close();
        }

        Bekle(3);
        BekleKapat(3);
    }
}
