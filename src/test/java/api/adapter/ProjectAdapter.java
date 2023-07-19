package api.adapter;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import static utilities.Urls.PROJECT_API_URL;
@Log4j2
public class ProjectAdapter extends BaseAdapter{

    public Response getAllProject() {
        return get(PROJECT_API_URL);
    }

    public Response postCreateNewProject(String body) {
        return post(PROJECT_API_URL, body);
    }

    public Response deleteProject(String codeProject, String body) {
        log.info("delete project, url" + PROJECT_API_URL + "/" + codeProject);
        return delete(PROJECT_API_URL + "/" + codeProject, body);
    }

}
