package ui.steps;

import ui.model.Case;
import ui.page.NewCasePage;

public class NewCaseSteps {

    public NewCaseSteps createNewCase(Case testCase) {
        ProjectSteps projectSteps = new ProjectSteps();
        projectSteps.createNewCase();
        NewCasePage newCasePage = new NewCasePage();
        newCasePage.createCase(testCase);
        return this;
    }
}
