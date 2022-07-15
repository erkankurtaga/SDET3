package Gun04;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _08_SendText extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        String msgText = "merhaba selenium";

        WebElement element = driver.findElement(By.partialLinkText("thanks"));
        element.click();

        WebElement textbox = driver.findElement(By.id("user-message"));
        textbox.sendKeys(msgText);

        WebElement button = driver.findElement(By.className("btn-default"));
        button.click();

        WebElement msg = driver.findElement(By.id("display"));

        if(msg.getText().contains(msgText))
            System.out.println("test passed");
        else
            System.out.println("test failed");

        BekleKapat(3);
    }
}
