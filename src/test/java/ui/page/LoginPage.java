package ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utilities.Urls;
@Log4j2
public class LoginPage extends BasePage{

    private static final By EMAIL_INPUT = By.xpath("//input[@placeholder='E-Mail']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@placeholder='Password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");

    public LoginPage openPage () {
        driver.get(Urls.BASE_UI_URL+Urls.LOGIN_UI_URL);
        return this;
    }

    public LoginPage inputUsername(String username) {
        log.info("Enter login");
        driver.findElement(EMAIL_INPUT).sendKeys(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        log.info("Enter password");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        log.info("Click on the login button");
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }


}
