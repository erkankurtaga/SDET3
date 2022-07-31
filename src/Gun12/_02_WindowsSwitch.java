package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _02_WindowsSwitch extends BaseStaticDriver {
    public static void main(String[] args) {
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
            System.out.println(id+"-Title = "+driver.getTitle());
        }

        Bekle(3);
        BekleKapat(3);
    }
}
