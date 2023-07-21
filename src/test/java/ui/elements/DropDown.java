package ui.elements;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

@AllArgsConstructor
public class DropDown {

    private static final int TIMEOUT_EXPLICIT_WAIT_SECOND = 15;
    private static final String DROP_DOWN_MENU_XPATH = "//a[contains(text(),'%s')]/following::a[@class='btn btn-dropdown']";
    private static final String SELECT_OPTION_MENU_XPATH = "//a[contains(text(),'%s')]/following::button[contains(text(),'Delete')]";
    private static final String DELETE_PROJECT_BUTTON_XPATH = "//span[contains(text(),'Delete project')]";
    private static final String DROP_DOWN_MENU_SUITE_XPATH = "//a[contains(text(),'%s')]/following-sibling::div/descendant::div[@class='SmsctB']";
    private static final String SELECT_OPTION_MENU_SUITE_XPATH = "//i[@class='fas fa-trash']";
    private static final String DELETE_SUITE_BUTTON_XPATH = "//span[contains(text(),'Delete')]";
    private static final String SELECT_OPTION_MENU_CASE_XPATH = "//div[text()='%s']";

    private WebDriver driver;

    public void selectOptionDelete(String nameProject) {
        new WebDriverWait(driver, TIMEOUT_EXPLICIT_WAIT_SECOND).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath(String.format(DROP_DOWN_MENU_XPATH, nameProject))))).click();
//        driver.findElement(By.xpath(String.format(SELECT_OPTION_MENU_XPATH, nameProject))).click();
        new WebDriverWait(driver, TIMEOUT_EXPLICIT_WAIT_SECOND).until(ExpectedConditions
                .visibilityOf((driver.findElement(By.xpath(String.format(SELECT_OPTION_MENU_XPATH, nameProject)))))).click();
//        driver.findElement(By.xpath(DELETE_PROJECT_BUTTON_XPATH)).click();
        new WebDriverWait(driver, TIMEOUT_EXPLICIT_WAIT_SECOND).until(ExpectedConditions
                .visibilityOf((driver.findElement(By.xpath(String.format(DELETE_PROJECT_BUTTON_XPATH)))))).click();
    }

    public void selectOptionSuiteDelete(String nameSuite) {
        new WebDriverWait(driver, TIMEOUT_EXPLICIT_WAIT_SECOND).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath(String.format(DROP_DOWN_MENU_SUITE_XPATH, nameSuite))))).click();
        driver.findElement(By.xpath(SELECT_OPTION_MENU_SUITE_XPATH)).click();
        driver.findElement(By.xpath(DELETE_SUITE_BUTTON_XPATH)).click();
    }

    public void selectOptionCase(WebElement fieldCase, String option) {
        new WebDriverWait(driver, TIMEOUT_EXPLICIT_WAIT_SECOND).until(ExpectedConditions.visibilityOf((fieldCase))).click();
        new WebDriverWait(driver, TIMEOUT_EXPLICIT_WAIT_SECOND).until(ExpectedConditions.visibilityOf((driver.findElement(By.xpath(String.format(SELECT_OPTION_MENU_CASE_XPATH, option)))))).click();
    }






}
