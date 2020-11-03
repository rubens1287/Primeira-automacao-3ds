package br.gov.etec;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    @Test
    public void LoginValido(){

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/login");

        driver.findElement(By.id("email")).sendKeys("teste123@teste.com.br");
        driver.findElement(By.id("senha")).sendKeys("1234");
        driver.findElement(By.className("btn")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement logado = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Bem vindo')]")));

        Assert.assertTrue(logado.isDisplayed());


        driver.close();;


    }

}
