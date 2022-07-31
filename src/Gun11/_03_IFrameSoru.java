package Gun11;

import Utils.BaseStaticDriver;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/*
   1-driver.get("http://chercher.tech/practice/frames"); sayfasına gidiniz.
   2-Inputa ülke adı yazınız
   3-CheckBox ı çekleyiniz.
   4-Select in 4.elemanını seçiniz.
 */

public class _03_IFrameSoru extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://chercher.tech/practice/frames");

        driver.switchTo().frame(0);
        getElementBy(By.cssSelector("b#topic+input")).sendKeys("Türkiye");

        driver.switchTo().frame(0);
        getElementBy(By.id("a")).click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        Select select = new Select(getElementBy(By.id("animals")));
        select.selectByIndex(select.getOptions().size() - 1);

        driver.switchTo().defaultContent();

        BekleKapat(3);
    }
}
