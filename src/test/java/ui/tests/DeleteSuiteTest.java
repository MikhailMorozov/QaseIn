package ui.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.Project;
import ui.model.Suite;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.ProjectSteps;
import ui.steps.ProjectsSteps;

public class DeleteSuiteTest extends BaseTest{

    Project project = new Project("AQA21", "WE");
    Suite suite = new Suite("TestSuite");
    ProjectsSteps projectsSteps = new ProjectsSteps();
    ProjectSteps projectSteps = new ProjectSteps();

    @BeforeClass
    public void setUp() {
        User user = new User("m.s.morozoff@gmail.com","3359347m");
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        projectsSteps.createProject(project);
        projectSteps.createNewSuite(suite);
    }

    @Test
    public void deleteSuiteTest() {
        projectSteps.deleteSuite(suite);
    }


}
