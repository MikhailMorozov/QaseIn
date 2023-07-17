package ui.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.model.Project;
import ui.page.ProjectsPage;

@Log4j2
public class ProjectsSteps {

    ProjectsPage projectsPage = new ProjectsPage();
    @Step("Account is displayed")
    public boolean buttonCreateNewProjectIsDisplayed() {
        log.info("Account is displayed");
        return projectsPage.isButtonCreateNewProjectDisplayed();
    }

    @Step("Create project")
    public ProjectsSteps createProject(Project project) {
        log.info("create project");
        projectsPage.clickCreateNemProjectButton()
                .inputProjectName(project)
                .inputProjectCode(project)
                .clickCreateProjectButton();
        return this;
    }

    @Step("Delete project")
    public ProjectsSteps deleteProject(Project project) {
        log.info("delete project");
        projectsPage.deleteProject(project);
        return this;
    }
}
