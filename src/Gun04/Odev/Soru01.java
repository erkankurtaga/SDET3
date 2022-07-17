package Gun04.Odev;

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
     */

public class Soru01 extends BaseStaticDriver {

    public static void main(String[] args) {
        driver.get("http://demoqa.com/text-box");

        getElementById("userName").sendKeys("Automation");
        getElementById("userEmail").sendKeys("Testing@gmail.com");
        getElementById("currentAddress").sendKeys("Testing Current Address");
        getElementById("permanentAddress").sendKeys("Testing Permanent Address");
        getElementById("submit").click();

        boolean ok;
        do {
            ok = getElementById("name") != null;
        } while (!ok);

        if (getElementById("name").getText().contains("Automation") &&
                getElementById("email").getText().contains("Testing"))
            System.out.println("Test OK");
        else
            System.out.println("Test Fail");

        BekleKapat(3);
    }

}
