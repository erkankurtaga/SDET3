package Gun04;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _04_FindingByClassName extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://form.jotform.com/221934510376353");
        WebElement element = driver.findElement(By.className("form-submit-button"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.className("form-sub-label"));
        System.out.println(element1.getText());

        List<WebElement> elements = driver.findElements(By.className("form-sub-label1"));

        System.out.println(elements.size());
        for (WebElement e :elements){
            System.out.println(e.getText());
        }

        BekleKapat(3);
    }
}
