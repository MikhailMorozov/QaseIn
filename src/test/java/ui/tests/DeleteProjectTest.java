package ui.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.Project;
import ui.model.User;
import ui.page.ProjectsPage;
import ui.steps.LoginSteps;
import ui.steps.ProjectsSteps;
import utilities.TestDataGenerator;

import java.util.List;

public class DeleteProjectTest extends BaseTest{
    private String nameProject = TestDataGenerator.generateNameProject();
    private String codeProject = TestDataGenerator.generateCodeProject();
    Project project = new Project(nameProject, codeProject);
    ProjectsSteps projectsSteps = new ProjectsSteps();

    @BeforeClass
    public void setUp() {
        User user = new User("m.s.morozoff@gmail.com","3359347m");
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
