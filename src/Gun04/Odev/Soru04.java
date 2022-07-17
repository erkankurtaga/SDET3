package Gun04.Odev;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
   1. Bu websitesine gidiniz.
      [https://testpages.herokuapp.com/styled/index.html]

   2. Calculate'e tıklayınız.
   3. İlk input'a herhangi bir sayı giriniz.
   4. İkinci input'a herhangi bir sayı giriniz.
   5. Calculate button'una tıklayınız.
   6. Sonucu alınız.
   7. Sonucu yazdırınız.
*/

public class Soru04 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        getElementById("calculate").click();

        boolean ok;
        do {
           ok = getElementByTagName("form") != null;
        }while(!ok);

        getElementById("number1").sendKeys("5");
        getElementById("number2").sendKeys("5");
        getElementById("calculate").click();

        do {
            ok = !getElementById("answer").getText().equals("ERR");
        }while(!ok);

        System.out.println(getElementById("answer").getText());

        BekleKapat(3);
    }
}
