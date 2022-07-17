package Gun04.Odev;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
    1) Bu siteye gidin. -> https://www.snapdeal.com/
    2) "teddy bear" aratın ve  Search butonuna tıklayın.
    3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
    Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.
*/

public class Soru03 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.snapdeal.com/");

        getElementById("inputValEnter").sendKeys("teddy bear");
        getElementByClassName("searchformButton").click();

        boolean ok;
        do {
           ok = getElementByClassName("nnn") != null;
        } while (!ok);

        String txt = getElementByClassName("nnn").getText();

        if (txt.contains("We've got") &&
                txt.contains("results for 'teddy bear'"))
            System.out.println("Test OK");
        else
            System.out.println("Test Fail");

        BekleKapat(3);
    }
}
