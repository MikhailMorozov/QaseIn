package ui.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.model.Case;
import ui.page.ProjectPage;
@Log4j2
public class CaseSteps {

    @Step("Delete case")
    public CaseSteps deleteCase(Case testCase) {
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickCheckboxCase(testCase)
                .clickDeleteButton()
                .inputTextToConfirmDelete()
                .clickDeleteButtonOnFormDeleteCase();
        return this;
    }

    @Step("Message delete case is displayed")
    public boolean messageSuccessDeleteCaseIsDisplayed() {
        ProjectPage projectPage = new ProjectPage();
        log.info("message '1 test case was successfully deleted' is displayed");
        return projectPage.isMessageSuccessDeleteCaseDisplayed();
    }
}
