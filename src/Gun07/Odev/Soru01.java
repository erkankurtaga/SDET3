package Gun07.Odev;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/*
    Ödev 1 : http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
             buradaki ülke ve şehirleri findElements ile topluca bularak bir döngü ile
             bütün şehirleri doğru ülkere dağıtınız.
*/
public class Soru01 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        Bekle(3);

        WebElement ulke;
        WebElement sehir;


        Actions actions = new Actions(driver);
        for (int i = 1; i <= 15 ; i++) {
            ulke  = getElementBy(By.cssSelector("div#q"+i+"+div"));
            sehir = getElementBy(By.id("a"+i));

            Bekle(1);
            Action action = actions.clickAndHold(sehir).moveToElement(ulke).release(ulke).build();
            Bekle(1);
            action.perform();
            Bekle(1);
        }

        BekleKapat(3);
    }
}
