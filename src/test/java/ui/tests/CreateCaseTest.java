package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.Case;
import ui.model.Project;
import ui.model.Suite;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.NewCaseSteps;
import ui.steps.ProjectSteps;
import ui.steps.ProjectsSteps;

public class CreateCaseTest extends BaseTest{
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
    ProjectsSteps projectsSteps = new ProjectsSteps();

    @BeforeClass
    public void setUp() {
        User user = new User("m.s.morozoff@gmail.com","3359347m");
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        projectsSteps.createProject(project);
    }

    @Test
    public void createNewCaseTest() {
        NewCaseSteps newCaseSteps = new NewCaseSteps();
        newCaseSteps.createNewCase(testCase);

    }
}
