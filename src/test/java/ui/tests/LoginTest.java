package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.ProjectsSteps;

public class LoginTest extends BaseTest{

    User user = new User("m.s.morozoff@gmail.com","3359347m");

    @Test
    public void loginSiteTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);
        ProjectsSteps projectsSteps = new ProjectsSteps();
        Assert.assertTrue(projectsSteps.buttonCreateNewProjectIsDisplayed(), "Login failed");
    }

}
