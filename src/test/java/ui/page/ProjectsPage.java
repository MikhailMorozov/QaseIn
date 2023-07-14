package ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
@Log4j2
public class ProjectsPage extends BasePage{

    private static final By CREATE_NEW_PROJECT_BUTTON = By.xpath("//button[@id='createButton']");

    public boolean isButtonCreateNewProjectDisplayed() {
        log.info("is displayed button 'Create new project'");
        return driver.findElement(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
    }

}
