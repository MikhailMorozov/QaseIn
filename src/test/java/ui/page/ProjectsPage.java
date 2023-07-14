package ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import ui.model.Project;

@Log4j2
public class ProjectsPage extends BasePage{

    private static final By CREATE_NEW_PROJECT_BUTTON = By.xpath("//button[@id='createButton']");
    private static final By PROJECT_NAME_INPUT = By.xpath("//input[@id='project-name']");
    private static final By PROJECT_CODE_INPUT = By.xpath("//input[@id='project-code']");
    private static final By CREATE_PROJECT_BUTTON = By.xpath("//button[@type='submit']");

    public boolean isButtonCreateNewProjectDisplayed() {
        log.info("is displayed button 'Create new project'");
        return driver.findElement(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
    }

    public ProjectsPage clickCreateNemProjectButton() {
        log.info("to click Create new project button");
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
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(project.getProjectCode());
        return this;
    }

    public ProjectsPage clickCreateProjectButton() {
        log.info("to click Create project button");
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        return this;
    }

}
