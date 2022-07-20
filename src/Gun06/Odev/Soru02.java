package Gun06.Odev;

import Utils.BaseStaticDriver;

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

        getElementByXPath("//form//following::input[1]").sendKeys("ttechno@gmail.com");
        getElementByXPath("//form//following::input[2]").sendKeys("techno123.");
        getElementByXPath("//a[text()='Sign in']").click();

        Bekle(3);

        if (getElementByXPath("//*[contains(text(),'Your nearest branch closes in: 30m 5s')]") != null)
            System.out.println("Test OK");
        else
            System.out.println("Test Fail");

        BekleKapat(3);
    }
}
