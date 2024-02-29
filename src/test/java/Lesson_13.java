import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class Lesson_13 {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AS USER\\Desktop\\1111\\Lesson_13\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }
    @Test
    public void testOnlineRechargeBlock() {
        WebElement acceptLink = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        acceptLink.click();

        WebElement blockTitle = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]"));
        assertTrue(blockTitle.isDisplayed());

        WebElement paymentLogos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
        assertTrue(paymentLogos.isDisplayed());

        WebElement detailsLink = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        detailsLink.click();
        assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        driver.navigate().back();

        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")).click();

        WebElement numberInput = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        numberInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumInput.sendKeys("111");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
    }
    @Test
    public void testOnlineReplenishmentWithoutCommission(){
        WebElement closeButton = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/app-back-navigation/div/div/svg-icon/svg/line[2]"));
        closeButton.click();

        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        dropDown.click();

        WebElement commServices = driver.findElement(By.xpath("//p[text()=\"Услуги связи\"]"));
        assertTrue(commServices.isDisplayed());

        WebElement homeInternet = driver.findElement(By.xpath("//p[text()=\"Домашний интернет\"]"));
        assertTrue(homeInternet.isDisplayed());

        WebElement installmentPlan = driver.findElement(By.xpath("//p[text()=\"Рассрочка\"]"));
        assertTrue(installmentPlan.isDisplayed());

        WebElement debt = driver.findElement(By.xpath("//p[text()=\"Задолженность\"]"));
        assertTrue(debt.isDisplayed());

        WebElement dropD = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        dropD.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement commService = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
        commService.click();

        WebElement numberInput = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        numberInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumInput.sendKeys("111");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        WebElement summ = driver.findElement(By.xpath("//span [text()=\"111.00 BYN\"]"));
        assertTrue("Сумма не отображается", summ.isDisplayed());

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.switchTo().frame("iframe");

        WebElement sum2 = driver.findElement(By.xpath("//div [@class=\"header__payment-amount\"]/span[1]"));
        assertTrue(sum2.isDisplayed());

        WebElement telNum = driver.findElement(By.xpath("//p[@class = \"header__payment-info\"]"));
        assertTrue(telNum.isDisplayed());

        WebElement numCard = driver.findElement(By.xpath("//label[text() = \"Номер карты\"]"));
        assertTrue(numCard.isDisplayed());

        WebElement validity = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"));
        assertTrue(validity.isDisplayed());

        WebElement cvc = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
        assertTrue(cvc.isDisplayed());

        WebElement holderName = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));
        assertTrue(holderName.isDisplayed());

        WebElement pay = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/button/text()"));
        assertTrue(pay.isDisplayed());

        WebElement footSec = driver.findElement(By.xpath("//div[@class = \"footer-security\"]"));
        assertTrue(footSec.isDisplayed());

    }

    @After
    public void tearDown() {

        driver.quit();
    }
}