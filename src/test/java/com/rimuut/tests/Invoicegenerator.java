package com.rimuut.tests;

import com.rimuut.utilities.BrowserUtils;
import com.rimuut.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Invoicegenerator {

    WebDriver driver = Driver.get();
    String URL = "https://rimuut.com/tools/invoice-generator-for-freelancers";

    @BeforeClass
    public void testSetUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "latest");
        capabilities.setCapability("tunnel", false);
        capabilities.setCapability("network", true);
        capabilities.setCapability("console", true);
        capabilities.setCapability("visual", true);

    }

    @Test

    protected void test_selenium_invoice_generator() throws InterruptedException {

        driver.navigate().to(URL);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("(//*[@class='number']/span)[2]")).sendKeys("#1456258");
        driver.findElement(By.xpath("//h3[@data-text='Name of your business']")).sendKeys("Cengiz Yıldız");
        driver.findElement(By.xpath("//h3[@data-text='Name of your business']/../p")).sendKeys("Pamuklar Mah. Kızılcahamam Cad. No:54/A\n" + "Ankara, 06300\n" +
                "Turkey");
        driver.findElement(By.xpath("//h3[@data-text='Business name of your client']")).sendKeys("Fatih YILMAZ");
        driver.findElement(By.xpath("//h3[@data-text='Business name of your client']/../p")).sendKeys("Keçiören Mah. No:48/3 Ankara Turkey");
        driver.findElement(By.xpath("//span[@class='blue-text dynamic-headline-color']")).sendKeys("TR10 0000 00000 00001");
        driver.findElement(By.xpath("(//div[@class='item invoice-no']/span)[2]")).sendKeys("#1456258");
        driver.findElement(By.xpath("//button[@class='save-btn']")).click();


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}