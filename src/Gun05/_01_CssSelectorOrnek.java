package Gun05;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
    1- https://formsmarts.com/form/yu?mode=h5 sitesini açın
    2- Business i çekleyin.
    3- discover XYZ ye tıklatın ve online Advertising i seçin
    4- Every day i seçin
    5- Good u seçin
    6- using XYZ yi tıklatın ve 3.seçeneği seçin
*/

public class _01_CssSelectorOrnek extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://formsmarts.com/form/yu?mode=h5");

        WebElement element = driver.findElement(By.cssSelector("input[id^='u_1fG']"));
        element.click();

        element = driver.findElement(By.cssSelector("div#section_1 option:nth-child(4)"));
        element.click();

        BekleKapat(3);
    }
}
