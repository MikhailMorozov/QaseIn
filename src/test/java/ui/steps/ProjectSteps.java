package ui.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.page.ProjectPage;

@Log4j2
public class ProjectSteps {

    ProjectPage projectPage = new ProjectPage();

    @Step("get name Project")
    public String getNameProject() {
        log.info("get name project");
        return projectPage.getNameProject();
    }

    public String getNameProject(String nameProject) {
        log.info("get name project");
        return projectPage.getNameProject(nameProject);
    }
}
