package ui.steps;

import ui.model.Case;
import ui.page.ProjectPage;

public class CaseSteps {

    public CaseSteps deleteCase(Case testCase) {
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickCheckboxCase(testCase)
                .clickDeleteButton()
                .inputTextToConfirmDelete()
                .clickDeleteButtonOnFormDeleteCase();
        return this;
    }
}
