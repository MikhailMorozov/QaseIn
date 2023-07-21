package ui.tests;

import api.adapter.ProjectAdapter;
import com.google.gson.Gson;
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
    private String login = System.getProperty("login");
    private String password = System.getProperty("password");
    User user = new User(login,password);
    Project project = new Project(nameProject, codeProject);

    @BeforeClass
    public void setUp() {
//        LoginSteps loginSteps = new LoginSteps();
//        loginSteps.login(user);
    }

    @Test
    public void createProjectTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        ProjectsSteps projectsSteps = new ProjectsSteps();
        ProjectSteps projectSteps = new ProjectSteps();
        projectsSteps.createProject(project);
        Assert.assertEquals(projectSteps.getNameProject(project.getProjectName()),project.getProjectName(), "Project don't created");
    }

    @Test (dependsOnMethods  = "createProjectTest")
    public void createProjectSameCodeProjectTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        ProjectsSteps projectsSteps = new ProjectsSteps();
        ProjectSteps projectSteps = new ProjectSteps();
        projectSteps.clickProjectsButton();
        projectsSteps.createProject(project);
        Assert.assertTrue(projectsSteps.messageDataInvalidIsDisplayed(), "Message don't displayed");
    }

    @AfterClass
    public void cleanUp() {
//        ProjectsSteps projectsSteps = new ProjectsSteps();
//        projectsSteps.clickProject(project)
//                .deleteProject(project);

        ProjectAdapter projectAdapter = new ProjectAdapter();
        String requestBody = new Gson().toJson(codeProject);
        projectAdapter.deleteProject(codeProject, requestBody);
    }
}
