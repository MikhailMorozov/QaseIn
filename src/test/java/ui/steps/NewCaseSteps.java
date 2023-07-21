package ui.steps;

import io.qameta.allure.Step;
import ui.model.Case;
import ui.page.NewCasePage;

public class NewCaseSteps {
    @Step("Create new case")
    public NewCaseSteps createNewCase(Case testCase) {
        ProjectSteps projectSteps = new ProjectSteps();
        projectSteps.clickNewCaseButton();
        NewCasePage newCasePage = new NewCasePage();
        newCasePage.createCase(testCase)
                .clickSaveCaseButton();
        return this;
    }
}
