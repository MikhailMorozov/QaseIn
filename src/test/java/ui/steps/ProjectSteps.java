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
    public ProjectSteps clickNewCaseButton() {
        log.info("click new case button");
        projectPage.clickCreateCaseButton();
        return this;
    }

    @Step("Message new case create is displayed")
    public boolean messageSuccessCreateNewSuitCaseIsDisplayed() {
        log.info("message 'Test case was created successfully!' is displayed");
        return projectPage.isMessageSuccessCreateNewCaseDisplayed();
    }

    @Step("Message delete suite is displayed")
    public boolean messageSuccessDeleteSuiteIsDisplayed() {
        log.info("message 'Suite was successfully deleted' is displayed");
        return projectPage.isMessageSuccessDeleteSuiteDisplayed();
    }

    @Step("go to projects site")
    public ProjectSteps clickProjectsButton() {
        log.info("click Projects button");
        projectPage.clickProjectsButton();
        return this;
    }
}
