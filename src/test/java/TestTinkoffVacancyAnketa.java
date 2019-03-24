import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class TestTinkoffVacancyAnketa extends BaseRunner {
    private WebDriver driver;

    @Test
    public void testNoDataInAnketaFields() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(
                By.name("name"))
                .click();
        driver.findElement(
                By.name("birthday"))
                .click();
        driver.findElement(
                By.name("city"))
                .click();
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/form/div[2]/div/div[2]"))
                .getText());
        driver.findElement(
                By.name("email"))
                .click();
        driver.findElement(
                By.name("phone"))
                .click();
        driver.findElement(
                By.name("socialLink0"))
                .click();
        driver.findElement(
                By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon"))
                .click();
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='что-то'])[1]/following::div[2]"))
                .click();
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/form/div[8]/div/div[1]/div/div[2]"))
                .getText());
    }
    @Test
    public void testIncorrectDataInAnketaFields() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(
                By.name("name"))
                .click();
        driver.findElement(
                By.name("name"))
                .clear();
        driver.findElement(
                By.name("name"))
                .sendKeys("0");
        driver.findElement(
                By.name("birthday"))
                .click();
        driver.findElement(
                By.name("birthday"))
                .clear();
        driver.findElement(
                By.name("birthday"))
                .sendKeys("0");
        driver.findElement(
                By.name("email"))
                .click();
        assertEquals("Поле заполнено некорректно",
                driver.findElement(
                        By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/form/div[2]/div/div[2]"))
                        .getText());
        driver.findElement(
                By.name("email"))
                .clear();
        driver.findElement(
                By.name("email"))
                .sendKeys("0");
        driver.findElement(
                By.name("phone"))
                .click();
        assertEquals("Введите корректный адрес эл. почты",
                driver.findElement(
                        By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/form/div[4]/div/div[1]/div/div[2]"))
                        .getText());
        driver.findElement(
                By.name("phone"))
                .clear();
        driver.findElement(
                By.name("phone"))
                .sendKeys("+7(0");
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Заполните анкету'])[1]/following::div[1]"))
                .click();
        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора",
                driver.findElement(
                        By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/form/div[4]/div/div[2]/div/div[2]"))
                        .getText());
    }
}
