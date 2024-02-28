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
        assertTrue("Название блока не отображается", blockTitle.isDisplayed());

        WebElement paymentLogos = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
        assertTrue("Логотипы платежных систем не отображаются", paymentLogos.isDisplayed());

        WebElement detailsLink = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        detailsLink.click();
        assertTrue("Ссылка 'Подробнее о сервисе' не работает", driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")); // Замените "expected_url" на ожидаемый URL страницы
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

    @After
    public void tearDown() {

        driver.quit();
    }
}