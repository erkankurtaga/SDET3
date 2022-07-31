package Gun14;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Scenario5 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement element;

        element = driver.findElement(By.xpath("//h4[text()='Demo eBook']//following::button"));
        element.click();

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@style='display: block;']")));
        driver.switchTo().frame(element);

        element = driver.findElement(By.xpath("//button[@data-option='CC']"));
        element.click();

        driver.switchTo().defaultContent();

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@style='display: block;']")));
        driver.switchTo().frame(element);

        List<WebElement> emails = driver.findElements(By.xpath("//input[@type='email']"));
        for(WebElement email:emails) {
            email.sendKeys("erkan.group6@techno.study");
        }

        element = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        element.sendKeys("erkan");
        Bekle(1);

        element = driver.findElement(By.xpath("//input[@autocomplete='phone']"));
        element.sendKeys("1111111111");
        Bekle(1);

        element = driver.findElement(By.xpath("//input[@autocomplete='company']"));
        element.sendKeys("Techno Study");
        Bekle(1);

        element = driver.findElement(By.cssSelector("#Stripe-Element iframe"));
        driver.switchTo().frame(element);
        Bekle(1);

        element = driver.findElement(By.name("cardnumber"));
        element.sendKeys("4242 4242 4242 4242");
        Bekle(1);

        element = driver.findElement(By.name("exp-date"));
        element.sendKeys("12/22");
        Bekle(1);

        element = driver.findElement(By.name("cvc"));
        element.sendKeys("000");
        Bekle(1);

        driver.switchTo().parentFrame();

        element = driver.findElement(By.className("Pay-Button"));
        element.click();

        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.titleIs("E-junkie - Thank you"));

        element = driver.findElement(By.cssSelector("span.green_text_margin"));

        Assert.assertTrue(element.getText().contains("Thank you!"));

        System.out.println("Alışveriş Başarılı");

        BekleKapat(3);
    }
}
