package ui.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.Project;
import ui.model.User;
import ui.page.ProjectsPage;
import ui.steps.LoginSteps;
import ui.steps.ProjectsSteps;

public class DeleteProjectTest extends BaseTest{

    Project project = new Project("AQA21", "WE");
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
    }

}