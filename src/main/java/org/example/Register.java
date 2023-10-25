package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;


public class Register {
    public static void clickOnElements(By by)
    {
        driver.findElement(by).click();
    }
    public static void typeText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public static String getText(By by)
    {
       return driver.findElement(by).getText();

    }
    public static String timeStamp()
        {
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
            return timeStamp;
        }
    public static void waitForClickable(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }
    public static Boolean waitForUrlToBe(String url)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Boolean element = wait.until(ExpectedConditions.urlToBe(url));
        return element;
    }
    public static void waitForVisible(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.getText();
    }
    public static void waitForDisappear(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Boolean element;
        element = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    protected static WebDriver driver;
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Register")).click();
       //clickOnElements(By.linkText("Register"));
       // waitForClickable(By.linkText("Register"));
        //waitForUrlToBe("https://demo.nopcommerce.com/register?returnUrl=%2F");


        //driver.findElement(By.xpath("//input[@value='F']")).click();
        clickOnElements(By.xpath("//input[@value='F']"));

       // driver.findElement(By.id("FirstName")).sendKeys("Niyati");
        typeText(By.id("FirstName"),"Niyati");

        //driver.findElement(By.id("LastName")).sendKeys("Sharma");
        typeText(By.id("LastName"),"Sharma");

        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByVisibleText("17");
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByIndex(2);
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue("1980");
        String email = "niyati" +timeStamp()+"@yopmail.com";
        //driver.findElement(By.id("Email")).sendKeys("niyati" +timeStamp()+"@yopmail.com");
        typeText(By.id("Email"),"niyati" +timeStamp()+"@yopmail.com");

        System.out.println(email);
       // driver.findElement(By.id("Company")).sendKeys("J.k.LTd");
        typeText(By.id("Company"),"J.k.LTd");

        driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();

        //driver.findElement(By.cssSelector("#Password")).sendKeys("P@123456");
        typeText(By.cssSelector("#Password"),"P@123456");

       // driver.findElement(By.name("ConfirmPassword")).sendKeys("P@123456");
        typeText(By.name("ConfirmPassword"),"P@123456");

       // driver.findElement(By.id("register-button")).click();
        clickOnElements(By.id("register-button"));

       System.out.println(getText(By.xpath("//div[@class='result']")));
        //driver.quit();


    }
}
