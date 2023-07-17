package ui.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.model.Project;
import ui.model.Suite;
import ui.page.ProjectPage;

@Log4j2
public class ProjectSteps {

    ProjectPage projectPage = new ProjectPage();

    @Step("get name Project")
    public String getNameProject() {
        log.info("get name project");
        return projectPage.getNameProject();
    }

    @Step("get name Project")
    public String getNameProject(String nameProject) {
        log.info("get name project");
        return projectPage.getNameProject(nameProject);
    }

    @Step("create new suite")
    public ProjectSteps createNewSuite(Suite suite) {
        log.info("get name project");
        projectPage.clickCreateSuiteButton()
                .inputSuiteName(suite)
                .clickCreateSuiteOnFormButton();
        return this;
    }

    @Step("suite is displayed")
    public boolean messageSuccessCreateNewSuiteIsDisplayed() {
        log.info("message 'Suite was successfully created.' is displayed");
        return projectPage.isMessageSuccessCreateNewSuiteDisplayed();
    }

    @Step("Delete suite")
    public ProjectSteps deleteSuite(Suite suite) {
        log.info("delete suite");
        projectPage.deleteSuite(suite);
        return this;
    }

    @Step("click new case")
    public ProjectSteps createNewCase() {
        log.info("click new case button");
        projectPage.clickCreateCaseButton();
        return this;
    }
}
