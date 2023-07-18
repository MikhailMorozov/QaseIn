package ui.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.Case;
import ui.model.Project;
import ui.model.Suite;
import ui.model.User;
import ui.steps.*;

public class DeleteCaseTest extends BaseTest{

    Project project = new Project("AQA21", "WE");
    Case testCase = Case.builder()
            .title("TestCase")
            .status("Draft")
            .suite("Test cases without suite")
            .severity("Critical")
            .priority("High")
            .type("Functional")
            .layer("E2E")
            .isFlaky("Yes")
            .behavior("Positive")
            .automationStatus("To be automated")
            .build();



    @BeforeClass
    public void setUp() {
        User user = new User("m.s.morozoff@gmail.com","3359347m");
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        ProjectsSteps projectsSteps = new ProjectsSteps();
        projectsSteps.createProject(project);
        NewCaseSteps newCaseSteps = new NewCaseSteps();
        newCaseSteps.createNewCase(testCase);
    }

    @Test
    public void deleteCaseTest() {
        CaseSteps caseSteps = new CaseSteps();
        caseSteps.deleteCase(testCase);

    }

}
