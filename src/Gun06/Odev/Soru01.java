package Gun06.Odev;

import Utils.BaseStaticDriver;

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

        getElementByXPath("//input[@placeholder='Full Name']").sendKeys("Automation");
        getElementByXPath("//input[@type='email']").sendKeys("Testing@gmail.com");
        getElementByXPath("//*[@placeholder='Current Address']").sendKeys("Testing Current Address");
        getElementByXPath("//div[@id='permanentAddress-wrapper']//textarea").sendKeys("Testing Permanent Address");
        Bekle(1);
        getElementByXPath("//*[text()='Submit']").click();
        Bekle(1);

        boolean ok;
        do {
            ok = getElementByXPath("//div[@id='output']//p") != null;
        } while (!ok);

        if (getElementByXPath("//div[@id='output']//p").getText().contains("Automation") &&
                getElementByXPath("//div[@id='output']//following::p[1]").getText().contains("Testing"))
            System.out.println("Test OK");
        else
            System.out.println("Test Fail");

        BekleKapat(3);
    }

}
