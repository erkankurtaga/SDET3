package Gun05.Odev;

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

        getElementByCssSelector("form input:nth-child(1)").sendKeys("ttechno@gmail.com");
        getElementByCssSelector("form input:nth-child(2)").sendKeys("techno123.");
        getElementByCssSelector("form a").click();

        Boolean ok;
        do {
            ok = getElementByCssSelector("[class='content-w'] h6") != null;
        }while(!ok);

        if (getElementByCssSelector("[class='content-w'] h6").getText().
                contains("Your nearest branch closes in: 30m 5s"))
            System.out.println("Test OK");
        else
            System.out.println("Test Fail");

        BekleKapat(3);
    }
}
