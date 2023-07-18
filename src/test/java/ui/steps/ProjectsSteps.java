package ui.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.model.Project;
import ui.page.ProjectsPage;

import java.util.List;

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
        projectsPage.clickProjectsButton()
                .deleteProject(project);
        return this;
    }

    @Step("get list name projets")
    public List<String> listNameProjects() {
        return projectsPage.listNameProjects(projectsPage.listProjects());
    }

    @Step("is name project in projects list")
    public boolean isNameProjectInProjectsList(Project project) {
        log.info("is name project in projects list");
        return projectsPage.isNameProjectInProjectsList((projectsPage.listNameProjects(projectsPage.listProjects())), project.getProjectName());
    }
}
