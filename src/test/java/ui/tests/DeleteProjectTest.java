package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.model.Project;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.ProjectsSteps;
import utilities.TestDataGenerator;

public class DeleteProjectTest extends BaseTest{
    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();
    private String login = System.getProperty("login");
    private String password = System.getProperty("password");
    User user = new User(login,password);
    Project project = new Project(nameProject, codeProject);
    ProjectsSteps projectsSteps = new ProjectsSteps();

    @BeforeMethod
    public void setUp() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        projectsSteps.createProject(project);
    }
    @Test
    public void deleteProjectTest() {
        projectsSteps.deleteProject(project);
        Assert.assertFalse(projectsSteps.isNameProjectInProjectsList(project),"Project don't delete");
    }
}
