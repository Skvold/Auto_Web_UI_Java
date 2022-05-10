package org.dmkr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestCase1 {
    public static void main(String[] args ) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        WebElement webElement1 = driver.findElement(By.id("twotabsearchtextbox")); //обнаружение поля поиск
        WebElement webElement2 = driver.findElement(By.id("nav-search-submit-button"));
        try {
            webElement1.sendKeys("television");
            webElement2.click();
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }


    }
}
