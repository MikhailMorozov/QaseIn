package ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.elements.DropDown;
import ui.model.Case;

import java.util.List;

@Log4j2
public class NewCasePage extends BasePage{

    private static final By TITLE_CASE = By.xpath("//input[@id='title']");

    private static final By SAVE_CASE_BUTTON = By.xpath("//button[@id='save-case']");
    private static final String DROP_DOWN_MENU_CASE_XPATH = "//div[@class='Thgbhj euhZGB cfvQxI']";



    public NewCasePage createCase(Case testCase){
        log.info("input title case");
        driver.findElement(TITLE_CASE).sendKeys(testCase.getTitle());
        List<WebElement> fieldsCase = driver.findElements(By.xpath(DROP_DOWN_MENU_CASE_XPATH));
        new DropDown(driver).selectOptionCase(fieldsCase.get(0),testCase.getStatus());
        new DropDown(driver).selectOptionCase(fieldsCase.get(1),testCase.getSuite());
        new DropDown(driver).selectOptionCase(fieldsCase.get(2),testCase.getSeverity());
        new DropDown(driver).selectOptionCase(fieldsCase.get(3),testCase.getPriority());
        new DropDown(driver).selectOptionCase(fieldsCase.get(4),testCase.getType());
        new DropDown(driver).selectOptionCase(fieldsCase.get(5),testCase.getLayer());
        new DropDown(driver).selectOptionCase(fieldsCase.get(6),testCase.getIsFlaky());
        new DropDown(driver).selectOptionCase(fieldsCase.get(7),testCase.getBehavior());
        new DropDown(driver).selectOptionCase(fieldsCase.get(8),testCase.getAutomationStatus());
        return this;
    }


}
