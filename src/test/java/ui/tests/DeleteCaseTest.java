package ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.Case;
import ui.model.Project;
import ui.model.Suite;
import ui.model.User;
import ui.steps.*;
import utilities.TestDataGenerator;

public class DeleteCaseTest extends BaseTest{

    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();
    Project project = new Project(nameProject, codeProject);
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
        NewCaseSteps newCaseSteps = new NewCaseSteps();
        newCaseSteps.createNewCase(testCase);
    }

    @Test
    public void deleteCaseTest() {
        CaseSteps caseSteps = new CaseSteps();
        caseSteps.deleteCase(testCase);
        Assert.assertTrue(caseSteps.messageSuccessDeleteCaseIsDisplayed(), "Case don't delete");
    }
    @AfterClass
    public void cleanUp() {
        projectsSteps.deleteProject(project);
    }
}
