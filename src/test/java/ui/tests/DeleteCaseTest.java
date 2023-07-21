package ui.tests;

import api.adapter.ProjectAdapter;
import com.google.gson.Gson;
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

    @Test
    public void deleteCaseTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);

        ProjectsSteps projectsSteps = new ProjectsSteps();
        projectsSteps.createProject(project);

        NewCaseSteps newCaseSteps = new NewCaseSteps();
        newCaseSteps.createNewCase(testCase);

        CaseSteps caseSteps = new CaseSteps();
        caseSteps.deleteCase(testCase);

        Assert.assertTrue(caseSteps.messageSuccessDeleteCaseIsDisplayed(), "Case don't delete");
    }
//    @AfterClass
//    public void cleanUp() {
//        ProjectAdapter projectAdapter = new ProjectAdapter();
//        String requestBody = new Gson().toJson(codeProject);
//        projectAdapter.deleteProject(codeProject, requestBody);
//    }
}
