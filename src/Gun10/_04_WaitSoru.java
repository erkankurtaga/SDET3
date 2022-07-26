package Gun10;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
    Senaryo
    1-  https://www.demoblaze.com/index.html  siteyi açınız.
    2- Samsung galaxy s6  linkine tıklayınız.
    3- Sepete ekleyiniz.
    4- Daha Sonra PRODUCT STORE yazısına tıklatarak ana ekrana geri dönününz
*/

public class _04_WaitSoru extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.demoblaze.com/index.html");

        getElementBy(By.linkText("Samsung galaxy s6")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        wait.until(ExpectedConditions.textToBe(By.className("name"),"Samsung galaxy s6"));

        getElementBy(By.linkText("Add to cart")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        getElementBy(By.xpath("//a[@href='index.html']")).click();

        BekleKapat(3);
    }
}
