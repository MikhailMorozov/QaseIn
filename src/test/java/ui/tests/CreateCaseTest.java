package ui.tests;

import api.adapter.ProjectAdapter;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.model.Case;
import ui.model.Project;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.NewCaseSteps;
import ui.steps.ProjectSteps;
import ui.steps.ProjectsSteps;
import utilities.TestDataGenerator;

public class CreateCaseTest extends BaseTest{
    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();
    private String titleCase = TestDataGenerator.generateTitleCase();
    private String login = System.getProperty("login");
    private String password = System.getProperty("password");
    User user = new User(login,password);
    Project project = new Project(nameProject, codeProject);
    Case testCase = Case.builder()
            .title(titleCase)
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


    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void createNewCaseTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);

        ProjectsSteps projectsSteps = new ProjectsSteps();
        projectsSteps.createProject(project);

        NewCaseSteps newCaseSteps = new NewCaseSteps();
        newCaseSteps.createNewCase(testCase);

        ProjectSteps projectSteps = new ProjectSteps();
        Assert.assertTrue(projectSteps.messageSuccessCreateNewSuitCaseIsDisplayed(), "Case don't create");
    }

    @AfterMethod
    public void cleanUp() {
//        ProjectsSteps projectsSteps = new ProjectsSteps();
//        projectsSteps.deleteProject(project);

//        ProjectAdapter projectAdapter = new ProjectAdapter();
//        String requestBody = new Gson().toJson(codeProject);
//        projectAdapter.deleteProject(codeProject, requestBody);
    }
}
