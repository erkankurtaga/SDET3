package Gun14;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Scenario_02 extends BaseStaticDriver {
    public static void main(String[] args) {
        WebElement addCart=driver.findElement(By.xpath("//[@onclick='return EJProductClick('1595015')']"));
        addCart.click();
        Bekle(1);

        WebElement iframe= driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);Bekle(1);

        WebElement promoCodebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Apply-Button")));
        promoCodebtn.click();

        WebElement promoCode = driver.findElement(By.className("Promo-Code-Value"));
        promoCode.sendKeys("123456789");
        Bekle(1);

        WebElement apply=driver.findElement(By.xpath("//[@class='Promo-Apply']"));
        apply.click();

        Bekle(6);


        WebElement invalid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='SnackBar'] span")));
        Assert.assertTrue( invalid.isDisplayed());
    }
}
