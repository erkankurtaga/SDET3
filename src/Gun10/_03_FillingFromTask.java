package Gun10;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
    Bu siteye gidiniz.  http://demo.seleniumeasy.com/ajax-form-submit-demo.html
    Name giriniz.
    Comment giriniz.
    Submit'e tıklayınız.
    Form submited Successfully! yazısı görüntülenmelidir.
    assert ile kontrol ediniz
*/
public class _03_FillingFromTask extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://demo.seleniumeasy.com/ajax-form-submit-demo.html");

        getElementBy(By.id("title"))      .sendKeys("Erkan");
        getElementBy(By.id("description")).sendKeys("Kurtağa");
        getElementBy(By.id("btn-submit")) .click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

        wait.until(ExpectedConditions.textToBe(By.id("submit-control"),
                "Form submited Successfully!"));

        Assert.assertEquals("Form submited Successfully!",
                getElementBy(By.id("submit-control")).getText());

        BekleKapat(3);
    }
}
