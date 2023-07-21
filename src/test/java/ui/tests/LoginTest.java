package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.model.User;
import ui.steps.LoginSteps;
import ui.steps.ProjectsSteps;

public class LoginTest extends BaseTest{

    private String login = System.getProperty("login");
    private String password = System.getProperty("password");
    User user = new User(login,password);
    @Test
    public void loginSiteTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login(user);

        ProjectsSteps projectsSteps = new ProjectsSteps();
        Assert.assertTrue(projectsSteps.buttonCreateNewProjectIsDisplayed(), "Login failed");
    }
}
