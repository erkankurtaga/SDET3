package Gun06;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
    1- https://www.saucedemo.com/  sitesini açın
    2- login işlemini yapınız.
    3- Sauce Labs Backpack  a tıklatın ve sepete ekletin.
    4- Sonra geri dönün (Back to products e tıklatın)
    5- Sauce Labs Bolt T-Shirt  a tıklatın ve sepete ekleyin.
    6- sepete tıklatın
    7- CheckOut a tıklatın
    8- kullanıcı bilgilerini doldurup Continue ya tıklatın
    9- Burada her bir eşyanın ücretlerinin toplamının aşağıdaki
       Item total e eşit olup olmadığını if/Assert ile test ediniz.
*/

public class _02_XpathSenaryo extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");

        getElementByXPath("//form//input").sendKeys("standard_user");
        getElementByXPath("//form//following::input[1]").sendKeys("secret_sauce");
        getElementByXPath("//form//following::input[2]").click();
        Bekle(1);

        getElementByXPath("//*[text()='Sauce Labs Backpack']").click();
        Bekle(1);

        getElementByXPath("//*[text()='Add to cart']").click();
        Bekle(1);

        getElementByXPath("//*[text()='Back to products']").click();
        Bekle(1);

        getElementByXPath("//*[text()='Sauce Labs Bolt T-Shirt']").click();
        Bekle(1);

        getElementByXPath("//*[text()='Add to cart']").click();
        Bekle(1);

        getElementByXPath("//*[text()='Back to products']").click();
        Bekle(1);

        getElementByXPath("//*[@class='shopping_cart_link']").click();
        Bekle(1);

        getElementByXPath("//*[text()='Checkout']").click();
        Bekle(1);

        getElementByXPath("//input[@placeholder='First Name']").sendKeys("Erkan");
        getElementByXPath("//input[@placeholder='Last Name']").sendKeys("KURTAĞA");
        getElementByXPath("//input[@placeholder='Zip/Postal Code']").sendKeys("123456");
        Bekle(1);

        getElementByXPath("//input[@id='continue']").click();
        Bekle(1);

        List<WebElement> list = getElementsBy(By.xpath("//*[@class='inventory_item_price']"));

        double toplam=0;
        for (WebElement item : list){
           System.out.println("item price : "+item.getText());
           toplam += Double.parseDouble(item.getText().replaceAll("[^0-9\\.\\,]","").trim());
        }

        System.out.println("total : $"+toplam);

        double altToplam = Double.parseDouble(getElementByXPath("//*[@class='summary_subtotal_label']").
                                getText().replaceAll("[^0-9\\.\\,]","").trim());

        System.out.println("sub total : $"+altToplam);

        if (toplam == altToplam)
            System.out.println("test passed");
        else
            System.out.println("test failed");


        Assert.assertTrue(toplam == altToplam);

        BekleKapat(3);
    }
}
