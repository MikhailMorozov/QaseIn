package ui.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ui.model.Project;
import ui.model.Suite;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import ui.steps.ProjectsSteps;
import utilities.TestDataGenerator;

public class CreateSuiteTest extends BaseTest{

    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();
    private String nameSuite = TestDataGenerator.generateNameSuite();

    private String login = System.getProperty("login");
    private String password = System.getProperty("password");
    User user = new User(login,password);
    Project project = new Project(nameProject, codeProject);
    Suite suite = new Suite(nameSuite);

    ProjectsSteps projectsSteps = new ProjectsSteps();

    @BeforeMethod
    public void setUp() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        projectsSteps.createProject(project);
    }

    @Test
    public void createNewSuiteTest() {
        ProjectSteps projectSteps = new ProjectSteps();
        projectSteps.createNewSuite(suite);
        Assert.assertTrue(projectSteps.messageSuccessCreateNewSuiteIsDisplayed(), "Suite don't create");
    }
    @AfterMethod
    public void cleanUp() {
        projectsSteps.deleteProject(project);
    }
}
