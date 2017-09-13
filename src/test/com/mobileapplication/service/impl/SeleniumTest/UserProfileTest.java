package com.mobileapplication.service.impl.SeleniumTest;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UserProfileTest {
    private static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\lizaveta\\progs\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void userInformation() {
        driver.get("http://localhost:8080/loginForm");
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys("123@ya.ru");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
        WebElement entry = driver.findElement(By.id("entry"));
        entry.click();
        WebElement userInformLi = driver.findElement(By.id("liUserInformation"));
        userInformLi.click();
        WebElement profileUser = driver.findElement(By.id("nameUser"));
        String info = profileUser.getText();
        Assert.assertEquals("Информация о клиенте: Лидия Ветрова", info);
        driver.quit();
    }

    @Test
    public void chooseContract() {
        driver.get("http://localhost:8080/loginForm");
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys("123@ya.ru");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
        WebElement entry = driver.findElement(By.id("entry"));
        entry.click();
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        WebElement selectedContract = driver.findElement(By.id("please"));
        String info = selectedContract.getText();
        Assert.assertEquals("Пожалуйста, выберете действие в боковом меню.", info);
        driver.quit();
    }

    @Test
    public void returnPageToCHangeTariff() {
        driver.get("http://localhost:8080/loginForm");
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys("123@ya.ru");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
        WebElement entry = driver.findElement(By.id("entry"));
        entry.click();
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        WebElement tariff = driver.findElement(By.id("liTariffChange"));
        tariff.click();
        WebElement findTariff = driver.findElement(By.name("tariff"));
        String info = findTariff.getText();
        Assert.assertEquals("Действующий тариф", info);
        driver.quit();
    }

    @Test
    public void returnOptionList() {
        driver.get("http://localhost:8080/loginForm");
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys("123@ya.ru");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
        WebElement entry = driver.findElement(By.id("entry"));
        entry.click();
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        WebElement tariff = driver.findElement(By.id("liOptionsChange"));
        tariff.click();
        WebElement optionList = driver.findElement(By.id("optionList"));
        String info = optionList.getText();
        Assert.assertEquals("Для вашего тарифа доступны следующие опции:", info);
        driver.quit();

    }

    @Test
    public void returnPageBlock() {
        driver.get("http://localhost:8080/loginForm");
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys("123@ya.ru");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
        WebElement entry = driver.findElement(By.id("entry"));
        entry.click();
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        WebElement block = driver.findElement(By.id("liNumberBlock"));
        block.click();
        WebElement text = driver.findElement(By.id("block"));
        String info = text.getText();
        Assert.assertEquals("Блокировка/разблокировка контракта", info);
        driver.quit();

    }
    @Test
    public void blockContract() {
        driver.get("http://localhost:8080/loginForm");
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.sendKeys("123@ya.ru");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
        WebElement entry = driver.findElement(By.id("entry"));
        entry.click();
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        WebElement block = driver.findElement(By.id("liNumberBlock"));
        block.click();
        WebElement button = driver.findElement(By.id("button"));
        String text = button.getText();
        if (text.equals("Разблокировать")) {
            button.click();
            WebElement mainPage = driver.findElement(By.id("please"));
            String newItem = mainPage.getText();
            Assert.assertEquals("Пожалуйста, выберете действие в боковом меню.", newItem);
            driver.quit();
        } else {
            button.click();
            WebElement mainPage = driver.findElement(By.id("numberBlock"));
            String newItem = mainPage.getText();
            Assert.assertEquals("Номер заблокирован.", newItem);
            WebElement block1 = driver.findElement(By.id("liNumberBlock"));
            block1.click();
            WebElement button1 = driver.findElement(By.id("button"));
            button1.click();
            driver.quit();
        }
    }
}
