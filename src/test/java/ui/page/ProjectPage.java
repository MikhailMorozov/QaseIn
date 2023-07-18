package ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.elements.DropDown;
import ui.model.Case;
import ui.model.Project;
import ui.model.Suite;

@Log4j2
public class ProjectPage extends BasePage{

    private static final By NAME_PROJECT = By.xpath("//div[@class='LALnEw']");
    private static final String NAME_PROJECT_XPATH = "//*[contains(text(),'%s')]";
    private static final By PROJECTS_BUTTON = By.xpath("//a[contains(text(),'Projects')]");
    private static final By CREATE_SUITE_BUTTON = By.xpath("//a[@id='create-suite-button']");
    private static final By SUITE_NAME_INPUT = By.xpath("//input[@id='title']");
    private static final By CREATE_SUITE_ON_FORM_BUTTON = By.xpath("//span[(text()='Create')]");
    private static final By SUCCESS_CREATE_SUITE_MESSAGE = By.xpath("//span[contains(text(),'Suite was successfully created.')]");
    private static final By SUCCESS_CREATE_CASE_MESSAGE = By.xpath("//span[contains(text(),'Test case was created successfully!')]");
    private static final By CREATE_CASE_BUTTON = By.xpath("//a[@id='create-case-button']");
    private static final String CASE_CHECKBOX = "//*[(text()='%s')]//preceding::span[@class='clBETr V74Xno']";
    private static final By DELETE_BUTTON = By.xpath("//*[(text()=' Delete')]");
    private static final By CONFIRM_INPUT = By.xpath("//input[@name='confirm']");
    private static final String TEXT_TO_CONFIRM_DELETE = "CONFIRM";
    private static final By DELETE_ON_FORM_BUTTON = By.xpath("//*[(text()='Delete')]");
    private static final By SUCCESS_DELETE_CASE_MESSAGE = By.xpath("//span[contains(text(),'1 test case was successfully deleted')]");
    private static final By SUCCESS_DELETE_SUITE_MESSAGE = By.xpath("//span[contains(text(),'Suite was successfully deleted.')]");








    public String getNameProject() {
        log.info("get name Project");
        return driver.findElement(NAME_PROJECT).getText();
    }

    public String getNameProject(String nameProject) {
        log.info("get name Project");
        return driver.findElement(By.xpath(String.format(NAME_PROJECT_XPATH, nameProject))).getText();
    }

    public ProjectPage clickProjectsButton() {
        log.info("click project button");
        driver.findElement(PROJECTS_BUTTON).click();
        return this;
    }

    public ProjectPage clickCreateSuiteButton() {
        log.info("click +Suite button on project site");
        waitForElement(CREATE_SUITE_BUTTON);
        driver.findElement(CREATE_SUITE_BUTTON).click();
        return this;
    }

    public ProjectPage inputSuiteName(Suite suite) {
        log.info("input suite name");
        driver.findElement(SUITE_NAME_INPUT).sendKeys(suite.getSuiteName());
        return this;
    }

    public ProjectPage clickCreateSuiteOnFormButton() {
        log.info("click Create button on form suite");
        driver.findElement(CREATE_SUITE_ON_FORM_BUTTON).click();
        return this;
    }

    public boolean isMessageSuccessCreateNewSuiteDisplayed() {
        log.info("is displayed message 'Suite was successfully created.'");
        return driver.findElement(SUCCESS_CREATE_SUITE_MESSAGE).isDisplayed();
    }

    public ProjectPage deleteSuite(Suite suite) {
        log.info("to click delete suite");
        new DropDown(driver).selectOptionSuiteDelete(suite.getSuiteName());
        return this;
    }

    public ProjectPage clickCreateCaseButton() {
        log.info("click +Case button on project site");
        waitForElement(CREATE_CASE_BUTTON);
        driver.findElement(CREATE_CASE_BUTTON).click();
        return this;
    }

    public boolean isMessageSuccessCreateNewCaseDisplayed() {
        log.info("is displayed message 'Test case was created successfully!'");
        return driver.findElement(SUCCESS_CREATE_CASE_MESSAGE).isDisplayed();
    }

    public ProjectPage clickCheckboxCase(Case testCase) {
        log.info("click checkbox case");
        driver.findElement(By.xpath(String.format(CASE_CHECKBOX, testCase.getTitle()))).click();
        return this;
    }

    public ProjectPage clickDeleteButton() {
        log.info("click delete button");
        driver.findElement(DELETE_BUTTON).click();
        return this;
    }

    public ProjectPage inputTextToConfirmDelete() {
        log.info("input suite name");
        driver.findElement(CONFIRM_INPUT).sendKeys(TEXT_TO_CONFIRM_DELETE);
        return this;
    }

    public ProjectPage clickDeleteButtonOnFormDeleteCase() {
        log.info("click delete button on form delete case");
        driver.findElement(DELETE_ON_FORM_BUTTON).click();
        return this;
    }

    public boolean isMessageSuccessDeleteCaseDisplayed() {
        log.info("is displayed message '1 test case was successfully deleted'");
        return driver.findElement(SUCCESS_DELETE_CASE_MESSAGE).isDisplayed();
    }

    public boolean isMessageSuccessDeleteSuiteDisplayed() {
        log.info("is displayed message 'Suite was successfully deleted'");
        return driver.findElement(SUCCESS_DELETE_SUITE_MESSAGE).isDisplayed();
    }

}
