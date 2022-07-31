package Gun12;

import Utils.BaseStaticDriver;
import org.openqa.selenium.JavascriptExecutor;

public class _04_Scrollintro extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://triplebyte.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }
}
