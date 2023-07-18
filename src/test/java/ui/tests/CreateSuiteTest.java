package ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    Project project = new Project(nameProject, codeProject);
    Suite suite = new Suite(nameSuite);

    ProjectsSteps projectsSteps = new ProjectsSteps();

    @BeforeClass
    public void setUp() {
        User user = new User("m.s.morozoff@gmail.com","3359347m");
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
    @AfterClass
    public void cleanUp() {
        projectsSteps.deleteProject(project);
    }
}
