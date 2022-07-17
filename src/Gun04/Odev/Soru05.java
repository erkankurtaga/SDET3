package Gun04.Odev;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
    1. Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]
    2. Fake Alerts' tıklayınız.
    3. Show Alert Box'a tıklayınız.
    4. Ok'a tıklayınız.
    5. Alert kapanmalıdır.
*/

public class Soru05 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        getElementById("fakealerttest").click();

        boolean ok;

        do {
            ok = getElementById("fakealert") != null;
        }while(!ok);

        getElementById("fakealert").click();

        WebElement dialog = getElementById("dialog");

        ok=false;
        do {
            try {
                dialog.findElement(By.className("active"));
                ok=true;
            }catch(Exception e){
                ok=false;
            }
        }while(!ok);

        if(ok) {
            Bekle(1);

            getElementById("dialog-ok").click();

            dialog = getElementById("dialog");

            do {
                try {
                    dialog.findElement(By.className("active"));
                    ok=false;
                }catch(Exception e){
                    ok=true;
                }
            }while(!ok);

            if(ok)
                System.out.println("Test OK");
        }

        BekleKapat(1);
    }
}
