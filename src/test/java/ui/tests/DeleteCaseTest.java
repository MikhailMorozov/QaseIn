package ui.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ui.model.Case;
import ui.model.Project;
import ui.model.User;
import ui.steps.*;
import utilities.TestDataGenerator;

public class DeleteCaseTest extends BaseTest{

    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();
    private String login = System.getProperty("login");
    private String password = System.getProperty("password");
    User user = new User(login,password);
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
    @BeforeMethod
    public void setUp() {
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
    @AfterMethod
    public void cleanUp() {
        projectsSteps.deleteProject(project);
    }
}
