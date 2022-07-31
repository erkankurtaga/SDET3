package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _01_WindowGiris extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.selenium.dev/");

        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));

        for(WebElement e:linkler){
            if(!e.getAttribute("href").contains("mailto"))
                e.click();
        }

        Set<String> whs = driver.getWindowHandles();
        for(String wh:whs)
            System.out.println(wh);

        Bekle(6);
        BekleKapat(3);
    }
}
