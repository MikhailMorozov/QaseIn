package ui.tests;

import api.adapter.ProjectAdapter;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.model.Project;
import ui.model.Suite;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import ui.steps.ProjectsSteps;
import utilities.TestDataGenerator;

public class DeleteSuiteTest extends BaseTest{

    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();
    private String nameSuite = TestDataGenerator.generateNameSuite();
    private String login = System.getProperty("login");
    private String password = System.getProperty("password");
    User user = new User(login,password);
    Project project = new Project(nameProject, codeProject);
    Suite suite = new Suite(nameSuite);
    ProjectsSteps projectsSteps = new ProjectsSteps();
    ProjectSteps projectSteps = new ProjectSteps();

    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void deleteSuiteTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        projectsSteps.createProject(project);
        projectSteps.createNewSuite(suite);

        projectSteps.deleteSuite(suite);
        Assert.assertTrue(projectSteps.messageSuccessDeleteSuiteIsDisplayed(), "Suite don't delete");
    }

    @AfterMethod
    public void cleanUp() {
//        projectsSteps.deleteProject(project);

        ProjectAdapter projectAdapter = new ProjectAdapter();
        String requestBody = new Gson().toJson(codeProject);
        projectAdapter.deleteProject(codeProject, requestBody);
    }
}
