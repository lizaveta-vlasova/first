package com.mobileapplication.service.impl.SeleniumTest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.persistence.Table;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\lizaveta\\progs\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/loginForm");
    }




    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys("123@ya.ru");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
        WebElement entry = driver.findElement(By.id("entry"));
        entry.click();
        WebElement profileUser = driver.findElement(By.id("name"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("Лидия Ветрова, добро пожаловать!", mailUser);

    }
}