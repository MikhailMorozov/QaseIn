package ui.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.model.Project;
import ui.page.ProjectsPage;

import java.util.List;

@Log4j2
public class ProjectsSteps {
    @Step("Account is displayed")
    public boolean buttonCreateNewProjectIsDisplayed() {
        ProjectsPage projectsPage = new ProjectsPage();
        log.info("Account is displayed");
        return projectsPage.isButtonCreateNewProjectDisplayed();
    }

    @Step("Create project")
    public ProjectsSteps createProject(Project project) {
        ProjectsPage projectsPage = new ProjectsPage();
        log.info("create project");
        projectsPage.clickCreateNemProjectButton()
                .inputProjectName(project)
                .inputProjectCode(project)
                .clickCreateProjectButton();
        return this;
    }

    @Step("Delete project")
    public ProjectsSteps deleteProject(Project project) {
        ProjectsPage projectsPage = new ProjectsPage();
        log.info("delete project");
        projectsPage.clickProjectsButton()
                .deleteProject(project);
        return this;
    }

    @Step("get list name projets")
    public List<String> listNameProjects() {
        ProjectsPage projectsPage = new ProjectsPage();
        return projectsPage.listNameProjects(projectsPage.listProjects());
    }

    @Step("is name project in projects list")
    public boolean isNameProjectInProjectsList(Project project) {
        ProjectsPage projectsPage = new ProjectsPage();
        log.info("is name project in projects list");
        return projectsPage.isNameProjectInProjectsList((projectsPage.listNameProjects(projectsPage.listProjects())), project.getProjectName());
    }

    @Step("Message data invalid is displayed")
    public boolean messageDataInvalidIsDisplayed() {
        ProjectsPage projectsPage = new ProjectsPage();
        log.info("message 'Data is invalid.' is displayed");
        return projectsPage.isMessageDataInvalidDisplayed();
    }

    @Step("go to project site")
    public ProjectsSteps clickProject(Project project) {
        ProjectsPage projectsPage = new ProjectsPage();
        log.info("click project on projects list");
        projectsPage.clickCancelButton()
                .clickProject(project.getProjectName());
        return this;
    }
}
