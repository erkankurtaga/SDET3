package Gun13;

import Utils.BaseStaticDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Odev extends BaseStaticDriver {
    public static void main(String[] args) throws AWTException {
        driver.get("https://www.google.com/");

        String ilkSayfa = driver.getWindowHandle();

        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            Bekle(1);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
            Bekle(1);
        }

        byte sayfa=0;
        String url = "";

        driver.switchTo().window(ilkSayfa);
        Bekle(1);

        Set<String> whs = driver.getWindowHandles();
        for(String id:whs){
            if(id.equals(ilkSayfa)) continue;

            sayfa++;

            switch (sayfa){
                case 1:
                    url = "https://www.facebook.com/";
                    break;
                case 2:
                    url = "https://twitter.com/";
                    break;
            }

            driver.switchTo().window(id);
            driver.get(url);
        }

        BekleKapat(5);
    }
}
