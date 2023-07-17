package ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j2
public class ProjectPage extends BasePage{

    private static final By NAME_PROJECT = By.xpath("//div[@class='LALnEw']");
    private static final String NAME_PROJECT_XPATH = "//*[contains(text(),'%s')]";
    private static final By PROJECTS_BUTTON = By.xpath("//a[contains(text(),'Projects')]");



    public String getNameProject() {
        log.info("get name Project");
        return driver.findElement(NAME_PROJECT).getText();
    }

    public String getNameProject(String nameProject) {
        log.info("get name Project");
        return driver.findElement(By.xpath(String.format(NAME_PROJECT_XPATH, nameProject))).getText();
    }

    public ProjectPage clickProjectsButton() {
        log.info("click project button");
        driver.findElement(PROJECTS_BUTTON).click();
        return this;
    }

}
