package Gun05;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
   1) Bu siteye gidin. ->  http://demoqa.com/text-box
   2) Full Name kısmına "Automation" girin.
   3) Email kısmına "Testing@gmail.com" girin.
   4) Current Address kısmına "Testing Current Address" girin.
   5) Permanent Address kısmına "Testing Permanent Address" girin.
   6) Submit butonuna tıklayınız.
   7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
   8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.
   9) Elemanları id ve name kullanmadan css selector kullanarak bulunuz.
*/

public class _02_CssSelectorOrnek extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://demoqa.com/text-box");

        getElementByCssSelector("div#userName-wrapper input").sendKeys("Automation");
        getElementByCssSelector("div#userEmail-wrapper input").sendKeys("Testing@gmail.com");
        getElementByCssSelector("div#currentAddress-wrapper textarea").sendKeys("Testing Current Address");
        getElementByCssSelector("div#permanentAddress-wrapper textarea").sendKeys("Testing Permanent Address");
        getElementByCssSelector("div#permanentAddress-wrapper + div button").click();

        boolean ok;
        do {
            ok = getElementByCssSelector("#permanentAddress-wrapper ~ div p") != null;
        } while (!ok);

        if (getElementByCssSelector("#permanentAddress-wrapper ~ div p").
                getText().contains("Automation") &&
                getElementByCssSelector("#permanentAddress-wrapper ~ div p:nth-child(2)").getText().contains("Testing"))
            System.out.println("Test OK");
        else
            System.out.println("Test Fail");

        BekleKapat(3);
    }
}
