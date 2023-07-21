package ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.elements.DropDown;
import ui.model.Project;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProjectsPage extends BasePage{

    private static final By CREATE_NEW_PROJECT_BUTTON = By.xpath("//button[@id='createButton']");
    private static final By PROJECTS_BUTTON = By.xpath("//a[contains(text(),'Projects')]");
    private static final By CANCEL_BUTTON = By.xpath("//*[(text()='Cancel')]");
    private static final By PROJECT_NAME_INPUT = By.xpath("//input[@id='project-name']");
    private static final By PROJECT_CODE_INPUT = By.xpath("//input[@id='project-code']");
    private static final By CREATE_PROJECT_BUTTON = By.xpath("//button[@type='submit']");
    private static final By PROJECTS_LIST = By.xpath("//a[@class='defect-title']");
    private static final By DATA_INVALID_MESSAGE = By.xpath("//*[(text()='Data is invalid.')]");
    private static final String PROJECT_ON_LIST = "//*[(text()='%s')]";


    public boolean isButtonCreateNewProjectDisplayed() {
        log.info("is displayed button 'Create new project'");
        waitForElement(CREATE_NEW_PROJECT_BUTTON);
        return driver.findElement(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
    }

    public ProjectsPage clickCreateNemProjectButton() {
        log.info("to click Create new project button");
        waitForElement(CREATE_NEW_PROJECT_BUTTON);
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
        return this;
    }

    public ProjectsPage inputProjectName(Project project) {
        log.info("input project name");
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(project.getProjectName());
        return this;
    }

    public ProjectsPage inputProjectCode(Project project) {
        log.info("input project code");
        waitForElement(PROJECT_CODE_INPUT);
        driver.findElement(PROJECT_CODE_INPUT).clear();
        driver.findElement(PROJECT_CODE_INPUT).sendKeys(project.getProjectCode());
        return this;
    }

    public ProjectsPage clickCreateProjectButton() {
        log.info("to click Create project button");
        waitForElement(CREATE_PROJECT_BUTTON);
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        return this;
    }

    public ProjectsPage clickProjectsButton() {
        log.info("click project button");
        waitForElement(PROJECTS_BUTTON);
        driver.findElement(PROJECTS_BUTTON).click();
        return this;
    }

    public ProjectsPage deleteProject(Project project) {
        log.info("to click delete project");
        new DropDown(driver).selectOptionDelete(project.getProjectName());
        return this;
    }

    public List<WebElement> listProjects () {
        log.info("refresh site");
        driver.navigate().refresh();
        return driver.findElements(PROJECTS_LIST);
    }

    public List<String> listNameProjects(List<WebElement> elements) {
        List<String> nameProjects = new ArrayList<>();
        for (WebElement element : elements) {
            String nameProject = element.getText();
            nameProjects.add(nameProject);
        }
        System.out.println(nameProjects);
        return nameProjects;
    }

    public boolean isNameProjectInProjectsList(List<String> listNameProjects, String nameProject) {
        return listNameProjects.contains(nameProject);
    }

    public boolean isMessageDataInvalidDisplayed() {
        log.info("is displayed message 'Data is invalid.'");
        waitForElement(DATA_INVALID_MESSAGE);
        return driver.findElement(DATA_INVALID_MESSAGE).isDisplayed();
    }

    public ProjectsPage clickProject(String nameProject) {
        log.info("click project on project list");
        waitForElement(By.xpath(String.format(PROJECT_ON_LIST, nameProject)));
        driver.findElement(By.xpath(String.format(PROJECT_ON_LIST, nameProject))).click();
        return this;
    }

    public ProjectsPage clickCancelButton() {
        log.info("to click Cancel button");
        driver.findElement(CANCEL_BUTTON).click();
        return this;
    }



}
