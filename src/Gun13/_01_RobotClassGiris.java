package Gun13;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class _01_RobotClassGiris extends BaseStaticDriver {
    public static void main(String[] args) throws AWTException {
        driver.get("https://demo.guru99.com/test/upload/");

        Robot robot = new Robot();

        for (int i = 0; i < 13; i++) {
            robot.keyPress(KeyEvent.VK_TAB); //tuşa basıldı down
            robot.keyRelease(KeyEvent.VK_TAB); //tuş bırakıdı up
            Bekle(1);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Bekle(1);

        // Stringi hafızaya-clipboard a kopyalama kodu
        StringSelection stringSelection = new StringSelection("C:\\Users\\erkan\\OneDrive\\Masaüstü\\ornek.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection , null);
        // Verilen stringi clipboard a set ediyor.
        Bekle(1);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Bekle(1);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Bekle(1);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Bekle(1);

        getElementBy(By.id("submitbutton")).click();

        WebElement asser = (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("res")));
        Assert.assertTrue(asser.getText().contains("has been successfully uploaded"));

       BekleKapat(5);
    }
}
