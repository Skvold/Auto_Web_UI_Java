package org.dmkr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase2 {
    public static void main(String[] args ) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        WebElement webElement1 = driver.findElement(By.id("nav-hamburger-menu"));

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("amazon"));

        webElement1.click();

        WebElement webElement2 = driver.findElement(By.linkText("Computers"));
        webElement2.click();

        WebElement webElement3 = driver.findElement(By.linkText("Monitors"));
        webElement3.click();


        try {

        } catch (NoSuchElementException e) {
            System.out.println(e);
        }finally {
            Thread.sleep(5000);
            driver.quit();
        }

    }
}

