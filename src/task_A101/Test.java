package task_A101;

import Utils.BasicStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Test extends BasicStaticDriver {
    public static void main(String[] args) throws AWTException {

        driver.get("https://www.a101.com.tr/");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        WebElement kabulEt = driver.findElement(By.xpath("//*[text()= 'Kabul Et']"));
        kabulEt.click();

        WebElement element = driver.findElement(By.xpath("(//a[@title='GİYİM & AKSESUAR'])[1]"));
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(element).build();
        action.perform();

        WebElement dizaltiCorap = driver.findElement(By.linkText("Dizaltı Çorap"));
        dizaltiCorap.click();

        WebElement pantolonCorabi = driver.findElement(By.xpath("(//a[@title='Penti Kadın 50 Denye Pantolon Çorabı Siyah'])[2]"));
        pantolonCorabi.click();

        WebElement renk = driver.findElement(By.xpath("//span[text()='SİYAH']"));
        Assert.assertTrue(renk.getText().contains("SİYAH"));

        WebElement sepeteEkle = driver.findElement(By.cssSelector("[class='icon-sepetekle']"));
        wait.until(ExpectedConditions.visibilityOf(sepeteEkle));
        sepeteEkle.click();

        WebElement sepetiGoruntule = driver.findElement(By.xpath("(//*[@title='Sepeti Görüntüle'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(sepetiGoruntule));
        sepetiGoruntule.click();

        WebElement sepetiOnayla = driver.findElement(By.xpath("(//a[@title='Sepeti Onayla'])[2]"));  // locator değişti
        wait.until(ExpectedConditions.visibilityOf(sepetiOnayla));
        sepetiOnayla.click();

        WebElement uyeOlmadanDevamEt = driver.findElement(By.cssSelector("[title='ÜYE OLMADAN DEVAM ET']"));
        wait.until(ExpectedConditions.elementToBeClickable(uyeOlmadanDevamEt));
        uyeOlmadanDevamEt.click();

        WebElement email = driver.findElement(By.cssSelector("[name='user_email']"));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("akdoganflow@gmail.com");

        WebElement devamEt = driver.findElement(By.cssSelector("[class='button block green']"));
        wait.until(ExpectedConditions.elementToBeClickable(devamEt));
        devamEt.click();

        WebElement yeniAdresOlustur = driver.findElement(By.cssSelector("[class='new-address js-new-address']"));
        wait.until(ExpectedConditions.elementToBeClickable(yeniAdresOlustur));
        yeniAdresOlustur.click();

        WebElement adresBaslik = driver.findElement(By.cssSelector("[placeholder='Ev adresim, iş adresim vb.']"));
        wait.until(ExpectedConditions.visibilityOf(adresBaslik));
        adresBaslik.sendKeys("Bireysel");

        WebElement ad = driver.findElement(By.cssSelector("[name='first_name']"));
        wait.until(ExpectedConditions.visibilityOf(ad));
        ad.sendKeys("Nazmiye");

        WebElement soyad = driver.findElement(By.cssSelector("[name='last_name']"));
        wait.until(ExpectedConditions.visibilityOf(soyad));
        soyad.sendKeys("Akdoğan");

        WebElement cepTelefon = driver.findElement(By.cssSelector("[name='phone_number']"));
        wait.until(ExpectedConditions.visibilityOf(cepTelefon));
        cepTelefon.sendKeys("0 541 284 00 23");

        WebElement il = driver.findElement(By.className("js-cities"));
        wait.until(ExpectedConditions.visibilityOf(il));
        Select select1 = new Select(il);
        select1.selectByVisibleText("ELAZIĞ");

        WebElement ilce=driver.findElement(By.className("js-township"));
        wait.until(ExpectedConditions.visibilityOf(ilce));
        Select select2 =new Select(ilce);
        select2.selectByVisibleText("MERKEZ");

        WebElement mahalle=driver.findElement(By.className("js-district"));
        mahalle.click();
        wait.until(ExpectedConditions.textToBePresentInElement(mahalle, "SÜRSÜRÜ MAH"));
        WebElement mah = driver.findElement(By.xpath("//option[text()='SÜRSÜRÜ MAH']"));
        mah.click();

        WebElement adres = driver.findElement(By.className("js-address-textarea"));
        int randomBlok = (int) ( Math.random()*100);
        wait.until(ExpectedConditions.visibilityOf(adres));
        adres.sendKeys("Elazığ/TÜRKİYE " + randomBlok);

        WebElement kaydet = driver.findElement(By.cssSelector("[class='button green js-set-country js-prevent-emoji']"));
        wait.until(ExpectedConditions.elementToBeClickable(kaydet));
        kaydet.click();

        driver.navigate().refresh();
        WebElement sendeoKargo = driver.findElement(By.xpath("(//div[@class='radio'])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(sendeoKargo));
        sendeoKargo.click();

        WebElement kaydetDevam =  driver.findElement(By.xpath("//button[@class='button block green js-proceed-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(kaydetDevam));
        kaydetDevam.click();

        WebElement kontrol = driver.findElement(By.xpath("(//div[@class='title'])[9]"));
        wait.until(ExpectedConditions.visibilityOf(kontrol));
        Assert.assertTrue(kontrol.getText().contains("Lütfen Kart bilgilerinizi yazın"));

        System.out.println("Test Passed");

        BekleKapat();
    }
}
