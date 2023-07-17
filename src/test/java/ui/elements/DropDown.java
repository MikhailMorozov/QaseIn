package ui.elements;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@AllArgsConstructor
public class DropDown {

    private static final String DROP_DOWN_MENU_XPATH = "//a[contains(text(),'%s')]/following::a[@class='btn btn-dropdown']";
    private static final String SELECT_OPTION_MENU_XPATH = "//a[contains(text(),'%s')]/following::button[contains(text(),'Delete')]";
    private static final String DELETE_PROJECT_BUTTON_XPATH = "//span[contains(text(),'Delete project')]";
    private WebDriver driver;

    public void selectOptionDelete(String nameProject) {
        new WebDriverWait(driver, 15).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath(String.format(DROP_DOWN_MENU_XPATH, nameProject))))).click();
        driver.findElement(By.xpath(String.format(SELECT_OPTION_MENU_XPATH, nameProject))).click();
        driver.findElement(By.xpath(DELETE_PROJECT_BUTTON_XPATH)).click();
    }
}
