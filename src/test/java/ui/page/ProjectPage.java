package ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
@Log4j2
public class ProjectPage extends BasePage{

    private static final By NAME_PROJECT = By.xpath("//div[@class='LALnEw']");


    public String getNameProject() {
        log.info("get name Project");
        return driver.findElement(NAME_PROJECT).getTagName();
    }


}
