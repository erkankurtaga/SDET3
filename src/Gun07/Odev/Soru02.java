package Gun07.Odev;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/*
    Ödev 2 : http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html
             buradaki bütün öğrencileri bütün kutucukları doldurana kadar atınız.
*/
public class Soru02 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

        WebElement item = driver.findElement(By.id("node1"));
        WebElement box  = driver.findElement(By.id("box1"));

        Actions actions = new Actions(driver);

        Action action = actions.clickAndHold(item).moveToElement(box).release(box).build();
        action.perform();

        BekleKapat(3);
    }
}
