package Gun04.Odev;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

/*
    1) Bu siteye gidin. -> https://demo.applitools.com/
    2) Username kısmına "ttechno@gmail.com" girin.
    3) Password kısmına "techno123." girin.
    4) "Sign in" buttonunan tıklayınız.
    5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.
*/

public class Soru02 extends BaseStaticDriver {

    public static void main(String[] args) {
        driver.get("https://demo.applitools.com/");

        getElementById("username").sendKeys("ttechno@gmail.com");
        getElementById("password").sendKeys("techno123.");
        getElementById("log-in").click();

        Boolean ok;
        do {
            ok = getElementById("time") != null;
        }while(!ok);

        if (getElementByTagName("body").getText().contains("Your nearest branch closes in: 30m 5s"))
            System.out.println("Test OK");
        else
            System.out.println("Test Fail");

        BekleKapat(3);
    }
}
