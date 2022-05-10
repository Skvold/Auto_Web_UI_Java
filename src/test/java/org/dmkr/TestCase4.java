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

public class TestCase4 {

            public static void main(String[] args ) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("start-maximized");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.get("https://www.amazon.com/");

            new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("amazon"));


            WebElement webElement1 = driver.findElement(By.id("glow-ingress-line1"));
            webElement1.click();

            WebElement webElement2 = driver.findElement(By.id("GLUXZipUpdateInput"));
            webElement2.sendKeys("10001");

            Thread.sleep(500);

            WebElement webElement3 = driver.findElement(By.cssSelector("#GLUXZipUpdate .a-button-input"));
            webElement3.click();

            WebElement webElement4 = driver.findElement(By.xpath("(//input[@id='GLUXConfirmClose'])[2]"));
            webElement4.click();


            try {

            } catch (NoSuchElementException e) {
                System.out.println(e);
            }finally {
                Thread.sleep(5000);
                driver.quit();
            }

        }
    }

