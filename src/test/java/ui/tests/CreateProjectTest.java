package ui.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ui.model.Project;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import ui.steps.ProjectsSteps;
import utilities.TestDataGenerator;

public class CreateProjectTest extends BaseTest{

    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();
    Project project = new Project(nameProject, codeProject);
    ProjectsSteps projectsSteps = new ProjectsSteps();
    ProjectSteps projectSteps = new ProjectSteps();

    @BeforeClass
    public void setUp() {
        User user = new User("m.s.morozoff@gmail.com","3359347m");
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
    }

    @Test
    public void createProjectTest() {
        projectsSteps.createProject(project);
        Assert.assertEquals(projectSteps.getNameProject(project.getProjectName()),project.getProjectName(), "Project don't created");
    }

    @Test (dependsOnMethods  = "createProjectTest")
    public void createProjectSameCodeProjectTest() {
        projectSteps.clickProjectsButton();
        projectsSteps.createProject(project);
        Assert.assertTrue(projectsSteps.messageDataInvalidIsDisplayed(), "Message don't displayed");
    }

    @AfterClass
    public void cleanUp() {
        projectsSteps.clickProject(project)
                .deleteProject(project);
    }
}
