package ui.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import ui.model.User;
import ui.page.LoginPage;

@Log4j2
public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    @Step("Login on site")
    public LoginSteps login (User user) {
        log.info("Login on site");
        loginPage.openPage()
                .inputUsername(user.getLogin())
                .inputPassword(user.getPassword())
                .clickLoginButton();
        return this;
    }

}
