package ui.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.page.ProjectsPage;

@Log4j2
public class ProjectsSteps {

    ProjectsPage projectsPage = new ProjectsPage();
    @Step("Account is displayed")
    public boolean buttonCreateNewProjectIsDisplayed() {
        log.info("Account is displayed");
        return projectsPage.isButtonCreateNewProjectDisplayed();
    }
}
