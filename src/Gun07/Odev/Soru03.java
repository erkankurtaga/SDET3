package Gun07.Odev;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/*
    Ödev 3: http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html
            buradaki bütün şehirleri bütün ülkere doğru şekilde topluca dağıtınız.
*/

public class Soru03 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");
        Bekle(3);

        WebElement ulke;
        WebElement sehir;


        Actions actions = new Actions(driver);
        for (int i = 1; i <= 21 ; i++) {
            sehir = getElementBy(By.id("node"+i));
            ulke  = getElementBy(By.id(sehir.getAttribute("groupid")));

            Bekle(1);
            Action action = actions.clickAndHold(sehir).moveToElement(ulke).release(ulke).build();
            Bekle(1);
            action.perform();
            Bekle(1);
        }

        BekleKapat(3);
    }
}
