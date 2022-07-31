package Gun11;

import Utils.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;

public class Soru extends BaseStaticDriver {

    public static int RandomSayi() {
        return (int) (Math.random() * 100);
    }

    public static double getSonuc(int islem, int sayi1,int sayi2){

        double sonuc=0;

        switch(islem){
            case 0:
                sonuc= sayi1+sayi2;
            break;

            case 1:
                sonuc= sayi1 - sayi2;
            break;

            case 2:
                sonuc= sayi1 * sayi2;
            break;

            case 3:
                sonuc = (double) sayi1 / sayi2;
            break;

            case 4:
                sonuc= Double.parseDouble(String.valueOf(sayi1).concat(String.valueOf(sayi2)));
            break;
        }

        return sonuc;
    }

    public static void main(String[] args) {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        for (int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                int sayi1 = RandomSayi();
                int sayi2 = RandomSayi();

                double sonuc = getSonuc(i,sayi1,sayi2);

                WebElement firsnumbur = driver.findElement(By.id("number1Field"));
                firsnumbur.clear();
                firsnumbur.sendKeys(String.valueOf(sayi1));

                WebElement second = driver.findElement(By.id("number2Field"));
                second.clear();
                second.sendKeys(String.valueOf(sayi2));

                WebElement menu = driver.findElement(By.id("selectOperationDropdown"));
                Select select = new Select(menu);
                select.selectByIndex(i);

                WebElement clearButton = driver.findElement(By.id("clearButton"));
                clearButton.click();

                WebElement calculateButton = driver.findElement(By.id("calculateButton"));
                calculateButton.click();

                WebElement answer = driver.findElement(By.id("numberAnswerField"));
                wait.until(ExpectedConditions.attributeToBeNotEmpty(answer,"value"));

                String answerValue = answer.getAttribute("value");
                Double answerDouble = Double.parseDouble(answerValue);
                Assert.assertEquals(sonuc,answerDouble,sonuc);

                Bekle(1);
            }
        }


        BekleKapat(3);
    }
}
