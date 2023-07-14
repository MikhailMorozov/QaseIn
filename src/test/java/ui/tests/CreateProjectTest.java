package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.model.Project;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import ui.steps.ProjectsSteps;

public class CreateProjectTest extends BaseTest{

    @BeforeMethod
    public void setUp() {
        User user = new User("m.s.morozoff@gmail.com","3359347m");
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
    }

    @Test
    public void createProject() {
        Project project = new Project("AQA21", "WE");
        ProjectsSteps projectsSteps = new ProjectsSteps();
        ProjectSteps projectSteps = new ProjectSteps();
        projectsSteps.createProject(project);
        Assert.assertEquals(projectSteps.getNameProject(),project.getProjectName(), "Project don't created");
    }
}
