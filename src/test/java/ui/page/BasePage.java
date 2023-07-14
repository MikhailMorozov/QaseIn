package ui.page;

import org.openqa.selenium.WebDriver;
import ui.driver.DriverSingleton;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverSingleton.getInstance().getDriver();
    }
}
