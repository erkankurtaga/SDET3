package Gun07.Odev;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/*
    Ödev  : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
            buradaki ülke ve şehirleri findElements ile topluca bularak bir döngü ile
            bütün şehirleri doğru ülkere dağıtınız.
*/

public class Soru00 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Bekle(3);

        WebElement ulke;
        WebElement sehir;

        Actions actions = new Actions(driver);

        for (int i = 1; i <= 7 ; i++) {
           ulke  = getElementBy(By.id("box"+(100+i)));
           sehir = getElementBy(By.id("box"+i));

           Bekle(1);

           Action action = actions.dragAndDrop(sehir,ulke).build();
           Bekle(1);
           action.perform();
           Bekle(1);
        }

        BekleKapat(3);
    }
}
