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


    @BeforeMethod
    public void setUp() {

    }
    @Test
    public void deleteProjectTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        ProjectsSteps projectsSteps = new ProjectsSteps();
        projectsSteps.createProject(project);

        projectsSteps.deleteProject(project);
        Assert.assertFalse(projectsSteps.isNameProjectInProjectsList(project),"Project don't delete");
    }
}
